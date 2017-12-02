package th.ac.up.agr.buffaloes.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_breed.view.*
import th.ac.up.agr.buffaloes.Adapter.BreedAdapter
import th.ac.up.agr.buffaloes.Data.BreedData

import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.Tools.DataStringTools
import th.ac.up.agr.buffaloes.Tools.DeviceUtils
import th.ac.up.agr.buffaloes.Tools.PreCachingLinearLayoutManeger

class BreedFragment : Fragment() {

    var show: Boolean = false

    companion object {

        fun newInstance(title: String): BreedFragment {

            val args = Bundle()
            args.putString("TITLE", title)
            //args.putInt("value", value)
            //args.putSerializable("testData", testData)
            val fragment = BreedFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_breed, container, false)

        val title = arguments.getString("TITLE")
        view.breed_title_name.text = title

        showHide(view, false)
        getShortText(view.breed_detail_short)

        view.breed_show_more_btn.setOnClickListener {
            if (show) {
                showHide(view, false)
                show = false
            } else {
                showHide(view, true)
                show = true
            }
        }

        val layoutManager = PreCachingLinearLayoutManeger(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.extraLayoutSpace = DeviceUtils(context).getScreenHeight()
        layoutManager.reverseLayout = false
        view.breed_recyclerview.layoutManager = layoutManager
        view.breed_recyclerview.setHasFixedSize(true)
        view.breed_recyclerview.setItemViewCacheSize(10000)
        view.breed_recyclerview.isDrawingCacheEnabled = true
        view.breed_recyclerview.overScrollMode = View.OVER_SCROLL_NEVER
        view.breed_recyclerview.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

        val data: ArrayList<BreedData> = DataStringTools(context).breedData(R.array.breed_title_text
                , R.array.breed_des_text, R.array.breed_image, R.drawable.unknown_picture)

        val adapter = BreedAdapter(data, context)
        view.breed_recyclerview.adapter = adapter

        return view
    }

    private fun getShortText(text: TextView) {

        val vto = text.viewTreeObserver
        vto.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {

            override fun onGlobalLayout() {
                val obs = text.viewTreeObserver
                obs.removeOnGlobalLayoutListener(this)
                if (text.lineCount > 3) {
                    val lineEndIndex = text.layout.getLineEnd(2)
                    val texts: String = text.text.subSequence(0, lineEndIndex - 3).toString() + " ..."
                    text.text = texts
                }
            }
        })

    }

    private fun showHide(view: View, check: Boolean) {
        if (!check) {
            view.breed_show_more_btn.text = "แสดงเพิ่มเติม"
            view.breed_detail_short.visibility = View.VISIBLE
            view.breed_detail_full.visibility = View.GONE
        } else {
            view.breed_show_more_btn.text = "ย่อข้อความ"
            view.breed_detail_short.visibility = View.GONE
            view.breed_detail_full.visibility = View.VISIBLE
        }
    }

}
