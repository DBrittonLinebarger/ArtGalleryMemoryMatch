package edu.cnm.deepdive.gallery_match.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog.Builder;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import edu.cnm.deepdive.gallery_match.R;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import edu.cnm.deepdive.gallery_match.viewmodel.ThemeViewModel;

public class DashboardFragment extends Fragment {

  private Button button4x4;
  private ProgressBar progressIndicator;
  private Spinner themeSpinner;//**

  public static DashboardFragment newInstance() {
    return new DashboardFragment();
  }


  @Override
  public View onCreateView(LayoutInflater inflater,
      ViewGroup container,
      Bundle savedInstanceState) {
    //Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_dashboard,
        container, false);
    progressIndicator = view.findViewById(R.id.progress_indicator);
    themeSpinner = view.findViewById(R.id.theme_spinner);
    final ThemeViewModel themeViewModel = ViewModelProviders.of(getActivity())
        .get(ThemeViewModel.class);
    themeViewModel.getBusy().observe(this, (busy) -> {
      if (busy) {
        progressIndicator.setVisibility(View.VISIBLE);

      } else {
        progressIndicator.setVisibility(View.GONE);

      }

    });

    ImageButton button4x4 =  view.findViewById(R.id.button_4x4_game);
    themeViewModel.getThemes().observe(this, themes -> {
      // themeSpinner = view.findViewById(R.id.theme_spinner);//**
      ArrayAdapter<Theme> spinnerAdapter = new ArrayAdapter<>(getContext(),
          android.R.layout.simple_spinner_item, themes);
      themeSpinner.setAdapter(spinnerAdapter);
      button4x4.setEnabled(!themes.isEmpty());

    });
    ImageButton search = view.findViewById(R.id.button_search);
    EditText searchTerm = view.findViewById(R.id.search_term);
    search.setOnClickListener((v) -> {

      themeViewModel.getSearchResult(searchTerm.getText().toString().trim())
          .observe(this, result -> {
            int[] objectIds = result.getObjectIds();


            if (objectIds.length < ThemeViewModel.MIN_CARDS) {
              searchTerm.getText().clear();
              new Builder(getContext())
                  .setTitle("Cannot create theme")
                  .setMessage(
                      String.format("Search returned %d images; unable to create a theme.", objectIds.length ))
                  .setPositiveButton("OK", (dialog, which) -> {})
                  .create()
                  .show();
            } else {
              Builder builder = new Builder(getContext())
                  .setTitle("Create Theme")
                  .setNegativeButton("Cancel", (dialog, which) -> {});
              View alertView = LayoutInflater.from(builder.getContext()).inflate(R.layout.alert_theme, null);
              TextView themeInfo = alertView.findViewById(R.id.theme_info);
              EditText themeTitle = alertView.findViewById(R.id.theme_title);
              themeInfo.setText(String.format("Search returned %d images.", objectIds.length));
              themeTitle.setText(searchTerm.getText().toString());
              builder
                  .setView(alertView)
                  .setPositiveButton("OK", (dialog, which) -> {
                    String title = themeTitle.getText().toString().trim();

                    themeViewModel.createTheme(title, objectIds);
                    searchTerm.getText().clear();
                  })
                  .create()
                  .show();
            }

          });

    });



    button4x4.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        Theme theme = (Theme) themeSpinner.getSelectedItem();
        Fragment fragment = GameFragment.newInstance(theme);
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.container, fragment);
        transaction.commit();
      }
    });
    return view;
  }

}
