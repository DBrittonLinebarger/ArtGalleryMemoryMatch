package edu.cnm.deepdive.gallery_match;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.gallery_match.model.database.MemoryMatchDatabase;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;

public class MemoryMatchApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    Picasso.setSingletonInstance(new Picasso.Builder(this).build());
    Stetho.initializeWithDefaults(this);
    new Thread(() -> {
      //Theme theme = new Theme();
      //theme.setTitle("Testing");
      MemoryMatchDatabase.getInstance(this).getThemeDao().delete();
    }).start();
  }
}

