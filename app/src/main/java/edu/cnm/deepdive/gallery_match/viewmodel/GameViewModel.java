package edu.cnm.deepdive.gallery_match.viewmodel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.OnLifecycleEvent;
import edu.cnm.deepdive.gallery_match.model.database.MemoryMatchDatabase;
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class GameViewModel extends AndroidViewModel implements LifecycleObserver {

  private static final int GAME_DECK = 8;
  private MutableLiveData<Boolean> busy;
  private MutableLiveData<Deck> deck = new MutableLiveData<Deck>();
  private MutableLiveData<List<Card>> cards = new MutableLiveData<List<Card>>();
  private CompositeDisposable pending = new CompositeDisposable();

  public GameViewModel(@NonNull Application application) {
    super(application);
  }


  public MutableLiveData<Deck> getDeck() {
    return deck;
  }

  public MutableLiveData<List<Card>> getCards() {
    return cards;
  }

  @OnLifecycleEvent(Event.ON_STOP)
  public void disposePending() {
    pending.clear();
  }

  public GameViewModel getInstance() {
    return this;

  }

  //private void createDeck() {
  //  pending.add(
  //      MemoryMatchDatabase.getInstance().newDeck(GAME_DECK)
  //          .subscribeOn(Schedulers.io())
  //          .observeOn(AndroidSchedulers.mainThread())
  //          .subscribe((deck) -> {
  //            this.deck.setValue(deck);
  //          })
  //  );
  //}

  //public LiveData<List<Card>> getCards() {
  //  if (cards== null) {
  //    cards=
  //    MemoryMatchDatabase.getInstance(getApplication()).getCardDao().getAll();
  //  }
  //  return cards;
  //}

  //public LiveData<List<Card>> getCards(Card card) {
  //  MemoryMatchDatabase database = MemoryMatchDatabase.getInstance(getApplication());
  //  return database.getCardDao().get(card.getId());
  //}




}
