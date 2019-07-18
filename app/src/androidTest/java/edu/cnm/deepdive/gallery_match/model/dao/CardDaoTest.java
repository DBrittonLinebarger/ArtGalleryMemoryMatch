package edu.cnm.deepdive.gallery_match.model.dao;

import static org.junit.Assert.*;

import android.content.Context;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.filters.SmallTest;
import edu.cnm.deepdive.gallery_match.model.database.MemoryMatchDatabase;
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SmallTest
public class CardDaoTest {

private MemoryMatchDatabase db;
private CardDao dao;


@Before
public void setup() throws Exception {
  Context context = ApplicationProvider.getApplicationContext();
  db = Room.inMemoryDatabaseBuilder(context, MemoryMatchDatabase.class).build();
  dao = db.getCardDao();
}
  @Test
  public void insert() {
  Card card = new Card();
  //card.setThemeId();
  //card.setObjectId();
  }

  @Test
  public void get() {
  }

  @After
  public void teardown() throws Exception {
  db.close();
  }
}