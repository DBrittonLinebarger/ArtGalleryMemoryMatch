package edu.cnm.deepdive.gallery_match.viewmodel;

import android.app.Application;
import android.util.Log;
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
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import java.util.Arrays;
import java.util.List;


public class ThemeViewModel extends AndroidViewModel implements LifecycleObserver {

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

      MetWebService service = MetWebService.getInstance();
      MemoryMatchDatabase database = MemoryMatchDatabase.getInstance(getApplication());
      pending.add(
          service.search(searchTerm)
              .subscribeOn(Schedulers.single())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe((result) -> searchResult.setValue(result)
              ));
    } else {
      searchResult.setValue(new Result());

    }
    return searchResult;
  }

// TODO create method for this to happen right here in viewmodel

  //  Theme theme = new Theme();
  //  theme.setTitle(searchTerm);
  //  long themeId = database.getThemeDao().insert(theme);

  public void addNewTheme(final Long themeId, final Theme newTheme) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        long themeId = MemoryMatchDatabase.getInstance(getApplication()).getThemeDao()
            .insert(newTheme);
        Theme theme = new Theme();
        MemoryMatchDatabase.getInstance(getApplication()).getThemeDao().insert(theme);
      }
    }).start();

  }


   //TODO create method for this to happen right here in viewmodel; ?? what is wrong?
  // public void addCard() {
  //  for (int id : result.getObjectIds()) {
  //    pending.add(
  //        service.get(id)
  //            .subscribeOn(Schedulers.single())
  //            .subscribe((card) -> {
  //              card.setThemeId(themeId);
  //              new Thread(() -> database.getCardDao().insert(card)).start();
  //            })
  //    );
  //  }
  //}

  // TODO select random subset of 8 from results


  @OnLifecycleEvent(Event.ON_STOP)
  public void disposePending() {
    pending.clear();
  }


}
