//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.model.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Gets and sets number of objects returned from search and objectIds.
 */
public class Result {

  private int total;

  @SerializedName("objectIDs")
  private int[] objectIds;

  /**
   * Returns total number of objects for search term for this instance.
   */
  public int getTotal() {
    return total;
  }

  /**
   *  Sets total number of objects for search term   for this instance.
   */
  public void setTotal(int total) {
    this.total = total;
  }



  /**
   * Returns objectIds for this instance.
   */
  public int[] getObjectIds() {
    return objectIds;
  }

  /**
   * Sets objectIds  for this instance.
   */
  public void setObjectIds(int[] objectIds) {
    this.objectIds = objectIds;
  }
}
