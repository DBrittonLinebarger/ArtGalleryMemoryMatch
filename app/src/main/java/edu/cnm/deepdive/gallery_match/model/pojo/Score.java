//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.model.pojo;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import java.util.Date;
import java.util.Objects;

/**
 * Creates, adds or deletes scores for each game.
 */
public class Score implements Comparable<Score> {

  private Theme theme;
  private Date date;
  private int turns;

  /**
   * Returns theme for this instance.
   */
  public Theme getTheme() {
    return theme;
  }

  /**
   * Sets theme for this instance.
   */
  public void setTheme(Theme theme) {
    this.theme = theme;
  }

  /**
   * Returns date for this instance.
   */
  public Date getDate() {
    return date;
  }

  /**
   * Sets date for this instance.
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * Returns turns for this instance.
   */
  public int getTurns() {
    return turns;
  }

  /**
   * Sets turns for this instance.
   */
  public void setTurns(int turns) {
    this.turns = turns;
  }

  @Override
  public int compareTo(Score other) {
    int comparison = Integer.compare(turns, other.turns);
    if (comparison == 0) {
      comparison = date.compareTo(other.date);
    }
    return comparison;
  }

  @Override
  public int hashCode() {
    return Objects.hash(theme, date, turns);
  }

  @Override
  public boolean equals(@Nullable Object obj) {
    boolean equal = false;
    if (obj != null && obj.getClass() == getClass()) {
      Score other = (Score) obj;
      equal = compareTo(other) == 0
          && theme.equals(other.theme)
          && date.equals(other.date);

    }

    return equal;
  }

  @NonNull
  @Override
  public String toString() {
    return super.toString();
  }
}
