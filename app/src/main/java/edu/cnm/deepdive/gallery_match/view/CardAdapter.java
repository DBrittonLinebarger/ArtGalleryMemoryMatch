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
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import edu.cnm.deepdive.gallery_match.view.CardAdapter.CardHolder;
import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardHolder> {

  private Context context;
  private List<Card> cards;

  public CardAdapter(Context context, List<Card> cards) {
    this.context = context;
    this.cards = cards;
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
    holder.bind(cards.get(position));
  }

  @Override
  public int getItemCount() {
    return cards.size();
  }


  class CardHolder extends RecyclerView.ViewHolder {

    private ImageView itemView;

    private CardHolder(@NonNull View itemView) {
      super(itemView);
      this.itemView = (ImageView) itemView;
    }

    private void bind(Card card) {
      Picasso.get().load(card.getUrl().toString()).into(itemView);
    }

  }
}
