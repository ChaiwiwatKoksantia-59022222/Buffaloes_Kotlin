package th.ac.up.agr.buffaloes.Adapter

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import th.ac.up.agr.buffaloes.Data.ProgramData
import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.ViewHolder.ProgramVIewHolder
import th.ac.up.agr.buffaloes.MainActivity
import android.support.design.widget.BottomSheetDialog
import android.support.design.widget.BottomSheetBehavior
import android.view.View
import kotlinx.android.synthetic.main.bottom_sheet_dialog_view.view.*
import th.ac.up.agr.buffaloes.MultiplyActivity


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
            holder?.countCard?.text = slot.title

            val option = BitmapFactory.Options()
            option.inSampleSize = 2
            val bitmap = BitmapFactory.decodeResource(context.resources, slot.image, option)
            holder?.image?.setImageBitmap(bitmap)
        }

        holder?.area_circle?.setOnClickListener {

            intent(slot,position + 1)

        }

        holder?.area_card?.setOnClickListener {

            intent(slot,position + 1)

        }

    }

    private fun intent(slot: ProgramData,ID: Int) {

        val intent = Intent(context, MultiplyActivity::class.java)
        intent.putExtra("ID", 99)
        intent.putExtra("TITLE", "โปรแกรม")
        intent.putExtra("SUB",slot.title)
        intent.putExtra("DES",slot.description)
        intent.putExtra("IMAGE", slot.image)
        intent.putExtra("IDs",ID)
        context.startActivity(intent)

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

    fun a1() {
        /*

        val bottomSheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_dialog_view,null)
        val bottomSheetDialog = BottomSheetDialog(context)
        bottomSheetDialog.setContentView(bottomSheetView)

        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheetView.parent as View)

        holder?.area_circle?.setOnClickListener {

            bottomSheetDialog.show()

        }

        bottomSheetView.bs_title_name.text = "โปรแกรม"
        bottomSheetView.bs_name_sub.text = slot.title
        bottomSheetView.bs_card_title.text = slot.titleCircle
        bottomSheetView.bs_card_title.text = slot.description
        val option = BitmapFactory.Options()
        option.inSampleSize = 2
        val bitmap = BitmapFactory.decodeResource(context.resources, slot.image, option)
        bottomSheetView.bs_card_image.setImageBitmap(bitmap)

        bottomSheetView.bs_date_button.setOnClickListener {

        }

        bottomSheetView.bs_back_btn.setOnClickListener {
            bottomSheetDialog.cancel()
        }
*/
    }

}