package th.ac.up.agr.buffaloes.Adapter

import android.content.Context
import android.content.res.ColorStateList
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.ViewHolder.ProsViewHolder

class ProsAdapter(val data :ArrayList<String>,val date :ArrayList<String>,val context: Context) : RecyclerView.Adapter<ProsViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ProsViewHolder {

        val view = LayoutInflater.from(parent?.context).inflate(R.layout.card_date,parent,false)

        return ProsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProsViewHolder?, position: Int) {

        holder?.textView?.text = data[position]

        holder?.title?.text = date[position]



        when(position){
            //0 -> holder?.layout?.cardBackgroundColor = ColorStateList.valueOf(context.resources.getColor(R.color.colorS1))
            0 -> holder?.layout?.setCardBackgroundColor(ColorStateList.valueOf(context.resources.getColor(R.color.colorS1)))
            1 -> holder?.layout?.setCardBackgroundColor(ColorStateList.valueOf(context.resources.getColor(R.color.colorS2Text)))
            2 -> holder?.layout?.setCardBackgroundColor(ColorStateList.valueOf(context.resources.getColor(R.color.colorS3)))

        //1 -> holder?.layout?.cardBackgroundColor = ColorStateList.valueOf(context.resources.getColor(R.color.colorS2Text))
            //2 -> holder?.layout?.cardBackgroundColor = ColorStateList.valueOf(context.resources.getColor(R.color.colorS3))
        }

    }

    override fun getItemCount(): Int = data.size
}