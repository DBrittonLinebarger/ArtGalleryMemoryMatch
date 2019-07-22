//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.model.pojo;

import edu.cnm.deepdive.gallery_match.model.entity.Card;

/**
 * Checks to see if current card is faceUp.
 */
public class GameTile {

  private final Card card;
  private boolean faceUp;


  /**
   * Initializes this instance using the specified card instance.
   */
  public GameTile(Card card) {
    this.card = card;
  }

  /**
   * Returns card for this instance.
   */
  public Card getCard() {
    return card;
  }

  /**
   * Checks to see if game tile is faceup.
   * @return true if tile is faceup, false if it is not faceup
   */
  public boolean isFaceUp() {
    return faceUp;
  }

  /**
   * Sets faceup for this instance if back of tile is not showing.
   */
  public void setFaceUp(boolean faceUp) {
    this.faceUp = faceUp;
  }
}
