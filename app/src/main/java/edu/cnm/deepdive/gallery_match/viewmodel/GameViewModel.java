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
 *
 */
public class GameViewModel extends AndroidViewModel implements LifecycleObserver {

  private MutableLiveData<Boolean> busy;
  private CompositeDisposable pending = new CompositeDisposable();

  /**
   *
   * @param application
   */
  public GameViewModel(@NonNull Application application) {
    super(application);
  }

  /**
   *
   * @param theme
   * @return
   */
  public LiveData<List<Card>> getCards(Theme theme) {

    return MemoryMatchDatabase.getInstance(getApplication()).getCardDao().getAll(theme.getId());
  }

  @OnLifecycleEvent(Event.ON_STOP)
  public void disposePending() {
    pending.clear();
  }

  public GameViewModel getInstance() {
    return this;

  }

  public int getMatchCount(GameLogic gameLogic) {
    return gameLogic.getMatchCount();

  }

  public int getTurnCount(GameLogic gameLogic) {
    return gameLogic.getTurnCount();

  }


}
