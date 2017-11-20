package th.ac.up.agr.buffaloes.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.card_view_multi_text.view.*

class DiseaseViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview) {

    var view = false

    val title = itemview.card_view_multi_text_title_text
    val couse = itemview.card_view_multi_text_cause_text
    val symptom = itemview.card_view_multi_text_symptom_text
    val treatment = itemview.card_view_multi_text_treatment_text

    val small = itemview.card_view_multi_text_show_text

    val button = itemview.disease_show_more_btn
    val detailView = itemView.disease_detail_view
    val smallView = itemView.disease_small_view

}