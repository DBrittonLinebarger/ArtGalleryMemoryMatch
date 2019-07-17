package edu.cnm.deepdive.gallery_match.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import edu.cnm.deepdive.gallery_match.R;
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import edu.cnm.deepdive.gallery_match.model.entity.Game;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import java.util.ArrayList;
import java.util.List;

public class GameFragment extends Fragment {

  private Game game;
  private GridView gridView;
  private Theme theme;
  //private ListView. gridadapter;
  //private GridView.LayoutManager layoutManager;

  private List<Card> cards;
  private static final String KEY = "key";



  public static GameFragment newInstance(Theme theme){
    GameFragment fragment = new GameFragment();
    Bundle bundle = new Bundle();
    bundle.putParcelable(KEY, theme);
    fragment.setArguments(bundle);

    return fragment;
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    theme = (Theme)getArguments().getParcelable(KEY);

  }

  @Override
  public View onCreateView(LayoutInflater inflater,
      ViewGroup container,
      Bundle savedInstanceState) {
    //Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_game,
        container, false);
    cards = new ArrayList<>();


    return view;
  }


}


