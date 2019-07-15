package edu.cnm.deepdive.gallery_match;

import android.view.Display;
import java.io.IOException;
import java.text.Normalizer.Form;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


//public class MemoryMatchGame {
//
//  private Map<String,URLImage> loadedUrls = new HashMap<String, URLImage>();
//  boolean isFlipping = false;
//
//  public class Card extends Container {
//    private Card match;
//    private Button front;
//    private Button back;
//    private String url;
//
//
//    public Card(String url) {
//      this.url = url;
//      URLImage img = null;
//      if (loadedUrls.containsKey(this.url)) {
//        img = loadedUrls.get(this.url);
//      } else {
//        img = URLImage.createToStorage(cardBack, url+"-"+cardBack.getWidth(), url, URLImage.RESIZE_SCALE_TO_FILL);
//        loadedUrls.put(url, img);
//        img.fetch();
//      }
//      setLayout(new BorderLayout());
//      back = new Button(cardBack);
//      back.setUIID("Label");
//      front = new Button(img);
//      front.setUIID("Label");
//      front.addActionListener((evt) -> {
//        flip();
//      });
//      back.addActionListener((evt) -> {
//        flip();
//      });
//      addComponent(BorderLayout.CENTER, back);
//    }
//
//
//
//    public void flip() {
//      if (isFlipping || this.getMatch() != null) {
//        return;
//      }
//      isFlipping = true;
//      boolean isFlipToFront = false;
//      if (this.getComponentAt(0) == front) {
//        // Flip to back
//        this.replaceAndWait(front, back, new FlipTransition());
//      } else {
//        // Flip to front
//        isFlipToFront = true;
//        this.replaceAndWait(back, front, new FlipTransition());
//      }
//      isFlipping = false;
//
//      if (isFlipToFront) {
//        if (currentCard == null) {
//          currentCard = this;
//        } else if (currentCard.isMatchFor(this)) {
//          match = currentCard;
//          currentCard.match = this;
//          currentCard = null;
//
//        } else {
//          currentCard.flip();
//          this.flip();
//          currentCard = null;
//        }
//      }
//
//    }
//
//    public boolean isMatchFor(Card card) {
//      return card.url.equals(this.url);
//    }
//
//    public Card getMatch() {
//      return match;
//    }
//
//  }
//
//  private Resources theme;
//
//  // Stores the image for the back of a card
//  private EncodedImage cardBack;
//
//  // number of rows in the card grid
//  private int rows = 4;
//
//  // number of columns in the card grid
//  private int cols = 4;
//
//  // Current card
//  private Card currentCard;
//
//  private Card[] createCards(String keyword, int num) {
//    ArrayList<Card> out = new ArrayList<Card>();
//    java.util.List flickrEntries = getEntriesFromFlickrService(keyword);
//    for (int i=0; i<num; i++) {
//      String url = (String)((Map)((Map)flickrEntries.get(i)).get("media")).get("m");
//      out.add(new Card(url));
//      out.add(new Card(url));
//    }
//    Collections.shuffle(out);
//    return out.toArray(new Card[out.size()]);
//  }
//
//  public void init(Object context) {
//    try {
//      theme = Resources.openLayered("/theme");
//      UIManager.getInstance().setThemeProps(theme.getTheme(theme.getThemeResourceNames()[0]));
//    } catch(IOException e){
//      e.printStackTrace();
//    }
//    cardBack = (EncodedImage)theme.getImage("card-back-1024x1024.png")
//        .scaled(Display.getInstance().getDisplayWidth()/cols, Display.getInstance()
//            .getDisplayHeight()/rows);
//
//  }
//
//  public void start() {
//
//    newGameForm();
//  }
//
//
//  /**
//   * The entry form for the app.  Allows user to enter a search for flickr images.
//   */
//  public void newGameForm() {
//    Form f = new Form("Classic Flickr Concentration");
//    f.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
//    f.addComponent(new SpanLabel("Welcome to Classic Flickr Concentration.  "
//        + "A card matching game that uses flickr images."));
//    f.addComponent(new SpanLabel("Begin by entering a keyword to search for matching images."));
//    TextField searchField = new TextField();
//    f.addComponent(searchField);
//    Button searchButton = new Button("Start Game");
//    searchButton.addActionListener((evt) -> {
//      showBoard(searchField.getText());
//    });
//
//    f.addComponent(searchButton);
//    f.show();
//  }
//
//
//
//
//}
