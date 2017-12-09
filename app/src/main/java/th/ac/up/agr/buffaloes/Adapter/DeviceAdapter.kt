package th.ac.up.agr.buffaloes.Adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import th.ac.up.agr.buffaloes.Data.DeviceData
import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.ViewHolder.DeviceViewHolder
import java.util.*

class DeviceAdapter(val data :ArrayList<DeviceData>,val context: Context) : RecyclerView.Adapter<DeviceViewHolder>(){

    override fun onBindViewHolder(holder: DeviceViewHolder?, position: Int) {

        val slot = data[position]
        holder?.title?.text = slot.title

        val option = BitmapFactory.Options()
        option.inSampleSize = 2
        val bitmap = BitmapFactory.decodeResource(context.resources, slot.image, option)
        holder?.image?.setImageBitmap(bitmap)

        if (!slot.description.contentEquals("NO")){
            holder?.textLayout?.visibility = View.VISIBLE
            holder?.description?.text = slot.description
        } else {
            holder?.textLayout?.visibility = View.GONE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DeviceViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.card_view_image,parent,false)
        return DeviceViewHolder(view)
    }

    override fun getItemCount(): Int = data.size
}