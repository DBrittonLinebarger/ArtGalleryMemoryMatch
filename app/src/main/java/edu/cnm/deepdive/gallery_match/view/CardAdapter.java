package edu.cnm.deepdive.gallery_match.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.gallery_match.R;
import edu.cnm.deepdive.gallery_match.model.pojo.GameTile;
import edu.cnm.deepdive.gallery_match.view.CardAdapter.CardHolder;
import java.util.List;

/**
 * 
 */
public class CardAdapter extends RecyclerView.Adapter<CardHolder> {

  private final Context context;
  private final List<GameTile> tiles;
  private final OnTileClickListener listener;

  /**
   *
   * @param context
   * @param tiles
   * @param listener
   */
  public CardAdapter(Context context, List<GameTile> tiles,
      OnTileClickListener listener) {
    this.context = context;
    this.tiles = tiles;
    this.listener = listener;
  }

  @NonNull
  @Override
  public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    CardHolder holder;
    View itemView = LayoutInflater.from(context).inflate(R.layout.card_view, parent, false);
    holder = new CardHolder(itemView);
    return holder;
  }

  @Override
  public void onBindViewHolder(@NonNull CardHolder holder, int position) {
    holder.bind(tiles.get(position));
  }

  @Override
  public int getItemCount() {
    return tiles.size();
  }

  /**
   * sets listener on game tile to detect clicks
   */
  public interface OnTileClickListener {

    void click(GameTile tile, int position);
  }

  /**
   * loads drawable image for back of card or art image for front of card when it is clicked
   */
  class CardHolder extends RecyclerView.ViewHolder {

    private ImageView itemView;
    private GameTile gameTile;

    private CardHolder(@NonNull View itemView) {
      super(itemView);
      this.itemView = (ImageView) itemView;
    }

    private void bind(GameTile gameTile) {
      this.gameTile = gameTile;
      if (gameTile.isFaceUp()) {
        Picasso.get().load(gameTile.getCard().getUrl().toString()).into(itemView);
      } else {
        itemView.setImageDrawable(context.getDrawable(R.drawable.ic_help));
      }
      itemView.setOnClickListener((view) -> listener.click(gameTile, getAdapterPosition()));
    }

  }
}
