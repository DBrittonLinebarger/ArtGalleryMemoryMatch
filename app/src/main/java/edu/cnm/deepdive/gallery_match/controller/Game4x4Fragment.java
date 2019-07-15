package edu.cnm.deepdive.gallery_match.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.gallery_match.R;
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import edu.cnm.deepdive.gallery_match.model.entity.Game;
import java.util.ArrayList;
import java.util.List;

public class Game4x4Fragment extends Fragment {

  private Game game;
  private GridView gridView;
  //private ListView. gridadapter;
  //private GridView.LayoutManager layoutManager;

  private List<Card> cards;

  public static Game4x4Fragment newInstance(){
    return new Game4x4Fragment();
  }

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater,
      ViewGroup container,
      Bundle savedInstanceState) {
    //Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_game4x4,
        container, false);
    cards = new ArrayList<>();


    return view;
  }


}


