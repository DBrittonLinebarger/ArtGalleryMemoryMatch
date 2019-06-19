package edu.cnm.deepdive.gallery_match.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Game {

  @PrimaryKey(autoGenerate = true)
  private long id;

  @ColumnInfo(name = "player_id", index = true)
  private long playerId;

  @ColumnInfo(name = "theme_id", index = true)
  private long themeId;

  private int time;

  private int score;

  @ColumnInfo(name = "date_started", index = true)
  private long dateStarted;

  @ColumnInfo(name = "date_ended", index = true)
  private long dateEnded;

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

  public int getTime() {
    return time;
  }

  public void setTime(int time) {
    this.time = time;
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

}
