package edu.cnm.deepdive.gallery_match.model.database;


import android.content.Context;
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

@Database(entities = {Card.class, Game.class, Player.class, Theme.class}, version = 1)
public abstract class MemoryMatchDatabase extends RoomDatabase {

  public abstract CardDao getCardDao();

  public abstract GameDao getGameDao();

  public abstract PlayerDao getPlayerDao();

  public abstract ThemeDao getThemeDao();


  private static MemoryMatchDatabase INSTANCE;

    public static MemoryMatchDatabase getInstance(Context context) {
      if (INSTANCE == null) {
        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
            MemoryMatchDatabase.class, "memory_match_room")
            .build();
      }
      return INSTANCE;
    }

}
