//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import java.util.Date;

/**
 * Returns and sets data for <code>Game</code> entity.
 */
@Entity(foreignKeys = {
    @ForeignKey(entity = Theme.class, parentColumns = "id", childColumns = "theme_id",
        onDelete = ForeignKey.CASCADE), @ForeignKey(entity = Player.class, parentColumns = "id",
    childColumns = "player_id", onDelete = ForeignKey.CASCADE)
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

  /**
   * Returns timestamp for this instance.
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * Sets timestamp for this instance.
   */
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  /**
   * Returns id for this instance.
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
   * Returns playerId for this instance.
   */
  public long getPlayerId() {
    return playerId;
  }

  /**
   * Sets playerId for this instance.
   */
  public void setPlayerId(long playerId) {
    this.playerId = playerId;
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
   * Returns playTime for this instance.
   */
  public int getPlayTime() {
    return playTime;
  }

  /**
   * Sets playTime for this instance.
   */
  public void setPlayTime(int playTime) {
    this.playTime = playTime;
  }

  /**
   * Returns score for this instance.
   */
  public int getScore() {
    return score;
  }

  /**
   * Sets score for this instance.
   */
  public void setScore(int score) {
    this.score = score;
  }

  /**
   * Returns dateStarted for this instance.
   */
  public long getDateStarted() {
    return dateStarted;
  }

  /**
   * Sets dateStarted for this instance.
   */
  public void setDateStarted(long dateStarted) {
    this.dateStarted = dateStarted;
  }

  /**
   * Returns dateEnded for this instance.
   */
  public long getDateEnded() {
    return dateEnded;
  }

  /**
   * Sets dateEnded for this instance.
   */
  public void setDateEnded(long dateEnded) {
    this.dateEnded = dateEnded;
  }

  /**
   * Creates instance of date for current game.
   */
  public static class DateConverter {

    /**
     * Converts an instance of Long to an instance of Date  and returns the latter.
     */
    @TypeConverter
    public static Date longToDate(Long value) {
      return value == null ? null : new Date(value);
    }

    /**
     * Converts an instance of Date to an instance of Long
     */
    @TypeConverter
    public static Long dateToLong(Date value) {
      return value == null ? null : value.getTime();
    }
  }
}
