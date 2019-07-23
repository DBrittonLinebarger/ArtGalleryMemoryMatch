package edu.cnm.deepdive.gallery_match.model.dao;

import static org.junit.Assert.*;

import android.content.Context;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import edu.cnm.deepdive.gallery_match.model.database.MemoryMatchDatabase;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ThemeDaoTest {
 private MemoryMatchDatabase db;
 private ThemeDao dao;

  @Before
  public void setUp() throws Exception {
    Context context = ApplicationProvider.getApplicationContext();
    db = Room.inMemoryDatabaseBuilder(context, MemoryMatchDatabase.class)
        .allowMainThreadQueries()
        .build();
    dao = db.getThemeDao();
  }

  @After
  public void tearDown() throws Exception {
    db.close();
  }

  @Test
  public void insert() {
    Theme theme = new Theme();
    theme.setTitle("Birds");
    long id = dao.insert(theme);
    assertTrue(id > 0);
  }

  @Test
  public void getAll() {
    Theme theme = new Theme();
    theme.setTitle("Birds");
    long id = dao.insert(theme);

  }

  @Test
  public void selectThemeByTitle() {
    Theme theme = new Theme();
    theme.setTitle("Birds");
    long id = dao.insert(theme);
  }

  @Test
  public void delete() {
    Theme theme = new Theme();
    theme.setTitle("Birds");
    long id = dao.insert(theme);
  }
}