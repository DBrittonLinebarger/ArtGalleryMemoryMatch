package edu.cnm.deepdive.gallery_match.model.entity;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Theme {

  @PrimaryKey(autoGenerate = true)
  private long id;

  private String title;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @NonNull
  @Override
  public String toString() {
    return title;
  }
}
