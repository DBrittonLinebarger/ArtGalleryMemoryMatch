//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.model.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * contains methods for getting and setting number of objects returned from search and objectIds
 */
public class Result {

  private int total;

  @SerializedName("objectIDs")
  private int[] objectIds;

  /**
   * returns total number of objects for search term for this instance
   */
  public int getTotal() {
    return total;
  }

  /**
   *  sets total number of objects for search term   for this instance
   */
  public void setTotal(int total) {
    this.total = total;
  }



  /**
   * returns objectIds for this instance
   */
  public int[] getObjectIds() {
    return objectIds;
  }

  /**
   * sets objectIds  for this instance
   */
  public void setObjectIds(int[] objectIds) {
    this.objectIds = objectIds;
  }
}
