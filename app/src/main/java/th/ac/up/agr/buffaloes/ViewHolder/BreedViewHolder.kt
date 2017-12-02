package th.ac.up.agr.buffaloes.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.card_view_with_image.view.*

class BreedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val title = itemView.image_card_view_title_text
    val image = itemView.image_card_view_image
    val description = itemView.image_card_view_des_text

}