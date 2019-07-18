package edu.cnm.deepdive.gallery_match.model.dao;

import static org.junit.Assert.*;

import android.content.Context;
import android.database.sqlite.SQLiteConstraintException;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.SmallTest;
import edu.cnm.deepdive.gallery_match.model.database.MemoryMatchDatabase;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//@SmallTest
//public class ThemeDaoTest {
//
//  private MemoryMatchDatabase db;
//  private ThemeDao dao;
//
//  @Before
//  public void setup() throws Exception {
//    Context context = ApplicationProvider.getApplicationContext();
//    db = Room.inMemoryDatabaseBuilder(context, MemoryMatchDatabase.class).build();
//    dao = db.getThemeDao();
//
//  @Test
//  public void insert() {
//      Theme theme = new Theme();
//      theme.setTitle("Figs");
//      long id = dao.insert(theme);
//      assertTrue(id > 0);
//    }
//  }
//
//  @Test(expected = SQLiteConstraintException.class)
//  public void insertNullTitle() {
//    Theme theme = new Theme();
//    long id + dao.insert(theme);
//
//
//  }
//
//  @After
//  public void teardown() throws Exception {
//    db.close();
//  }
//}