//Copyright 2019 Denelle Britton Linebarger
//    All Rights Reserved.

package edu.cnm.deepdive.gallery_match.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.gallery_match.model.GameLogic;
import edu.cnm.deepdive.gallery_match.model.database.MemoryMatchDatabase;
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import edu.cnm.deepdive.gallery_match.model.entity.Theme;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;

/**
 * Gets list of cards based on theme, number of matches and number of turns.
 * @author Denelle Britton Linebarger
 */
public class GameViewModel extends AndroidViewModel implements LifecycleObserver {

  private MutableLiveData<Boolean> busy;
  private CompositeDisposable pending = new CompositeDisposable();

  /**
   * Initializes this instance with the specified {@link Application}
   */
  public GameViewModel(@NonNull Application application) {
    super(application);
  }

  /**
   * Returns list of cards based on theme id.
   *
   * @param theme generated by search term inputted by user
   * @return list of cards grouped by theme
   */
  public LiveData<List<Card>> getCards(Theme theme) {

    return MemoryMatchDatabase.getInstance(getApplication()).getCardDao().getAll(theme.getId());
  }

  /**
   * Disposes obsolete thread references when fragment stops.
   */
  @OnLifecycleEvent(Event.ON_STOP)
  public void disposePending() {
    pending.clear();
  }

  /**
   * Gets instance of GameViewModel.
   *
   * @return instance of GameViewModel
   */
  public GameViewModel getInstance() {
    return this;

  }

  /**
   * Gets number of matches in game for specified instance.
   *
   */
  public int getMatchCount(GameLogic gameLogic) {
    return gameLogic.getMatchCount();

  }

  /**
   * Gets number of turns used to complete a game for specified instance.
   *
   */
  public int getTurnCount(GameLogic gameLogic) {
    return gameLogic.getTurnCount();

  }

}
