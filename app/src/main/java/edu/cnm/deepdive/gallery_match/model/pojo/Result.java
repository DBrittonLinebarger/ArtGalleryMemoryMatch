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
   *
   */
  public int getTotal() {
    return total;
  }

  /**
   *
   */
  public void setTotal(int total) {
    this.total = total;
  }


  
  /**
   *
   */
  public int[] getObjectIds() {
    return objectIds;
  }

  /**
   *
   */
  public void setObjectIds(int[] objectIds) {
    this.objectIds = objectIds;
  }
}
