package edu.cnm.deepdive.gallery_match.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.gallery_match.R;
import edu.cnm.deepdive.gallery_match.viewmodel.ThemeViewModel;

public class DashboardFragment extends Fragment {

  //private Button button4x4;

  public static DashboardFragment newInstance(){
    return new DashboardFragment();
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
    themeViewModel.getThemes().observe(this, theme -> {
      final Spinner themeSpinner = view.findViewById(R.id.theme_spinner);
      SpinnerAdapter spinnerAdapter = new ArrayAdapter<>(getContext(),
          android.R.layout.simple_spinner_item, theme);
      themeSpinner.setAdapter(spinnerAdapter);
    });
    Button search = view.findViewById(R.id.button_search);
    EditText searchTerm = view.findViewById(R.id.search_term);
    search.setOnClickListener((v) ->
        themeViewModel.getSearchResult(searchTerm.getText().toString().trim()).observe(this,
            result -> {}));
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
