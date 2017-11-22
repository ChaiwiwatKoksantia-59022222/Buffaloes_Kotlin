package th.ac.up.agr.buffaloes.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main_program.view.*
import th.ac.up.agr.buffaloes.Adapter.ProgramAdapter
import th.ac.up.agr.buffaloes.Data.ProgramData

import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.Tools.DataStringTools
import th.ac.up.agr.buffaloes.Tools.DeviceUtils
import th.ac.up.agr.buffaloes.Tools.PreCachingGridLayoutManeger
import th.ac.up.agr.buffaloes.Tools.PreCachingLinearLayoutManeger


/**
 * A simple [Fragment] subclass.
 */
class MainProgramFragment : Fragment() {


    companion object {

        fun newInstance(title: String,subTitle :String): MainProgramFragment {
            val args = Bundle()
            args.putString("TITLE", title)
            args.putString("SUB",subTitle)
            //args.putInt("value", value)
            //args.putSerializable("testData", testData)
            val fragment = MainProgramFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_main_program, container, false)

        val title = arguments.getString("TITLE")
        val subTitle = arguments.getString("SUB")

        view.pro_name_title.text = title
        view.pro_name_sub_title.text = subTitle

        menuBtn(view)

        recyclerviewMenu(view)
        recyclerviewCard(view)

        return view
    }

    fun recyclerviewMenu(view: View){
        val layoutManager = PreCachingGridLayoutManeger(context, 3)
        layoutManager.orientation = GridLayoutManager.VERTICAL

        layoutManager.extraLayoutSpace = DeviceUtils(context).getScreenHeight()
        layoutManager.reverseLayout = false
        view.pro_main_menu_recyclerview.layoutManager = layoutManager
        view.pro_main_menu_recyclerview.setHasFixedSize(true)
        view.pro_main_menu_recyclerview.setItemViewCacheSize(10000)
        view.pro_main_menu_recyclerview.isDrawingCacheEnabled = true
        view.pro_main_menu_recyclerview.isNestedScrollingEnabled = true
        view.pro_main_menu_recyclerview.overScrollMode = View.OVER_SCROLL_NEVER
        view.pro_main_menu_recyclerview.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

        val data: ArrayList<ProgramData> = DataStringTools(context).programData(R.array.menu_menu_title_text
                , R.array.menu_menu_title_circle
                ,R.array.induction_program_text_data
                ,R.array.induction_program_image_data
                ,R.drawable.unknown_picture)
        val adapter = ProgramAdapter(data, context,0)
        view.pro_main_menu_recyclerview.adapter = adapter
    }

    fun recyclerviewCard(view: View){

        val layoutManager = PreCachingLinearLayoutManeger(context)
        //layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        layoutManager.orientation = LinearLayoutManager.VERTICAL

        layoutManager.extraLayoutSpace = DeviceUtils(context).getScreenHeight()
        layoutManager.reverseLayout = false
        view.pro_main_card_recyclerview.layoutManager = layoutManager
        view.pro_main_card_recyclerview.setHasFixedSize(true)
        view.pro_main_card_recyclerview.setItemViewCacheSize(10000)
        view.pro_main_card_recyclerview.isDrawingCacheEnabled = true
        view.pro_main_card_recyclerview.isNestedScrollingEnabled = true
        view.pro_main_card_recyclerview.overScrollMode = View.OVER_SCROLL_NEVER
        view.pro_main_card_recyclerview.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

        val data: ArrayList<ProgramData> = DataStringTools(context).programData(R.array.menu_menu_title_text
                , R.array.menu_menu_title_circle
                ,R.array.induction_program_text_data
                ,R.array.induction_program_image_data
                ,R.drawable.unknown_picture)
        val adapter = ProgramAdapter(data, context,1)
        view.pro_main_card_recyclerview.adapter = adapter

        //val helper = LinearSnapHelper()
        //helper.attachToRecyclerView(view.program_main_card_recyclerview)
    }

    fun menuBtn(view: View) {
        menuAction(false, view)
        view.pro_menu_off?.setOnClickListener { menuAction(false, view) }
        view.pro_card_off?.setOnClickListener { menuAction(true, view) }
    }

    fun menuAction(switch: Boolean, view: View) {
        if (switch) {
            view.pro_main_menu_recyclerview.visibility = View.GONE
            view.pro_main_card_recyclerview.visibility = View.VISIBLE
            view.pro_card_off.visibility = View.GONE
            view.pro_card_on.visibility = View.VISIBLE
            view.pro_menu_off.visibility = View.VISIBLE
            view.pro_menu_on.visibility = View.GONE
        } else {
            view.pro_main_card_recyclerview.visibility = View.GONE
            view.pro_main_menu_recyclerview.visibility = View.VISIBLE
            view.pro_card_off.visibility = View.VISIBLE
            view.pro_card_on.visibility = View.GONE
            view.pro_menu_off.visibility = View.GONE
            view.pro_menu_on.visibility = View.VISIBLE
        }
    }

}
