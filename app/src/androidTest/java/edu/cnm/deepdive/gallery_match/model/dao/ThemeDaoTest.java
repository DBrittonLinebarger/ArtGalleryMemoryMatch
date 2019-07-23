package edu.cnm.deepdive.gallery_match.model.dao;

import static org.junit.Assert.*;

import android.content.Context;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import edu.cnm.deepdive.gallery_match.model.database.MemoryMatchDatabase;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import edu.cnm.deepdive.gallery_match.util.LiveDataTestUtil;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class ThemeDaoTest {
 private MemoryMatchDatabase db;
 private ThemeDao dao;

 @Rule
 public InstantTaskExecutorRule rule = new InstantTaskExecutorRule();

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
  public void selectThemeByTitle() throws InterruptedException {
    Theme theme = new Theme();
    theme.setTitle("Birds");
    long id = dao.insert(theme);
    Theme test = LiveDataTestUtil.getValue(dao.selectThemeByTitle("Birds"));
    assertEquals("Birds", test.getTitle());
    assertEquals(id, test.getId());

  }

  @Test
  public void delete() throws InterruptedException {
    Theme theme = new Theme();
    theme.setTitle("Birds");
    long id = dao.insert(theme);
    List<Theme> themes = LiveDataTestUtil.getValue(dao.getAll());
    for (Theme test: themes) {
      if (test.getId() == id) {
        dao.delete(test);
        break;
      }
    }
    themes = LiveDataTestUtil.getValue(dao.getAll());
    for (Theme test: themes) {
      if (test.getId() == id) {
        fail();
      }
    }

  }
}