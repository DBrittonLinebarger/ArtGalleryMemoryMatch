package edu.cnm.deepdive.gallery_match.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import edu.cnm.deepdive.gallery_match.model.database.MemoryMatchDatabase;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import edu.cnm.deepdive.gallery_match.model.pojo.Result;
import edu.cnm.deepdive.gallery_match.service.MetWebService;
import io.reactivex.schedulers.Schedulers;
import java.util.List;


public class ThemeViewModel extends AndroidViewModel {

  private LiveData<List<Theme>> themes;
  private MutableLiveData<Result> searchResult;

  public ThemeViewModel(@NonNull Application application) {
    super(application);
  }

  public LiveData<List<Theme>> getThemes(){
    if (themes == null){
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
      service.search(searchTerm)
          .subscribeOn(Schedulers.io())
          .subscribe((result) -> {
            Theme theme = new Theme();
            theme.setTitle(searchTerm);
            long themeId = database.getThemeDao().insert(theme);
            for (int id : result.getObjectIds()) {
              service.get(id)
                  .subscribeOn(Schedulers.io())
                  .subscribe((card) -> {
                    card.setThemeId(themeId);
                    database.getCardDao().insert(card);
                  });
            }
          });



    }
    return searchResult;
  }



  public void addNewTheme(final Long themeId, final Theme newTheme) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        long themeId = MemoryMatchDatabase.getInstance(getApplication()).getThemeDao().insert(newTheme);
        Theme theme = new Theme();
        MemoryMatchDatabase.getInstance(getApplication()).getThemeDao().insert(theme);
      }
    }).start();

  }


}
