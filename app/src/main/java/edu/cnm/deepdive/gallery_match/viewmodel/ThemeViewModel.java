package edu.cnm.deepdive.gallery_match.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.gallery_match.model.database.MemoryMatchDatabase;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import java.util.List;


public class ThemeViewModel extends AndroidViewModel {

  private LiveData<List<Theme>> theme;

  public ThemeViewModel(@NonNull Application application) {
    super(application);
  }

  public LiveData<List<Theme>> getThemesLiveData(){
    if(theme == null){
      theme = MemoryMatchDatabase.getInstance(getApplication()).getThemeDao().getAll();
    }
    return theme;
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
