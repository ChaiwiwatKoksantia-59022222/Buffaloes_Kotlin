package th.ac.up.agr.buffaloes.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_device.view.*
import th.ac.up.agr.buffaloes.Adapter.DeviceAdapter
import th.ac.up.agr.buffaloes.Data.DeviceData

import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.Tools.DataStringTools
import th.ac.up.agr.buffaloes.Tools.DeviceUtils
import th.ac.up.agr.buffaloes.Tools.PreCachingLinearLayoutManeger

class DeviceFragment : Fragment() {


    companion object {

        fun newInstance(title: String,subTitle :String,ID:Int): DeviceFragment {
            val args = Bundle()
            args.putString("TITLE", title)
            args.putString("SUB",subTitle)
            args.putInt("ID",ID)
            //args.putInt("value", value)
            //args.putSerializable("testData", testData)
            val fragment = DeviceFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_device, container, false)

        val title = arguments.getString("TITLE")
        val subTitle = arguments.getString("SUB")
        val ID = arguments.getInt("ID")
        view.device_title_name.text = title
        view.device_name_sub.text = subTitle

        val layoutManager = PreCachingLinearLayoutManeger(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.extraLayoutSpace = DeviceUtils(context).getScreenHeight()
        layoutManager.reverseLayout = false
        view.device_recyclerview.layoutManager = layoutManager
        view.device_recyclerview.setHasFixedSize(true)
        view.device_recyclerview.setItemViewCacheSize(10000)
        view.device_recyclerview.isDrawingCacheEnabled = true
        view.device_recyclerview.overScrollMode = View.OVER_SCROLL_NEVER
        view.device_recyclerview.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

        var data: ArrayList<DeviceData> = ArrayList()

        when (ID) {
            31 -> {
                data = DataStringTools(context).DeviceData(R.array.induction_equipment_text_data
                        , R.array.induction_equipment_image_data
                        , R.drawable.unknown_picture,R.array.induction_equipment_description)
            }
            40 -> {
                data = DataStringTools(context).DeviceData(R.array.artificial_insemination_short_method_text_data
                        , R.array.artificial_insemination_method_image_data
                        , R.drawable.unknown_picture,R.array.artificial_insemination_equipment_description)
            }
            42 -> {
                data = DataStringTools(context).DeviceData(R.array.artificial_insemination_equipment_text_data
                        , R.array.artificial_insemination_image_data
                        , R.drawable.unknown_picture,R.array.artificial_insemination_equipment_description)
            }
        }

        val adapter = DeviceAdapter(data, context)
        view.device_recyclerview.adapter = adapter

        return view
    }

}