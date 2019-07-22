//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.model.pojo;

import edu.cnm.deepdive.gallery_match.model.entity.Card;

/**
 * checks to see if current card is faceUp
 */
public class GameTile {

  private final Card card;
  private boolean faceUp;


  /**
   * initializes this instance using the specified card instance
   * @param card ...
   */
  public GameTile(Card card) {
    this.card = card;
  }

  /**
   * returns card for this instance
   */
  public Card getCard() {
    return card;
  }

  /**
   * checks to see if game tile is faceup
   * @return true if tile is faceup, false if it is not faceup
   */
  public boolean isFaceUp() {
    return faceUp;
  }

  /**
   * sets faceup for this instance if back of tile is not showing
   */
  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }
}
