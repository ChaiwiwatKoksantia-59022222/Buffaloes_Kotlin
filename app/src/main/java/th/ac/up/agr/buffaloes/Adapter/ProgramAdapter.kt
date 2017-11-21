package th.ac.up.agr.buffaloes.Adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import th.ac.up.agr.buffaloes.Data.ProgramData
import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.ViewHolder.ProgramVIewHolder

class ProgramAdapter(val data: ArrayList<ProgramData>, val context: Context, val ID: Int) : RecyclerView.Adapter<ProgramVIewHolder>() {

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ProgramVIewHolder?, position: Int) {

        val slot = data[position]

        if (ID == 0) {
            holder?.title?.text = slot.title
            holder?.count?.text = slot.titleCircle
        } else if (ID == 1) {
            holder?.titleCard?.text = slot.title
            //holder?.countCard?.text = "แบบที่ ${position + 1}"
            holder?.countCard?.text = slot.titleCircle

            val option = BitmapFactory.Options()
            option.inSampleSize = 2
            val bitmap = BitmapFactory.decodeResource(context.resources, slot.image, option)
            holder?.image?.setImageBitmap(bitmap)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProgramVIewHolder? {
        return when (ID) {
            0 -> {
                val view = LayoutInflater.from(parent?.context).inflate(R.layout.menu_icon, parent, false)
                ProgramVIewHolder(view)
            }
            1 -> {
                val view = LayoutInflater.from(parent?.context).inflate(R.layout.card_view_program_h, parent, false)
                ProgramVIewHolder(view)
            }
            else -> null
        }
    }
}