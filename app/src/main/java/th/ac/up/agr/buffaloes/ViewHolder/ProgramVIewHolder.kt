package th.ac.up.agr.buffaloes.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.card_view_program.view.*
import kotlinx.android.synthetic.main.card_view_program_h.view.*
import kotlinx.android.synthetic.main.menu_circle.view.*
import kotlinx.android.synthetic.main.menu_icon.view.*

class ProgramVIewHolder(itemview :View) : RecyclerView.ViewHolder(itemview){

    //val title = itemview.program_title
    //val description = itemview.program_description
    val image = itemview.program_card_image

    val title = itemview.menu_menu_text
    val count = itemview.program_menu_count

    val area_circle = itemview.pro_menu_unclick
    val area_card = itemview.program_date_button

    val titleCard = itemview.program_card_title
    val countCard = itemview.program_card_count

}