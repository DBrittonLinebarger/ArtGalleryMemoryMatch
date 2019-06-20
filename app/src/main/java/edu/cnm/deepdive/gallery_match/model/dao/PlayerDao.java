package edu.cnm.deepdive.gallery_match.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.gallery_match.model.entity.Player;
import java.util.List;

@Dao
public interface PlayerDao {

  @Insert
  long insert(Player player);

  @Query("SELECT * FROM player")
  LiveData<List<Player>> getAll();
}
