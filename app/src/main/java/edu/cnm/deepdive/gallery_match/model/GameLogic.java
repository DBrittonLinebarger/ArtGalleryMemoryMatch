package edu.cnm.deepdive.gallery_match.model;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import edu.cnm.deepdive.gallery_match.R;
import java.net.URL;

public class GameLogic {

  int[] pos = {0, 1, 2, 3, 4, 5, 6, 7, 8};
  int currentPosition = -1;


  private  URL imageUrl;
  private View view;


  public URL getImageUrl() {
    return imageUrl;
  }




}
