package th.ac.up.agr.buffaloes.Fragment

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.DialogFragment
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker

import kotlinx.android.synthetic.main.fragment_tab_first.*
import kotlinx.android.synthetic.main.fragment_tab_first.view.*

import th.ac.up.agr.buffaloes.R
import java.time.Year
import java.util.*

class TabFirstFragment : Fragment() {


    internal lateinit var view: View
    //var dateCurrent :String = String()
    private var dateCurrent = Calendar.getInstance()
    private var dateZ = Calendar.getInstance()
    private var dateA = Calendar.getInstance()
    private var dateB = Calendar.getInstance()
    private var dateC = Calendar.getInstance()
    private var dateD = Calendar.getInstance()
    private var dateE = Calendar.getInstance()

    var mTimer: CountDownTimer? = null

    var showView :Boolean = false


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        view = inflater!!.inflate(R.layout.fragment_tab_first, container, false)

        calculate()
        hasShowView()

        view.main_date_button.setOnClickListener { view ->

            DatePickerDialog(activity, dateS, dateCurrent.get(Calendar.YEAR), dateCurrent.get(Calendar.MONTH), dateCurrent.get(Calendar.DAY_OF_MONTH)).show()

        }

        view.tab1BackBTN.setOnClickListener { view ->

            showView = false
            hasShowView()

        }

        return view
    }

    private fun hasShowView(){
        if (showView){
            //view.tab1InputView.visibility = View.GONE
            view.tab1ShowView.visibility = View.VISIBLE
            view.tab1MainOff.visibility = View.GONE
            view.tab1MainOn.visibility = View.VISIBLE
            view.tab1NullView.visibility = View.GONE
            //view.tab1Image.visibility = View.GONE
        }
        else {
            view.tab1InputView.visibility = View.VISIBLE
            view.tab1ShowView.visibility = View.GONE
            view.tab1MainOff.visibility = View.VISIBLE
            view.tab1MainOn.visibility = View.GONE
            view.tab1NullView.visibility = View.VISIBLE
            //view.tab1Image.visibility = View.VISIBLE
        }
    }

    private fun setTextView() {

        view.tab1TimeLabel.text = convertDateToString(dateZ.get(Calendar.DAY_OF_MONTH),
                dateZ.get(Calendar.MONTH) + 1,
                dateZ.get(Calendar.YEAR) + 543)


        //view.main_date_text.text = "เลือกวันเดือนปีที่จะคำนวน"

        view.result_text_day1.text = convertDateToString(dateA.get(Calendar.DAY_OF_MONTH)
                , dateA.get(Calendar.MONTH) + 1, dateA.get(Calendar.YEAR) + 543)

        view.result_text_day2.text = convertDateToString(dateB.get(Calendar.DAY_OF_MONTH)
                , dateB.get(Calendar.MONTH) + 1, dateB.get(Calendar.YEAR) + 543)

        view.result_text_day3.text = convertDateToString(dateE.get(Calendar.DAY_OF_MONTH)
                , dateE.get(Calendar.MONTH) + 1, dateE.get(Calendar.YEAR) + 543)

        view.result_text_day4.text = convertDateToString(dateD.get(Calendar.DAY_OF_MONTH)
                , dateD.get(Calendar.MONTH) + 1, dateD.get(Calendar.YEAR) + 543)
    }


    internal var dateS: DatePickerDialog.OnDateSetListener = DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
        dateA.set(year, month, day)
        calculate()
        showView = true
        hasShowView()
    }

    private fun countDownTimeer() {
/*
        var count = 0

        var countDownTime = object : CountDownTimer(10000, 1000) {
            override fun onFinish() {
                ledCon(false, false, false)
            }

            override fun onTick(millisUntilFinished: Long) {
                val s = millisUntilFinished / 1000
                val e = s.toInt()
                //Log.e("Time", e.toString())
                count++

                when (count) {
                    2 -> {
                        ledCon(true, false, false)
                    }
                    3 -> {
                        ledCon(false, true, false)
                    }
                    4 -> {
                        ledCon(false, false, true)
                    }
                    else -> {
                        ledCon(false, false, false)
                    }
                }

            }
        }
        countDownTime.start()
*/
    }


    private fun calculate() {

        dateZ.set(dateA.get(Calendar.YEAR), dateA.get(Calendar.MONTH), dateA.get(Calendar.DAY_OF_MONTH))

        dateA.add(Calendar.DAY_OF_MONTH, 21)
        dateB.set(dateA.get(Calendar.YEAR), dateA.get(Calendar.MONTH), dateA.get(Calendar.DAY_OF_MONTH))
        dateB.add(Calendar.DAY_OF_MONTH, 295)
        dateC.set(dateA.get(Calendar.YEAR), dateA.get(Calendar.MONTH), dateA.get(Calendar.DAY_OF_MONTH))
        dateC.add(Calendar.MONTH, 10)
        dateD.set(dateC.get(Calendar.YEAR), dateC.get(Calendar.MONTH), dateC.get(Calendar.DAY_OF_MONTH))
        dateD.add(Calendar.DAY_OF_MONTH, 15)
        dateE.set(dateC.get(Calendar.YEAR), dateC.get(Calendar.MONTH), dateC.get(Calendar.DAY_OF_MONTH))
        dateE.add(Calendar.DAY_OF_MONTH, -6)
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