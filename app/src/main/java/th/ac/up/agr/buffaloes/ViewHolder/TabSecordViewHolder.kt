package th.ac.up.agr.buffaloes.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.card_view_with_image.view.*

class TabSecordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val textviewTitle: TextView = itemView.image_card_view_title_text
    val textviewDescription: TextView = itemView.image_card_view_des_text
    val imageview: ImageView = itemView.image_card_view_image

}

