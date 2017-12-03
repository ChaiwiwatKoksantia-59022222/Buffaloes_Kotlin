package th.ac.up.agr.buffaloes.Fragment


import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import kotlinx.android.synthetic.main.dialog.*
import kotlinx.android.synthetic.main.fragment_in.view.*

import th.ac.up.agr.buffaloes.R


/**
 * A simple [Fragment] subclass.
 */
class INFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_in, container, false)

        resultShow(false, view)

        view.in_result_button.setOnClickListener {
            calculate(view)
        }

        view.in_result_layout_cancel_button.setOnClickListener {
            resultShow(false, view)
        }

        return view
    }

    private fun resultShow(result: Boolean, view: View) {

        if (result) {
            view.in_main_layout.visibility = View.GONE
            view.in_result_layout_button.visibility = View.GONE
            view.in_result_layout_cancel_button.visibility = View.VISIBLE
            view.in_result_layout_card.visibility = View.VISIBLE
        } else {
            view.in_w1.forceLayout()
            view.in_main_layout.visibility = View.VISIBLE
            view.in_result_layout_cancel_button.visibility = View.GONE
            view.in_result_layout_button.visibility = View.VISIBLE
            view.in_result_layout_card.visibility = View.GONE
            clearEditText(view)
        }

    }

    private fun calculate(view: View) {
        val v1 = view.in_v1.text?.toString()
        val w1 = view.in_w1.text?.toString()
        val w2 = view.in_w2.text?.toString()

        if (v1.isNullOrEmpty() or w1.isNullOrEmpty() or w2.isNullOrEmpty()){
            dialog("ข้อมูลไม่ถูกต้อง กรุณาตรวจสอบข้อมูลอีกครั้ง","ปิด")
        } else {
            val vs1 = java.lang.Double.parseDouble(v1)
            val ws1 = java.lang.Double.parseDouble(w1)
            val ws2 = java.lang.Double.parseDouble(w2)

            val result = ((vs1 * ws1) / ws2)
            setText(view, v1.toString(), w1.toString(), w2.toString(), result.toString())
            resultShow(true, view)
        }
    }

    fun dialog(text :String,confirm :String){

        val dialog = Dialog(this!!.activity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog)
        dialog.setCancelable(true)
        dialog.show()


        dialog.can_textview_dialog.text = text
/*
        dialog.can_cancel_btn.text = cancel
        dialog.can_cancel_btn.visibility = View.VISIBLE
        dialog.can_cancel_btn.setOnClickListener {
            dialog.cancel()
        }
*/

        dialog.can_cancel_btn.visibility = View.GONE

        dialog.can_confirm_btn.text = confirm
        dialog.can_confirm_btn.visibility = View.VISIBLE
        dialog.can_confirm_btn.setOnClickListener {

            dialog.cancel()

        }

    }

    private fun setText(view: View, v1: String, w1: String, w2: String, result: String) {
        view.in_text.text = "ปริมาณยาที่ต้องใช้ $result ml"
    }

    private fun clearEditText(view: View) {
        view.in_text.text = ""
        view.in_v1.text.clear()
        view.in_w1.text.clear()
        view.in_w2.text.clear()
    }

}
