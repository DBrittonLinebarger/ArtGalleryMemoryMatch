package edu.cnm.deepdive.gallery_match.controller;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import edu.cnm.deepdive.gallery_match.R;
import edu.cnm.deepdive.gallery_match.model.GameLogic;
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import edu.cnm.deepdive.gallery_match.model.entity.Game;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import edu.cnm.deepdive.gallery_match.model.pojo.GameTile;
import edu.cnm.deepdive.gallery_match.view.CardAdapter;
import edu.cnm.deepdive.gallery_match.view.CardAdapter.OnTileClickListener;
import edu.cnm.deepdive.gallery_match.viewmodel.GameViewModel;
import java.util.List;

public class GameFragment extends Fragment implements OnTileClickListener {

  private static final String KEY = "key"; //***
  private Game game;
  private RecyclerView gameGridview;
  private Theme theme; //***
  private List<Card> cards;
  private GameViewModel gameViewModel;
  private GameLogic gameLogic;
  private CardAdapter cardAdapter;
  private int matchCount = 0;
  private int turnCount = 0;
  private TextView matchCountView;
  private TextView turnCountView;


  public static GameFragment newInstance(Theme theme) { //***
    GameFragment fragment = new GameFragment();
    Bundle bundle = new Bundle();
    bundle.putParcelable(KEY, theme);
    fragment.setArguments(bundle);

    return fragment;
  }


  @Override
  public View onCreateView(LayoutInflater inflater,
      ViewGroup container,
      Bundle savedInstanceState) {
    //Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_game,
        container, false);
    theme = (Theme) getArguments().getParcelable(KEY);//***
    gameGridview = view.findViewById(R.id.game_gridview);
    gameGridview.setLayoutManager(new GridLayoutManager(getContext(), 4));
    gameViewModel = ViewModelProviders.of(this).get(GameViewModel.class);
    matchCountView = view.findViewById(R.id.matchCount);
    turnCountView = view.findViewById(R.id.turnCount);

    gameViewModel.getCards(theme).observe(this, (cards) -> {
      gameLogic = new GameLogic(cards);

      cardAdapter = new CardAdapter(getContext(), gameLogic.getTiles(), this);
      gameGridview.setAdapter(cardAdapter);
    });

    return view;
  }


  @Override
  public void click(GameTile tile, int position) {
    if (gameLogic.clickTile(tile)) {
      cardAdapter.notifyDataSetChanged();
      turnCount = gameViewModel.getTurnCount(gameLogic);
      turnCountView.setText(Integer.toString(turnCount));
      if (gameViewModel.getMatchCount(gameLogic) > matchCount) {
        matchCount = gameViewModel.getMatchCount(gameLogic);
        matchCountView.setText(Integer.toString(matchCount));
      }

    }

  }


}



