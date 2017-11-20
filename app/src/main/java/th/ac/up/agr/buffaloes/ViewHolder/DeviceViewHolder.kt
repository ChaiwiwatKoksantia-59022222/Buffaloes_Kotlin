package th.ac.up.agr.buffaloes.ViewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.card_view_image.view.*

class DeviceViewHolder(itemview :View) : RecyclerView.ViewHolder(itemview){

    val title = itemview.card_view_image_title_text
    val image = itemview.card_view_image_image

}