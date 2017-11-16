package th.ac.up.agr.buffaloes.Adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import th.ac.up.agr.buffaloes.Data.TabSecondListData
import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.ViewHolder.TabSecordViewHolder

class TabSecondAdapter(val data: ArrayList<TabSecondListData>, val context: Context) : RecyclerView.Adapter<TabSecordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TabSecordViewHolder {

        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_view_with_image, parent, false)

        return TabSecordViewHolder(v)
    }

    override fun onBindViewHolder(holder: TabSecordViewHolder?, position: Int) {

        val slot: TabSecondListData = data[position]
        holder?.textviewTitle?.text = (position + 1).toString() + ". " + slot.title
        holder?.textviewDescription?.text = slot.desText

        val option = BitmapFactory.Options()
        option.inSampleSize = 2
        val bitmap = BitmapFactory.decodeResource(context.resources, slot.image, option)
        holder?.imageview?.setImageBitmap(bitmap)


    }

    override fun getItemCount(): Int {
        return data.size
    }


}