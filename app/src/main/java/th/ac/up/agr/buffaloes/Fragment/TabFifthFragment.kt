package th.ac.up.agr.buffaloes.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_tab_fifth.view.*
import th.ac.up.agr.buffaloes.Adapter.TabFifthAdapter
import th.ac.up.agr.buffaloes.Data.TabFifthListData

import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.Tools.DataStringTools
import th.ac.up.agr.buffaloes.Tools.DeviceUtils
import th.ac.up.agr.buffaloes.Tools.PreCachingGridLayoutManeger
import java.time.Month
import java.util.*

class TabFifthFragment : Fragment() {

    internal lateinit var view: View
    var dateCurrent :String = ""

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        view = inflater!!.inflate(R.layout.fragment_tab_fifth, container, false)


        val layoutManager = PreCachingGridLayoutManeger(context,3)
        layoutManager.orientation = GridLayoutManager.VERTICAL
        layoutManager.extraLayoutSpace = DeviceUtils(context).getScreenHeight()
        layoutManager.reverseLayout = false
        view.tab5_recyclerview.layoutManager = layoutManager
        view.tab5_recyclerview.setHasFixedSize(true)
        view.tab5_recyclerview.setItemViewCacheSize(10000)
        view.tab5_recyclerview.isDrawingCacheEnabled = true
        view.tab5_recyclerview.isNestedScrollingEnabled = true
        view.tab5_recyclerview.overScrollMode = View.OVER_SCROLL_NEVER
        view.tab5_recyclerview.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

        val data: ArrayList<TabFifthListData> = DataStringTools(context).tab5MenuData(R.array.tab5Text
                , R.array.tab5Image
                , R.drawable.unknown_picture)

        val adapter = TabFifthAdapter(data, context,5)
        view.tab5_recyclerview.adapter = adapter

        return view
    }



}
