package th.ac.up.agr.buffaloes.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.menu_circle.view.*

class TabFifthViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

    val text: TextView = itemview.menu_circle_text
    val image: ImageView = itemview.menu_circle_image

    val area: RelativeLayout = itemview.menu_unclick
}