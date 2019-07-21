package edu.cnm.deepdive.gallery_match.model.pojo;

import edu.cnm.deepdive.gallery_match.model.entity.Card;

public class GameTile {

  private final Card card;
  private boolean faceUp;


  public GameTile(Card card) {
    this.card = card;
  }

  public Card getCard() {
    return card;
  }

  public boolean isFaceUp() {
    return faceUp;
  }

  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }
}
