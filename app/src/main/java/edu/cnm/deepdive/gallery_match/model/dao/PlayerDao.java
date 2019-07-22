//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.gallery_match.model.entity.Player;
import java.util.List;

/**
 * Performs CRUD operations on {@link Player} entity instance
 */
@Dao
public interface PlayerDao {

  /**
   * Inserts instance of {@link Player}into database.
   * @param player user
   * @return Player
   */
  @Insert
  long insert(Player player);


  /**
   * Returns the {@link Player } from the database.
   * @return {@link LiveData...} list of all players
   */
  @Query("SELECT * FROM player")
  LiveData<List<Player>> getAll();
}
