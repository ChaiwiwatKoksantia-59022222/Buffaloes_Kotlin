package th.ac.up.agr.buffaloes.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_tab_third.view.*
import th.ac.up.agr.buffaloes.Adapter.TabFifthAdapter
import th.ac.up.agr.buffaloes.Data.TabFifthListData

import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.Tools.DataStringTools
import th.ac.up.agr.buffaloes.Tools.DeviceUtils
import th.ac.up.agr.buffaloes.Tools.PreCachingGridLayoutManeger
import java.util.ArrayList

class TabThirdFragment : Fragment() {


    internal lateinit var view: View

    var showDetail :Boolean = true

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        view = inflater!!.inflate(R.layout.fragment_tab_third, container, false)

        setShortText(view.tab_3_detail_short)
        showHideMore()


        view.tab3_show_more_btn.setOnClickListener {
            showHideMore()
        }

        val layoutManager = PreCachingGridLayoutManeger(context!!,2)
        layoutManager.orientation = GridLayoutManager.VERTICAL
        layoutManager.extraLayoutSpace = DeviceUtils(context!!).getScreenHeight()
        layoutManager.reverseLayout = false
        view.tab3_recyclerview.layoutManager = layoutManager
        view.tab3_recyclerview.setHasFixedSize(true)
        view.tab3_recyclerview.setItemViewCacheSize(10000)
        view.tab3_recyclerview.isDrawingCacheEnabled = true
        view.tab3_recyclerview.isNestedScrollingEnabled = true
        view.tab3_recyclerview.overScrollMode = View.OVER_SCROLL_NEVER
        view.tab3_recyclerview.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

        val data: ArrayList<TabFifthListData> = DataStringTools(context!!).tab5MenuData(R.array.tab3Text
                , R.array.tab3Image
                , R.drawable.unknown_picture)

        val adapter = TabFifthAdapter(data, context!!,3)
        view.tab3_recyclerview.adapter = adapter

        return view
    }

    private fun setShortText(text : TextView) {

        val vto = text.viewTreeObserver
        vto.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {

            override fun onGlobalLayout() {
                val obs = text.viewTreeObserver
                obs.removeOnGlobalLayoutListener(this)
                if (text.lineCount > 3) {
                    val lineEndIndex = text.layout.getLineEnd(2)
                    val texts :String = text.text.subSequence(0, lineEndIndex - 3).toString() + " ..."
                    text.text = texts
                }
            }
        })

    }

    private fun showHideMore() {

        if (showDetail) {
            view.tab_3_detail_short.visibility = View.VISIBLE
            view.tab_3_detail_full.visibility = View.GONE
            view.tab3_show_more_btn.text = "แสดงเพิ่มเติม"
            showDetail = false
        } else {
            view.tab_3_detail_short.visibility = View.GONE
            view.tab_3_detail_full.visibility = View.VISIBLE
            view.tab3_show_more_btn.text = "ย่อข้อความ"
            showDetail = true
        }

    }

}
