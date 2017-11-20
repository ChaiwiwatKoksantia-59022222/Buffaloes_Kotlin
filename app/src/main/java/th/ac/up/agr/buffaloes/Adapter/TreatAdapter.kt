package th.ac.up.agr.buffaloes.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import th.ac.up.agr.buffaloes.Data.TreatData
import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.ViewHolder.TreatViewHolder

class TreatAdapter(val data: ArrayList<TreatData>, context: Context) : RecyclerView.Adapter<TreatViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TreatViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.card_view_only_text_with_button, parent, false)
        return TreatViewHolder(view)
    }

    override fun onBindViewHolder(holder: TreatViewHolder?, position: Int) {

        val slot: TreatData = data[position]

        holder?.title?.text = slot.title
        holder?.descriptionDetaillText?.text = slot.description
        holder?.descriptionSmallText?.text = slot.description


        showHide(holder, position, true)

        holder?.button?.setOnClickListener {
            showHide(holder, position, false)
        }

    }

    private fun showHide(holder: TreatViewHolder?, position: Int, starting: Boolean) {
        if (position == 1 && !starting) {
            if (holder?.show!!) {
                holder?.show = false
                showHidePosition(holder, false)
            } else {
                holder?.show = true
                showHidePosition(holder, true)
            }
        } else if (position == 1 && starting) {
            showHidePosition(holder, false)
        } else {
            holder?.descriptionDetailView?.visibility = View.VISIBLE
            holder?.descriptionSmallView?.visibility = View.GONE
            holder?.buttonLayout?.visibility = View.GONE
        }
    }

    private fun showHidePosition(holder: TreatViewHolder?, switch: Boolean) {
        holder?.buttonLayout?.visibility = View.VISIBLE
        if (switch) {
            holder?.descriptionDetailView?.visibility = View.VISIBLE
            holder?.descriptionSmallView?.visibility = View.GONE
            holder?.button?.text = "ย่อรายละเอียด"
        } else {
            holder?.descriptionDetailView?.visibility = View.GONE
            holder?.descriptionSmallView?.visibility = View.VISIBLE
            holder?.button?.text = "แสดงรายละเอียด"
        }
    }


    override fun getItemCount(): Int = data.size
}
