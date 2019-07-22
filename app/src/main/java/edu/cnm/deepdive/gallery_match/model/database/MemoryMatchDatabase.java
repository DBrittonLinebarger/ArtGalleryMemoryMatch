//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.model.database;


import android.content.Context;
import android.os.AsyncTask;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import edu.cnm.deepdive.gallery_match.model.dao.CardDao;
import edu.cnm.deepdive.gallery_match.model.dao.GameDao;
import edu.cnm.deepdive.gallery_match.model.dao.PlayerDao;
import edu.cnm.deepdive.gallery_match.model.dao.ThemeDao;
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import edu.cnm.deepdive.gallery_match.model.entity.Game;
import edu.cnm.deepdive.gallery_match.model.entity.Player;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;

/**
 * contains methods for getting card, game, player and theme daos
 *
 */
@Database(entities = {Card.class, Game.class, Player.class, Theme.class}, version = 1)
public abstract class MemoryMatchDatabase extends RoomDatabase {

  private static MemoryMatchDatabase INSTANCE;

  /**
   * returns instance of this database
   * @param context this application context
   * @return instance of this database
   */
  public static MemoryMatchDatabase getInstance(Context context) {
    if (INSTANCE == null) {
      synchronized (MemoryMatchDatabase.class) {
        if (INSTANCE == null) {
          INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
              MemoryMatchDatabase.class, "memory_match_room")
              .fallbackToDestructiveMigration()
              .addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                  super.onCreate(db);
                  //new PopulateDbTask(INSTANCE).execute();
                }
              })
              .build();
        }
      }
    }
    return INSTANCE;
  }

  /**
   * gets <code>CardDao</code>
   * @return <code>CardDao</code>
   */
  public abstract CardDao getCardDao();

  /**
   * gets <code>GameDao</code>
   * @return <code>GameDao</code>
   */
  public abstract GameDao getGameDao();

  /**
   * gets <code>PlayerDao</code>
   * @return <code>PlayerDao</code>
   */
  public abstract PlayerDao getPlayerDao();

  /**
   *gets <code>ThemeDao</code>
   * @return <code>ThemeDao</code>
   */
  public abstract ThemeDao getThemeDao();

  private static class PopulateDbTask extends AsyncTask<Void, Void, Void> {

    private final MemoryMatchDatabase db;

    /**
     * populates <code>MemoryMatchDatabase</code>
     * @param db MemoryMatchDatabase
     */
    public PopulateDbTask(MemoryMatchDatabase db) {
      this.db = db;
    }

    @Override
    protected Void doInBackground(Void... voids) {
      return null;
    }
  }
}
