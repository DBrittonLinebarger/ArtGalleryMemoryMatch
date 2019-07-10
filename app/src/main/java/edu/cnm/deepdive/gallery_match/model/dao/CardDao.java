package edu.cnm.deepdive.gallery_match.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import java.util.List;

@Dao
public interface CardDao {

@Insert
  long insert(Card card);

  @Query("SELECT * FROM card")
  LiveData<List<Card>> getAll();

  @Query("SELECT * FROM card WHERE theme_id = :themeId")
  LiveData<List<Card>> getAll(long themeId);

  @Query("SELECT * FROM card WHERE theme_id = :themeId LIMIT 16 ")
  LiveData<List<Card>> get16 (long themeId);

}
