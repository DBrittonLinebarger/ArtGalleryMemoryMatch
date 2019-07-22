//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.model.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * contains methods for returning and setting data for <code>Player</code> entity
 */
@Entity
public class Player {

  @PrimaryKey(autoGenerate = true)
  private long id;

  private String name;

  /**
   * returns id for this instance
   */
  public long getId() {
    return id;
  }

  /**
   * sets id for this instance
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * returns name for this instance
   */
  public String getName() {
    return name;
  }

  /**
   * sets name for this instance
   */
  public void setName(String name) {
    this.name = name;
  }
}
