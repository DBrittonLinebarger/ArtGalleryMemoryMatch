package edu.cnm.deepdive.gallery_match.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.gallery_match.R;

public class DashboardFragment extends Fragment {

  //private Button button4x4;

  @Override
  public View onCreateView(LayoutInflater inflater,
      ViewGroup container,
      Bundle savedInstanceState) {
    //Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.dashboard_fragment,
        container, false);
    return view;

    //button4x4 = (Button)findViewById(R.id.button_4x4_game);

    //button4x4.setOnClickListener(new OnClickListener()) {
    //  @Override
    //      public void onClick(View view) {
    //    Intent intent = new Intent(DashboardFragment.this, Game4x4ActivityFragment.class);
    //  }
    //}
  }

}
