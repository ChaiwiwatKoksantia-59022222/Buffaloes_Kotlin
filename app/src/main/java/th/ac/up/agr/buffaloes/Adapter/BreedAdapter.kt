package th.ac.up.agr.buffaloes.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import th.ac.up.agr.buffaloes.Data.BreedData
import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.ViewHolder.BreedViewHolder

class BreedAdapter(val data :ArrayList<BreedData>,val context: Context) : RecyclerView.Adapter<BreedViewHolder>(){
    override fun onBindViewHolder(holder: BreedViewHolder?, position: Int) {

        val slot = data[position]
        holder?.title?.text = slot.title
        holder?.description?.text = slot.description

    }

    override fun getItemCount(): Int = data.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BreedViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.card_view_only_text,parent,false)

        return BreedViewHolder(view)
    }
}
