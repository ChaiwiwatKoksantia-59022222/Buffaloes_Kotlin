package th.ac.up.agr.buffaloes.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_tab_fourth.view.*
import th.ac.up.agr.buffaloes.Adapter.TabFifthAdapter
import th.ac.up.agr.buffaloes.Data.TabFifthListData

import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.Tools.DataStringTools
import th.ac.up.agr.buffaloes.Tools.DeviceUtils
import th.ac.up.agr.buffaloes.Tools.PreCachingGridLayoutManeger
import java.util.ArrayList


class TabFourthFragment : Fragment() {

    internal lateinit var view: View

    var showDetail :Boolean = true

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        view = inflater!!.inflate(R.layout.fragment_tab_fourth, container, false)

        setShortText(view.tab_4_detail_short)
        showHideMore()


        view.tab4_show_more_btn.setOnClickListener {
            showHideMore()
        }

        val layoutManager = PreCachingGridLayoutManeger(context,3)
        layoutManager.orientation = GridLayoutManager.VERTICAL
        layoutManager.extraLayoutSpace = DeviceUtils(context).getScreenHeight()
        layoutManager.reverseLayout = false
        view.tab4_recyclerview.layoutManager = layoutManager
        view.tab4_recyclerview.setHasFixedSize(true)
        view.tab4_recyclerview.setItemViewCacheSize(10000)
        view.tab4_recyclerview.isDrawingCacheEnabled = true
        view.tab4_recyclerview.isNestedScrollingEnabled = true
        view.tab4_recyclerview.overScrollMode = View.OVER_SCROLL_NEVER
        view.tab4_recyclerview.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

        val data: ArrayList<TabFifthListData> = DataStringTools(context).tab5MenuData(R.array.tab4Text
                , R.array.tab4Image
                , R.drawable.unknown_picture)

        val adapter = TabFifthAdapter(data, context,4)
        view.tab4_recyclerview.adapter = adapter


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
            view.tab_4_detail_short.visibility = View.VISIBLE
            view.tab_4_detail_full.visibility = View.GONE
            view.tab4_show_more_btn.text = "แสดงเพิ่มเติม"
            showDetail = false
        } else {
            view.tab_4_detail_short.visibility = View.GONE
            view.tab_4_detail_full.visibility = View.VISIBLE
            view.tab4_show_more_btn.text = "ย่อข้อความ"
            showDetail = true
        }

    }

}
