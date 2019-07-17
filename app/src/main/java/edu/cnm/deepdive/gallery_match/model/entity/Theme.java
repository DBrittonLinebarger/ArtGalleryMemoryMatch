package edu.cnm.deepdive.gallery_match.model.entity;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Theme implements Parcelable {

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

  private Theme(Parcel in) {
    in.readString();
    in.readLong();

  }



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

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(title);
    dest.writeLong(id);


  }
}

