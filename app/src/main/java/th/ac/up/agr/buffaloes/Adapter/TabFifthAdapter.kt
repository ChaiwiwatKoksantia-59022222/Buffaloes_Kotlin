package th.ac.up.agr.buffaloes.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import th.ac.up.agr.buffaloes.Data.TabFifthListData
import th.ac.up.agr.buffaloes.MultiplyActivity
import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.ViewHolder.TabFifthViewHolder

class TabFifthAdapter(val data: ArrayList<TabFifthListData>, val context: Context, val ID: Int) : RecyclerView.Adapter<TabFifthViewHolder>() {

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TabFifthViewHolder?, position: Int) {

        val slot: TabFifthListData = data[position]
        holder?.text?.text = slot.text

        val option = BitmapFactory.Options()
        option.inSampleSize = 1
        val bitmap = BitmapFactory.decodeResource(context.resources, slot.image, option)
        holder?.image?.setImageBitmap(bitmap)

        holder?.area?.setOnClickListener {
            onClickFunction(position,slot.text)
        }


    }

    private fun onClickFunction(position: Int,title :String){
        when (ID) {
            5 -> {
                when (position) {
                    0 -> {
                        val intent = Intent(context,MultiplyActivity::class.java)
                        intent.putExtra("ID",50)
                        intent.putExtra("TITLE",title)
                        context.startActivity(intent)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TabFifthViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.menu_circle, parent, false)

        return TabFifthViewHolder(v)
    }
}