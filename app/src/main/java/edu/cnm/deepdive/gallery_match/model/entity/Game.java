package edu.cnm.deepdive.gallery_match.model.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import java.util.Date;

/**
 * contains methods for returning and setting data for <code>Game</code> entity
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
   * returns timestamp for this instance
   */
  public Date getTimestamp() {
    return timestamp;
  }

  /**
   * sets timestamp for this instance
   */
  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
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
   * returns playerId for this instance
   */
  public long getPlayerId() {
    return playerId;
  }

  /**
   * sets playerId for this instance
   */
  public void setPlayerId(long playerId) {
    this.playerId = playerId;
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
   * returns playTime for this instance
   */
  public int getPlayTime() {
    return playTime;
  }

  /**
   * sets playTime for this instance
   */
  public void setPlayTime(int playTime) {
    this.playTime = playTime;
  }

  /**
   * returns score for this instance
   */
  public int getScore() {
    return score;
  }

  /**
   * sets score for this instance
   */
  public void setScore(int score) {
    this.score = score;
  }

  /**
   * returns dateStarted for this instance
   */
  public long getDateStarted() {
    return dateStarted;
  }

  /**
   * sets dateStarted for this instance
   */
  public void setDateStarted(long dateStarted) {
    this.dateStarted = dateStarted;
  }

  /**
   * returns dateEnded for this instance
   */
  public long getDateEnded() {
    return dateEnded;
  }

  /**
   * sets dateEnded for this instance
   */
  public void setDateEnded(long dateEnded) {
    this.dateEnded = dateEnded;
  }

  /**
   * creates instance of date for current game
   */
  public static class DateConverter {

    /**
     * creates instance of current date for game...
     * @param value date of game
     * @return instance of current date for game
     */
    @TypeConverter
    public static Date longToDate(Long value) {
      return value == null ? null : new Date(value);
    }

    /**
     * .....
     * @param value
     * @return
     */

    @TypeConverter
    public static Long dateToLong(Date value) {
      return value == null ? null : value.getTime();
    }
  }
}
