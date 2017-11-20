package th.ac.up.agr.buffaloes.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_treat.view.*
import th.ac.up.agr.buffaloes.Adapter.TreatAdapter
import th.ac.up.agr.buffaloes.Data.TreatData

import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.Tools.DataStringTools
import th.ac.up.agr.buffaloes.Tools.DeviceUtils
import th.ac.up.agr.buffaloes.Tools.PreCachingLinearLayoutManeger


/**
 * A simple [Fragment] subclass.
 */
class TreatFragment : Fragment() {

    companion object {

        fun newInstance(title: String): TreatFragment {
            val args = Bundle()
            args.putString("TITLE", title)
            //args.putInt("value", value)
            //args.putSerializable("testData", testData)
            val fragment = TreatFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_treat, container, false)

        val title = arguments.getString("TITLE")
        view.treat_title_name.text = title

        val layoutManager = PreCachingLinearLayoutManeger(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.extraLayoutSpace = DeviceUtils(context).getScreenHeight()
        layoutManager.reverseLayout = false
        view.treat_recyclerview.layoutManager = layoutManager
        view.treat_recyclerview.setHasFixedSize(true)
        view.treat_recyclerview.setItemViewCacheSize(10000)
        view.treat_recyclerview.isDrawingCacheEnabled = true
        view.treat_recyclerview.overScrollMode = View.OVER_SCROLL_NEVER
        view.treat_recyclerview.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

        val data: ArrayList<TreatData> = DataStringTools(context).treatData(R.array.treat_title_text
                , R.array.treat_des_text)

        val adapter = TreatAdapter(data,context)
        view.treat_recyclerview.adapter = adapter

        return view
    }

}