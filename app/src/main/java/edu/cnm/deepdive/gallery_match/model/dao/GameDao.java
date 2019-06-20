package edu.cnm.deepdive.gallery_match.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.gallery_match.model.entity.Game;
import java.util.List;

@Dao
public interface GameDao {

  @Insert
  long insert(Game game);

  @Query("SELECT * FROM game")
  LiveData<List<Game>> getAll();

  @Query("SELECT * FROM game WHERE player_id = :playerId")
  LiveData<List<Game>> getAll(long playerId);

}
