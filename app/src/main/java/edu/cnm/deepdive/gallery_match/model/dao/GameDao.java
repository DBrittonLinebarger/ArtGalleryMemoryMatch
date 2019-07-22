//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.gallery_match.model.entity.Game;
import java.util.List;


/**
 * Performs CRUD operations on {@link Game} entity instance
 */

@Dao
public interface GameDao {

  /**
   * Inserts instance of {@link Game}into database.
   * @param game ....
   * @return instance of game
   */

  @Insert
  long insert(Game game);


  /**
   *Returns the {@link Game} from the database.
   * @return {@link LiveData...} list of all games.
   */

  @Query("SELECT * FROM game")
  LiveData<List<Game>> getAll();

  /**
   *Returns the {@link Game} specified by the <code>playerId</code> from the database.
   * @param playerId {@link Game} foreign key value.
   * @return @link LiveData ....} instance.
   */

  @Query("SELECT * FROM game WHERE player_id = :playerId")
  LiveData<List<Game>> getAll(long playerId);

}
