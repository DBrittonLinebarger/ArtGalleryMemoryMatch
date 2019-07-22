package edu.cnm.deepdive.gallery_match.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.gallery_match.model.database.MemoryMatchDatabase;
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import edu.cnm.deepdive.gallery_match.model.pojo.Result;
import edu.cnm.deepdive.gallery_match.service.MetWebService;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * returns result of search for images matching theme
 */
public class ThemeViewModel extends AndroidViewModel implements LifecycleObserver {

  /**
   * minimum number of objects needed for cards to play a 4x4 game grid
   */
  public static final int MIN_CARDS = 8;

  /**
   * number of objects selected for database from total returned
   */
  public static final int PREFERRED_CARDS = 50;


  private MutableLiveData<Boolean> busy;
  private LiveData<List<Theme>> themes;
  private MutableLiveData<Result> searchResult;
  private CompositeDisposable pending = new CompositeDisposable();

  /**
   * ......
   *
   * @param application .....
   */
  public ThemeViewModel(@NonNull Application application) {
    super(application);

  }

  /**
   * gets instance of this viewmodel
   *
   * @return instance of ThemeViewModel
   */
  public ThemeViewModel getInstance() {
    return this;

  }

  /**
   * gets list of all themes
   *
   * @return list of themes
   */
  public LiveData<List<Theme>> getThemes() {
    if (themes == null) {
      themes = MemoryMatchDatabase.getInstance(getApplication()).getThemeDao().getAll();
    }

    return themes;
  }

  /**
   * adds result of search to database
   *
   * @param searchTerm term inputted by user to create a theme
   * @return result of search
   */
  public LiveData<Result> getSearchResult(String searchTerm) {
    if (searchResult == null) {
      searchResult = new MutableLiveData<>();
    }
    if (searchTerm != null) {
      busy.setValue(true);

      MetWebService service = MetWebService.getInstance();
      MemoryMatchDatabase database = MemoryMatchDatabase.getInstance(getApplication());
      pending.add(
          service.search(searchTerm)
              .subscribeOn(Schedulers.single())
              .subscribe((result) -> {
                searchResult.postValue(result);
                busy.postValue(false);

              }));
    } else {
      searchResult.setValue(new Result());

    }
    return searchResult;
  }

  /**
   * creates theme, sets a title for it and inserts cards into database by theme
   *
   * @param themeName title for theme
   * @param objectIds ids of images from the Metropolitan Museum of Art Collection API
   */
  public void createTheme(String themeName, int[] objectIds) {
    MetWebService service = MetWebService.getInstance();
    MemoryMatchDatabase database = MemoryMatchDatabase.getInstance(getApplication());
    Theme theme = new Theme();
    theme.setTitle(themeName);
    int subsetSize = Math.min(objectIds.length, PREFERRED_CARDS);
    List<Integer> ids = new ArrayList<>();
    for (int id : objectIds) {
      ids.add(id);
    }
    Collections.shuffle(ids);
    new Thread(() -> {
      busy.postValue(true);

      long themeId = database.getThemeDao().insert(theme);

      for (int id : ids.subList(0, subsetSize)) {
        pending.add(
            service.get(id)
                .subscribeOn(Schedulers.single())
                .subscribe((card) -> {
                  card.setThemeId(themeId);
                  database.getCardDao().insert(card);
                  if (id == ids.get(subsetSize - 1)) {
                    busy.postValue(false);
                  }
                })
        );
      }
    }).start();

  }

  /**
   * gets list of cards based on theme
   *
   * @param theme generated by search term inputted by user
   * @return list of cards
   */
  public LiveData<List<Card>> getCards(Theme theme) {
    MemoryMatchDatabase database = MemoryMatchDatabase.getInstance(getApplication());
    return database.getCardDao().get(theme.getId());
  }

  /**
   * gets theme searched for
   *
   * @param themeTitle title for selected themes
   * @return themes by title
   */
  public LiveData<Theme> getTheme(String themeTitle) {
    MemoryMatchDatabase database = MemoryMatchDatabase.getInstance(getApplication());
    return database.getThemeDao().selectThemeByTitle(themeTitle);
  }

  /**
   * clears list?
   */
  @OnLifecycleEvent(Event.ON_STOP)
  public void disposePending() {
    pending.clear();
  }

  /**
   * presents progress indicator while data is being downloaded
   *
   * @return busy signal until data is available
   */
  public LiveData<Boolean> getBusy() {
    if (busy == null) {
      busy = new MutableLiveData<>();
      busy.setValue(false);

    }
    return busy;
  }


}
