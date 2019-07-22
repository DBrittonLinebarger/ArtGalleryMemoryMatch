//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import java.util.List;

/**
 * Performs CRUD operations on {@link Card} entity instances.
 */
@Dao
public interface CardDao {

  /**
   * Inserts instance of {@link Card} into database.
   * @param card instance of image for game.
   * @return instance of Card.
   */
  @Insert
  long insert(Card card);

  /**
   * Returns the {@link Card} from the database.
   * @return {@link LiveData}  list of all cards.
   */
  @Query("SELECT * FROM card")
  LiveData<List<Card>> getAll();

  /**
   * Returns the {@link Card} specified by the <code>themeId</code> from the database.
   * @param themeId {@link Card} foreign key value.
   * @return {@link LiveData} instance.
   */
  @Query("SELECT * FROM card WHERE theme_id = :themeId")
  LiveData<List<Card>> getAll(long themeId);


  /**
   * Returns the {@link Card} specified by the <code>themeId</code> from the database.
   *
   * @param themeId {@link Card} foreign key value.
   * @return {@link LiveData}   and returns 8 cards.
   */
  @Query("SELECT * FROM card WHERE theme_id = :themeId LIMIT 8 ")
  LiveData<List<Card>> get(long themeId);

}
