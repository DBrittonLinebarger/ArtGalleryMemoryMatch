//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.model.entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Returns and sets data for <code>Player</code> entity.
 */
@Entity
public class Player {

  @PrimaryKey(autoGenerate = true)
  private long id;

  private String name;

  /**
   * Returns id for this instance.
   */
  public long getId() {
    return id;
  }

  /**
   * Sets id for this instance.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Returns name for this instance.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name for this instance.
   */
  public void setName(String name) {
    this.name = name;
  }
}
