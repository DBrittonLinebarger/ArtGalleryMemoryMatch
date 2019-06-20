package edu.cnm.deepdive.gallery_match.model;

import android.media.Image;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = {
    @ForeignKey(entity = Theme.class, parentColumns = "id", childColumns = "theme_id",
        onDelete = ForeignKey.CASCADE)
})
public class Cards {

  @PrimaryKey (autoGenerate = true)
  private long id;

  @ColumnInfo(name = "object_id", index = true)
  private String objectId;

  @ColumnInfo(name = "theme_id", index = true)
  private long  themeId;

  private String title;


  private String country;

  private  String date;

  private Image url;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getObjectId() {
    return objectId;
  }

  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  public long getThemeId() {
    return themeId;
  }

  public void setThemeId(long themeId) {
    this.themeId = themeId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public Image getUrl() {
    return url;
  }

  public void setUrl(Image url) {
    this.url = url;
  }
}
