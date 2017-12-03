package th.ac.up.agr.buffaloes.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_result_first.view.*

import th.ac.up.agr.buffaloes.R
import java.util.*


/**
 * A simple [Fragment] subclass.
 */
class ResultFirstFragment : Fragment() {

    companion object {

        fun newInstance(day: Int, month: Int, year: Int): ResultFirstFragment {
            val args = Bundle()
            args.putInt("DAY", day)
            args.putInt("MONTH", month)
            args.putInt("YEAR", year)
            //args.putInt("value", value)
            //args.putSerializable("testData", testData)
            val fragment = ResultFirstFragment()
            fragment.arguments = args
            return fragment
        }
    }

    internal lateinit var view: View
    private var dateCurrent = Calendar.getInstance()
    private var dateZ = Calendar.getInstance()
    private var dateA = Calendar.getInstance()
    private var dateB = Calendar.getInstance()
    private var dateC = Calendar.getInstance()
    private var dateD = Calendar.getInstance()
    private var dateE = Calendar.getInstance()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        view = inflater!!.inflate(R.layout.fragment_result_first, container, false)

        dateA.set(arguments.getInt("YEAR"), arguments.getInt("MONTH"), arguments.getInt("DAY"))

        calculate()
        hasShowView()

        view.re_BackBTN.setOnClickListener {
            activity.finish()
        }

        return view
    }

    private fun hasShowView(){

        view.re_ShowView.visibility = View.VISIBLE
        view.re_MainOn.visibility = View.VISIBLE

    }

    private fun setTextView() {

        view.re_TimeLabel.text = convertDateToString(dateZ.get(Calendar.DAY_OF_MONTH),
                dateZ.get(Calendar.MONTH) + 1,
                dateZ.get(Calendar.YEAR) + 543)


        //view.main_date_text.text = "เลือกวันเดือนปีที่จะคำนวน"

        view.result_text_day1.text = convertDateToString(dateZ.get(Calendar.DAY_OF_MONTH)
                , dateZ.get(Calendar.MONTH) + 1, dateZ.get(Calendar.YEAR) + 543)

        view.result_text_day2.text = convertDateToString(dateA.get(Calendar.DAY_OF_MONTH)
                , dateA.get(Calendar.MONTH) + 1, dateA.get(Calendar.YEAR) + 543)

        view.result_text_day3.text = convertDateToString(dateE.get(Calendar.DAY_OF_MONTH)
                , dateE.get(Calendar.MONTH) + 1, dateE.get(Calendar.YEAR) + 543)

        view.result_text_day4.text = convertDateToString(dateD.get(Calendar.DAY_OF_MONTH)
                , dateD.get(Calendar.MONTH) + 1, dateD.get(Calendar.YEAR) + 543)
    }


    private fun calculate() {

        dateZ.set(dateA.get(Calendar.YEAR), dateA.get(Calendar.MONTH), dateA.get(Calendar.DAY_OF_MONTH))

        dateA.add(Calendar.DAY_OF_MONTH, 21)
        dateB.set(dateA.get(Calendar.YEAR), dateA.get(Calendar.MONTH), dateA.get(Calendar.DAY_OF_MONTH))
        dateB.add(Calendar.DAY_OF_MONTH, 304)
        dateC.set(dateB.get(Calendar.YEAR), dateB.get(Calendar.MONTH), dateB.get(Calendar.DAY_OF_MONTH))
        //dateC.add(Calendar.MONTH, 10)
        dateD.set(dateC.get(Calendar.YEAR), dateC.get(Calendar.MONTH), dateC.get(Calendar.DAY_OF_MONTH))
        dateD.add(Calendar.DAY_OF_MONTH, 7)
        dateE.set(dateC.get(Calendar.YEAR), dateC.get(Calendar.MONTH), dateC.get(Calendar.DAY_OF_MONTH))
        dateE.add(Calendar.DAY_OF_MONTH, -7)
        setTextView()
    }


    private fun convertDateToString(day: Int, month: Int, year: Int): String {
        return "วันที่ " + day + " " +
                convertMonth_intToName(month) + " พ.ศ." + (year)
    }

    private fun convertMonth_intToName(month: Int): String {
        when (month) {
            1 -> return "มกราคม"
            2 -> return "กุมภาพันธ์"
            3 -> return "มีนาคม"
            4 -> return "เมษายน"
            5 -> return "พฤษภาคม"
            6 -> return "มิถุนายน"
            7 -> return "กรกฎาคม"
            8 -> return "สิงหาคม"
            9 -> return "กันยายน"
            10 -> return "ตุลาคม"
            11 -> return "พฤศจิกายน"
            else -> return "ธันวาคม"
        }
    }

}
