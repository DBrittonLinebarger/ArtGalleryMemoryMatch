package edu.cnm.deepdive.gallery_match;

import android.app.Application;
import com.facebook.stetho.Stetho;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.gallery_match.service.HighScoreService;

/**
 * This class represents a Gallery Match Android application
 *
 * @author Denelle Britton Linebarger
 */
public class MemoryMatchApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    HighScoreService.setContext(this);
    Picasso.setSingletonInstance(new Picasso.Builder(this).build());
    Stetho.initializeWithDefaults(this);
  }
}

