package th.ac.up.agr.buffaloes.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import th.ac.up.agr.buffaloes.Data.VocabularyData
import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.ViewHolder.VocabularyViewHolder

class VocabularyAdapter(val data :ArrayList<VocabularyData> ,val context: Context) : RecyclerView.Adapter<VocabularyViewHolder>(){

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: VocabularyViewHolder?, position: Int) {

        val slot :VocabularyData = data[position]
        holder?.title?.text = slot.title
        holder?.description?.text = slot.description

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): VocabularyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_view_only_text,parent,false)
        return VocabularyViewHolder(v)
    }
}