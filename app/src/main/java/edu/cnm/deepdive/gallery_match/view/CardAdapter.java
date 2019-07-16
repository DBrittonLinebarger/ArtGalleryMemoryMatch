package edu.cnm.deepdive.gallery_match.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.Picasso;
import edu.cnm.deepdive.gallery_match.model.entity.Card;
import java.util.List;

public class CardAdapter extends RecyclerView {

  private Context context;
  private List<Card> cards;

  public CardAdapter(@NonNull Context context) {
    super(context);
  }

  class CardHolder extends RecyclerView.ViewHolder {

    private ImageView itemView;

    private CardHolder(@NonNull View itemView) {
      super(itemView);
      this.itemView = (ImageView) itemView;
    }

    //private void bind(Card card) {
    //  Picasso.get().load(card.getImageUrl().toString()).into(itemView);
    //}
  }
}
