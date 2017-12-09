package th.ac.up.agr.buffaloes.Fragment


import android.app.DatePickerDialog
import android.graphics.BitmapFactory
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_pros.view.*
import th.ac.up.agr.buffaloes.Adapter.ProsAdapter

import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.Tools.DeviceUtils
import th.ac.up.agr.buffaloes.Tools.PreCachingLinearLayoutManeger
import th.ac.up.agr.buffaloes.Tools.ResultString
import java.util.*
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass.
 */
class ProsFragment : Fragment() {

    companion object {

        fun newInstance(title: String, subTitle: String, description: String, image: Int,ID :Int): ProsFragment {
            val args = Bundle()
            args.putString("TITLE", title)
            args.putString("SUB", subTitle)
            args.putString("DES",description)
            args.putInt("IMAGE", image)
            args.putInt("ID",ID)
            //args.putSerializable("testData", testData)
            val fragment = ProsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    internal lateinit var view: View

    private var dateZ = Calendar.getInstance()
    private var dateA = Calendar.getInstance()
    private var dateB = Calendar.getInstance()
    private var dateC = Calendar.getInstance()
    private var dateD = Calendar.getInstance()
    private var dateE = Calendar.getInstance()
    private var dateCurrent = Calendar.getInstance()

    private var show :Boolean = false

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        view = inflater!!.inflate(R.layout.fragment_pros, container, false)

        val title = arguments.getString("TITLE")
        val subTitle = arguments.getString("SUB")
        val description = arguments.getString("DES")
        val image = arguments.getInt("IMAGE")
        val id = arguments.getInt("ID")

        showHide(false)

        view.pros_name_title.text = title
        view.pros_name_sub_title.text = subTitle
        view.pros_card_title.text = description

        val option = BitmapFactory.Options()
        option.inSampleSize = 0
        val bitmap = BitmapFactory.decodeResource(context.resources, image, option)
        view.pros_card_image.setImageBitmap(bitmap)

        view.pros_date_button.setOnClickListener {
            DatePickerDialog(activity, dateS, dateCurrent.get(Calendar.YEAR), dateCurrent.get(Calendar.MONTH), dateCurrent.get(Calendar.DAY_OF_MONTH)).show()
        }

        view.prosBackBTN.setOnClickListener {
            showHide(false)
            dateA = dateZ
        }

        return view
    }

    fun getAll(a:Int,b :Int,c :Int,d :Int) : ArrayList<String> {

        var part  = ArrayList<Int>()

        part.add(a)
        part.add(b)
        part.add(c)
        part.add(d)

        var data = ArrayList<String>()

        for (i in part.indices){
            val j = part.get(i)
            val A = Calendar.getInstance()

            A.set(dateA.get(Calendar.YEAR),dateA.get(Calendar.MONTH),dateA.get(Calendar.DAY_OF_MONTH))

            A.add(Calendar.DAY_OF_MONTH,j)
            if (part.get(i) >= 0) {
                data.add(convertDateToString(A.get(Calendar.DAY_OF_MONTH),
                        A.get(Calendar.MONTH) + 1,
                        A.get(Calendar.YEAR) + 543))
            }
        }

        return data
    }

    fun showHide(switch :Boolean){
        if (switch){
            view.prosMainOn.visibility = View.VISIBLE
            view.pros_date_button.visibility = View.GONE
            view.pros_btn.visibility = View.GONE
            view.pros_main_card_recyclerview.visibility = View.VISIBLE
            view.pros_result_text.visibility = View.VISIBLE
        } else {
            view.prosMainOn.visibility = View.GONE
            view.pros_date_button.visibility = View.VISIBLE
            view.pros_btn.visibility = View.VISIBLE
            view.pros_main_card_recyclerview.visibility = View.GONE
            view.pros_result_text.visibility = View.GONE
        }

    }

    fun setText(){
        view.prosTimeLabel.text = convertDateToString(dateA.get(Calendar.DAY_OF_MONTH),
                dateA.get(Calendar.MONTH) + 1,
                dateA.get(Calendar.YEAR) + 543)
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

    fun da (ID: Int) : ArrayList<String>{

        return when (ID) {

            1 -> {
                getAll(0,7,9,-1)
            }
            2 -> {
                getAll(0,7,10,-1)
            }
            else -> {
                ArrayList<String>()
            }
        }
    }

    var dateS: DatePickerDialog.OnDateSetListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
        dateA.set(year, month, day)
        showHide(true)
        setText()
        recycler()
    }

    fun recycler(){
        val layoutManager = PreCachingLinearLayoutManeger(context)
        //layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        //layoutManager.extraLayoutSpace = DeviceUtils(context).getScreenHeight()
        layoutManager.reverseLayout = false
        view.pros_main_card_recyclerview.layoutManager = layoutManager
        view.pros_main_card_recyclerview.setHasFixedSize(true)
        view.pros_main_card_recyclerview.setItemViewCacheSize(10000)
        view.pros_main_card_recyclerview.isDrawingCacheEnabled = true
        view.pros_main_card_recyclerview.isNestedScrollingEnabled = true
        view.pros_main_card_recyclerview.overScrollMode = View.OVER_SCROLL_NEVER
        view.pros_main_card_recyclerview.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

        val ID = arguments.getInt("ID")

        var data = da(ID)

        val dats = ResultString(ID).textS(data,0)
        val date = ResultString(ID).textS(data,1)

        val adapter = ProsAdapter(dats,date, context)
        view.pros_main_card_recyclerview.adapter = adapter
    }

}