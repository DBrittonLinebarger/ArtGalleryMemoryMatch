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
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import edu.cnm.deepdive.gallery_match.model.pojo.Result;
import edu.cnm.deepdive.gallery_match.service.MetWebService;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ThemeViewModel extends AndroidViewModel implements LifecycleObserver {

  public static final int MIN_CARDS = 8;
  public static final int PREFERRED_CARDS = 50;


  private MutableLiveData<Boolean> busy;
  private LiveData<List<Theme>> themes;
  private MutableLiveData<Result> searchResult;
  private CompositeDisposable pending = new CompositeDisposable();

  public ThemeViewModel(@NonNull Application application) {
    super(application);
  }

  public LiveData<List<Theme>> getThemes() {
    if (themes == null) {
      themes = MemoryMatchDatabase.getInstance(getApplication()).getThemeDao().getAll();
    }

    return themes;
  }

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

  @OnLifecycleEvent(Event.ON_STOP)
  public void disposePending() {
    pending.clear();
  }

  public LiveData<Boolean> getBusy() {
    if (busy == null) {
      busy = new MutableLiveData<>();
      busy.setValue(false);

    }
    return busy;
  }


}
