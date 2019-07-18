package edu.cnm.deepdive.gallery_match.model;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LiveData;
import edu.cnm.deepdive.gallery_match.model.database.MemoryMatchDatabase;
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import edu.cnm.deepdive.gallery_match.model.pojo.GameTile;
import edu.cnm.deepdive.gallery_match.viewmodel.ThemeViewModel;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class GameLogic {

  private  List<Card> cards;
  private List<GameTile> tiles = new ArrayList<>();
  private List<GameTile> solved = new ArrayList<>();
  private List<GameTile> current = new ArrayList<>();
  private List<GameTile> unsolved = new ArrayList<>();
  private int turn;


  public GameLogic(List<Card> cards) {
    this.cards = new ArrayList<>(cards);
    Collections.shuffle(this.cards);
    for (Card card : this.cards.subList(0, ThemeViewModel.MIN_CARDS)) {
      tiles.add(new GameTile(card));
      tiles.add(new GameTile(card));
      // TODO Can we tell Picasso to cache the image at card.getUrl()?
    }
    Collections.shuffle(tiles);
  }

  public List<GameTile> getTiles() {
    return tiles;
  }

  public boolean clickTile(GameTile tile) {
    boolean update = false;

    if (!solved.contains(tile)) {
      if (!current.contains(tile) && current.size() < 2) {
        tile.setFaceUp(true);
        current.add(tile);
        update = true;
        if (current.size() == 2 && tile.getCard().getUrl().equals(current.get(0).getCard().getUrl())) {
          solved.addAll(current);
          unsolved.removeAll(current);
          current.clear();
          turn++;
        }
        else if (current.size() == 2) {
          //TODO mark cards as not a match
        }

      } else if (current.size() == 2){
        for (GameTile t : current) {
          t.setFaceUp(false);
        }
        current.clear();
        current.add(tile);
        tile.setFaceUp(true);
        update = true;
        turn++;

      } else if (!current.contains(tile)) {
        current.add(tile);
        update = true;
        tile.setFaceUp(true);
      }

    }

    return update;
  }

  public int getTurn() {
    return turn;
  }
}



