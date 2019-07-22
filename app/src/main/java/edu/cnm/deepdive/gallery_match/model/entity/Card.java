package edu.cnm.deepdive.gallery_match.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import com.google.gson.annotations.SerializedName;

/**
 * contains methods for returning and setting data for <code>Card</code> entity
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
   *returns id for this instance
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
   * returns objectId for this instance
   */
  public int getObjectId() {
    return objectId;
  }

  /**
   * sets objectId for this instance
   */
  public void setObjectId(int objectId) {
    this.objectId = objectId;
  }

  /**
   * returns themeId for this instance
   */
  public long getThemeId() {
    return themeId;
  }

  /**
   * sets themeId for this instance
   */
  public void setThemeId(long themeId) {
    this.themeId = themeId;
  }

  /**
   * returns title for this instance
   */
  public String getTitle() {
    return title;
  }

  /**
   *sets title for this instance
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * returns objectDate for this instance
   */
  public String getObjectDate() {
    return objectDate;
  }

  /**
   * sets objectDate for this instance
   */
  public void setObjectDate(String objectDate) {
    this.objectDate = objectDate;
  }

  /**
   *returns url for this instance
   */
  public String getUrl() {
    return url;
  }

  /**
   *sets url for this instance
   */
  public void setUrl(String url) {
    this.url = url;
  }
}
