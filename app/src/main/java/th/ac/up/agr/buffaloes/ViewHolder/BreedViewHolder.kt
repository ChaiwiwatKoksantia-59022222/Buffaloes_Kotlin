package th.ac.up.agr.buffaloes.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.card_view_only_text.view.*

class BreedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    val title = itemView.card_view_only_text_title_text
    val description = itemView.card_view_only_text_des_text

}