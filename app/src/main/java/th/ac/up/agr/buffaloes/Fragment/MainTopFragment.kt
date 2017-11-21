package th.ac.up.agr.buffaloes.Fragment


import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main_top.view.*
import th.ac.up.agr.buffaloes.MultiplyActivity

import th.ac.up.agr.buffaloes.R
import java.util.*

class MainTopFragment : Fragment() {

    internal lateinit var view: View

    private var dateA = Calendar.getInstance()
    private var dateCurrent = Calendar.getInstance()


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_main_top, container, false)

        view.main_date_button.setOnClickListener {
            DatePickerDialog(activity, dateS, dateCurrent.get(Calendar.YEAR), dateCurrent.get(Calendar.MONTH), dateCurrent.get(Calendar.DAY_OF_MONTH)).show()
        }

        return view
    }

    private fun intent(date: Calendar) {
        val intent = Intent(context, MultiplyActivity::class.java)
        intent.putExtra("ID", 10)
        intent.putExtra("DAY",date.get(Calendar.DAY_OF_MONTH))
        intent.putExtra("MONTH",date.get(Calendar.MONTH))
        intent.putExtra("YEAR",date.get(Calendar.YEAR))
        context.startActivity(intent)
    }

    var dateS: DatePickerDialog.OnDateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
        dateA.set(year, month, day)
        intent(dateA)
    }

}