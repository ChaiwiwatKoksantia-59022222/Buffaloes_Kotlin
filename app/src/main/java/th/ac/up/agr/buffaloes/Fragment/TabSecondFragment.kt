package th.ac.up.agr.buffaloes.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_tab_second.view.*
import th.ac.up.agr.buffaloes.Adapter.TabSecondAdapter
import th.ac.up.agr.buffaloes.Data.TabSecondListData

import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.Tools.DataStringTools
import th.ac.up.agr.buffaloes.Tools.DeviceUtils
import th.ac.up.agr.buffaloes.Tools.PreCachingLinearLayoutManeger


class TabSecondFragment : Fragment() {

    internal lateinit var view: View

    private var showDetail: Boolean = true

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        view = inflater!!.inflate(R.layout.fragment_tab_second, container, false)
        setShortText(view.tab_2_detail_short)
        showHideMore()


        view.tab2_show_more_btn.setOnClickListener {
            showHideMore()
        }

        //view.tab2_recyclerview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        val layoutManager = PreCachingLinearLayoutManeger(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.extraLayoutSpace = DeviceUtils(context).getScreenHeight()
        layoutManager.reverseLayout = false
        view.tab2_recyclerview.layoutManager = layoutManager
        view.tab2_recyclerview.setHasFixedSize(true)
        view.tab2_recyclerview.setItemViewCacheSize(10000)
        view.tab2_recyclerview.isDrawingCacheEnabled = true
        view.tab2_recyclerview.isNestedScrollingEnabled = true
        view.tab2_recyclerview.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

        val data: ArrayList<TabSecondListData> = DataStringTools(context).tab2Data(R.array.behavior_text_data
                , R.array.behavior_text_data_des
                , R.array.behavior_image_data
                , R.drawable.unknown_picture)

        val adapter = TabSecondAdapter(data, context)
        view.tab2_recyclerview.adapter = adapter

        return view
    }

    private fun setShortText(text: TextView) {

        val vto = text.viewTreeObserver
        vto.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {

            override fun onGlobalLayout() {
                val obs = text.viewTreeObserver
                //obs.removeGlobalOnLayoutListener(this)
                obs.removeOnGlobalLayoutListener(this)
                if (text.lineCount > 3) {
                    val lineEndIndex = text.layout.getLineEnd(2)
                    val texts: String = text.text.subSequence(0, lineEndIndex - 3).toString() + " ..."
                    text.text = texts
                }
            }
        })

    }

    private fun showHideMore() {

        if (showDetail) {
            view.tab_2_detail_short.visibility = View.VISIBLE
            view.tab_2_detail_full.visibility = View.GONE
            view.tab2_show_more_btn.text = "แสดงเพิ่มเติม"
            showDetail = false
        } else {
            view.tab_2_detail_short.visibility = View.GONE
            view.tab_2_detail_full.visibility = View.VISIBLE
            view.tab2_show_more_btn.text = "ย่อข้อความ"
            showDetail = true
        }

    }


}