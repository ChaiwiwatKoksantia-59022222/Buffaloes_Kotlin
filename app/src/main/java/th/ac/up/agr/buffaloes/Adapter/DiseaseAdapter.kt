package th.ac.up.agr.buffaloes.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import th.ac.up.agr.buffaloes.Data.DiseaseData
import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.ViewHolder.DiseaseViewHolder

class DiseaseAdapter(val data: ArrayList<DiseaseData>,val context: Context) : RecyclerView.Adapter<DiseaseViewHolder>(){

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: DiseaseViewHolder?, position: Int) {

        val slot :DiseaseData = data[position]
        holder?.title?.text = slot.title
        holder?.couse?.text = slot.cause
        holder?.symptom?.text = slot.symptom
        holder?.treatment?.text = slot.treatment

        holder?.small?.text = "โรคนี้${slot.cause}"

        var views :Boolean = holder?.view!!
        showHide(holder,views)

        holder?.button.setOnClickListener {

            if (holder?.view){
                holder?.view = false
                showHide(holder,holder?.view)
            } else {
                holder?.view = true
                showHide(holder,holder?.view)
            }

        }

    }

    fun showHide(holder: DiseaseViewHolder?, view :Boolean){
        if (view){
            holder?.detailView!!.visibility = View.VISIBLE
            holder?.smallView!!.visibility = View.GONE
            holder?.button.text = "ย่อรายละเอียด"
        }
        else {
            holder?.detailView!!.visibility = View.GONE
            holder?.smallView!!.visibility = View.VISIBLE
            holder?.button.text = "แสดงรายละเอียด"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DiseaseViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_view_multi_text,parent,false)
        return DiseaseViewHolder(v)
    }
}
