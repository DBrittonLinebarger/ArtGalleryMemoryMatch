package edu.cnm.deepdive.gallery_match.model.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import java.util.List;

@Dao
public interface ThemeDao {

  @Insert
  long insert(Theme theme);

  @Query("SELECT * FROM theme")
  LiveData<List<Theme>> getAll();

  @Delete
  int delete(Theme... themes);

  //find by id method

}
