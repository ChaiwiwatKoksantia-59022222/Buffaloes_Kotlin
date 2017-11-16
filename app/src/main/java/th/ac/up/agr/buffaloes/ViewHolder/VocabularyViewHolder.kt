package th.ac.up.agr.buffaloes.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.card_view_only_text.view.*

class VocabularyViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

    val title: TextView = itemview.card_view_only_text_title_text
    val description: TextView = itemview.card_view_only_text_des_text

}