package edu.cnm.deepdive.gallery_match.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.gallery_match.R;

public class Game4x4ActivityFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater,
      ViewGroup container,
      Bundle savedInstanceState) {
    //Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.game4x4activity_fragment,
        container, false);
    return view;
  }


}
