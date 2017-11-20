package th.ac.up.agr.buffaloes.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.card_view_only_text_with_button.view.*

class TreatViewHolder(itemview :View) : RecyclerView.ViewHolder(itemview){

    var show :Boolean = false

    val title :TextView = itemview.card_view_multi_text_with_button_title_text
    val descriptionSmallText = itemview.card_view_multi_text_with_button_show_text
    val descriptionDetaillText = itemview.card_view_multi_text_with_button_detail_text

    val button = itemview.card_view_multi_text_with_button_show_more_btn

    val descriptionSmallView = itemview.card_view_multi_text_with_button_small_view
    val descriptionDetailView = itemView.card_view_multi_text_with_button_detail_view
    val buttonLayout = itemview.card_view_only_text_with_button_button_layout

}
