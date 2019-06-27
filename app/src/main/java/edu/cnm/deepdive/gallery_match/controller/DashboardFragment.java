package edu.cnm.deepdive.gallery_match.controller;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.gallery_match.R;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import edu.cnm.deepdive.gallery_match.viewmodel.ThemeViewModel;
import java.util.List;

public class DashboardFragment extends Fragment {

  //private Button button4x4;
  private Context context;
  public static DashboardFragment newInstance(){
    return new DashboardFragment();
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    this.context = context;
  }

  @Override
  public View onCreateView(LayoutInflater inflater,
      ViewGroup container,
      Bundle savedInstanceState) {
    //Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_dashboard,
        container, false);

    final ThemeViewModel themeViewModel = ViewModelProviders.of(getActivity())
        .get(ThemeViewModel.class);
    themeViewModel.getThemesLiveData().observe(this, theme -> {
      final Spinner themeSpinner = view.findViewById(R.id.theme_spinner);
      SpinnerAdapter spinnerAdapter = new ArrayAdapter<>(context,
          android.R.layout.simple_spinner_item, theme);
      themeSpinner.setAdapter(spinnerAdapter);
    });

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
