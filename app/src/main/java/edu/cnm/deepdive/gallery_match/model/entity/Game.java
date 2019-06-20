package edu.cnm.deepdive.gallery_match.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import java.util.Date;


@Entity(foreignKeys = {@ForeignKey(entity = Theme.class, parentColumns = "id", childColumns = "theme_id",
    onDelete = ForeignKey.CASCADE),@ForeignKey(entity = Player.class, parentColumns = "id",
    childColumns = "player_id", onDelete = ForeignKey.CASCADE )
})
public class Game {

  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "player_id", index = true)
  private long playerId;

  @ColumnInfo(name = "theme_id", index = true)
  private long themeId;

  @ColumnInfo(name = "play_time", index = true)
  private int playTime;


  private int score;

  @ColumnInfo(name = "date_started", index = true)
  private long dateStarted;

  @ColumnInfo(name = "date_ended", index = true)
  private long dateEnded;

  @TypeConverters(DateConverter.class)
  private Date timestamp;

  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getPlayerId() {
    return playerId;
  }

  public void setPlayerId(long playerId) {
    this.playerId = playerId;
  }

  public long getThemeId() {
    return themeId;
  }

  public void setThemeId(long themeId) {
    this.themeId = themeId;
  }

  public int getPlayTime() {
    return playTime;
  }

  public void setPlayTime(int playTime) {
    this.playTime = playTime;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public long getDateStarted() {
    return dateStarted;
  }

  public void setDateStarted(long dateStarted) {
    this.dateStarted = dateStarted;
  }

  public long getDateEnded() {
    return dateEnded;
  }

  public void setDateEnded(long dateEnded) {
    this.dateEnded = dateEnded;
  }

  public static class DateConverter {

    @TypeConverter
    public static Date longToDate(Long value) {
      return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long dateToLong(Date value) {
      return value == null ? null : value.getTime();
    }
  }
}
