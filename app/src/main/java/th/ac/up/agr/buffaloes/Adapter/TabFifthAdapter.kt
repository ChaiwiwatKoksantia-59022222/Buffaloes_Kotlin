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
            onClickFunction(position, slot.text)
        }

    }

    private fun onClickFunction(position: Int, title: String) {
        val idMulti: Int = (ID.toString() + position.toString()).toInt()
        when (ID) {
            3 -> {
                when (position) {
                    1 -> {
                        intent(idMulti,title,"การเหนี่ยวนำการเป็นสัด")
                    }
                }
            }
            4 -> {
                when (position) {
                    0 -> {
                        intent(idMulti,title,"การผสมเทียม")
                    }
                    1 -> {
                        intent(idMulti, title)
                    }
                    2 -> {
                        intent(idMulti, title,"การผสมเทียม")
                    }
                }
            }
            5 -> {
                intent(idMulti, title)
            }

        }
    }

    private fun intent(idMulti :Int,title: String){
        val intent = Intent(context, MultiplyActivity::class.java)
        intent.putExtra("ID", idMulti)
        intent.putExtra("TITLE", title)
        context.startActivity(intent)
    }

    private fun intent(idMulti :Int,title: String,subTitle :String){
        val intent = Intent(context, MultiplyActivity::class.java)
        intent.putExtra("ID", idMulti)
        intent.putExtra("TITLE", title)
        intent.putExtra("SUB",subTitle)
        context.startActivity(intent)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TabFifthViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.menu_circle, parent, false)

        return TabFifthViewHolder(v)
    }
}