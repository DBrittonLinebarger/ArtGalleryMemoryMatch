package edu.cnm.deepdive.gallery_match.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import java.util.List;

/**
 * Performs CRUD operations on object
 */

@Dao
public interface ThemeDao {

  /**
   * Inserts instance of {@link Theme}into database.
   * @param theme theme searched for by user
   * @return theme...
   */

  @Insert
  long insert(Theme theme);

  /**
   * Returns the {@link Theme} from the database.
   * @return {@link LiveData...} list of all
   */

  @Query("SELECT * FROM theme")
  LiveData<List<Theme>> getAll();

  /**
   * Returns the {@link Theme} specified by the <code>title<code> from the database.
   * @param stringtitle title of theme
   * @return title of theme
   */

  @Query("SELECT * FROM theme WHERE title = :stringtitle")
  LiveData<Theme> selectThemeByTitle(String stringtitle);

  /**
   * Deletes theme from database
   * @param themes theme searched for by user
   * @return .......
   */

  @Delete
  int delete(Theme... themes);

}
