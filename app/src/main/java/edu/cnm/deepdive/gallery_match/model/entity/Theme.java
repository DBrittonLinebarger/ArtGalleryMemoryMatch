package edu.cnm.deepdive.gallery_match.model.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;
import java.util.Objects;

/**
 * contains methods for returning and setting data for <code>Theme</code> entity
 */
@Entity(indices = @Index(value = "title", unique = true))
public class Theme implements Parcelable {

  /**
   * returns instance of this theme...
   */
  public static final Parcelable.Creator<Theme> CREATOR
      = new Parcelable.Creator<Theme>() {
    public Theme createFromParcel(Parcel in) {
      return new Theme(in);
    }

    @Override
    public Theme[] newArray(int size) {
      return new Theme[0];
    }
  };

  @PrimaryKey(autoGenerate = true)
  private long id;
  private String title;

  /**
   * ...
   */
  public Theme() {
  }

  private Theme(Parcel in) {
    in.readString();
    in.readLong();

  }

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
   * returns title for this instance
   */
  public String getTitle() {
    return title;
  }

  /**
   * sets title for this instance
   */
  public void setTitle(String title) {
    this.title = title;
  }

  @NonNull
  @Override
  public String toString() {
    return title;
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) { //***
    dest.writeString(title);
    dest.writeLong(id);
  }

  @Override
  public int hashCode() {
    return title.hashCode();
  }

  @Override
  public boolean equals(@Nullable Object obj) {
    return Objects.equals(title, ((obj == null) ? null : ((Theme) obj).title));
  }
}

