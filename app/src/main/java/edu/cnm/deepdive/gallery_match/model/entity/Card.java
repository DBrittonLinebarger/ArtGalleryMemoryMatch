//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

/**
 * Returns and sets data for <code>Card</code> entity.
 */
@Entity(foreignKeys = {
    @ForeignKey(entity = Theme.class, parentColumns = "id", childColumns = "theme_id",
        onDelete = ForeignKey.CASCADE)
})
public class Card {

  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "object_id", index = true)
  @SerializedName("objectID")
  private int objectId;

  @ColumnInfo(name = "theme_id", index = true)
  private long themeId;

  private String title;

  @ColumnInfo(name = "object_date", index = true)
  private String objectDate;

  @SerializedName("primaryImageSmall")
  private String url;

  /**
   *Returns id for this instance.
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
   * Returns objectId for this instance.
   */
  public int getObjectId() {
    return objectId;
  }

  /**
   * Sets objectId for this instance.
   */
  public void setObjectId(int objectId) {
    this.objectId = objectId;
  }

  /**
   * Returns themeId for this instance.
   */
  public long getThemeId() {
    return themeId;
  }

  /**
   * Sets themeId for this instance.
   */
  public void setThemeId(long themeId) {
    this.themeId = themeId;
  }

  /**
   * Returns title for this instance.
   */
  public String getTitle() {
    return title;
  }

  /**
   *Sets title for this instance.
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * Returns objectDate for this instance.
   */
  public String getObjectDate() {
    return objectDate;
  }

  /**
   * Sets objectDate for this instance.
   */
  public void setObjectDate(String objectDate) {
    this.objectDate = objectDate;
  }

  /**
   *Returns url for this instance.
   */
  public String getUrl() {
    return url;
  }

  /**
   *Sets url for this instance.
   */
  public void setUrl(String url) {
    this.url = url;
  }
}
