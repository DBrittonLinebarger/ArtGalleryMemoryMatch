package edu.cnm.deepdive.gallery_match;

import android.app.Application;
import com.facebook.stetho.Stetho;
import edu.cnm.deepdive.gallery_match.model.database.MemoryMatchDatabase;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;

public class MemoryMatchApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Stetho.initializeWithDefaults(this);
    new Thread(() -> {
      Theme theme = new Theme();
      theme.setTitle("Testing");
      MemoryMatchDatabase.getInstance(this).getThemeDao().insert(theme);
    }).start();
  }
}
