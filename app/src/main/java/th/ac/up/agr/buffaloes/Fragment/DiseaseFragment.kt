package th.ac.up.agr.buffaloes.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.TextView
import kotlinx.android.synthetic.main.fragment_disease.view.*
import th.ac.up.agr.buffaloes.Adapter.DiseaseAdapter
import th.ac.up.agr.buffaloes.Data.DiseaseData
import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.Tools.DataStringTools
import th.ac.up.agr.buffaloes.Tools.DeviceUtils
import th.ac.up.agr.buffaloes.Tools.PreCachingLinearLayoutManeger
import android.support.v7.widget.RecyclerView
import android.util.Log


class DiseaseFragment : Fragment() {

    companion object {

        fun newInstance(title: String): DiseaseFragment {

            val args = Bundle()
            args.putString("TITLE", title)
            //args.putInt("value", value)
            //args.putSerializable("testData", testData)
            val fragment = DiseaseFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_disease, container, false)

        val title = arguments?.getString("TITLE")
        view.disease_title_name.text = title

        val layoutManager = PreCachingLinearLayoutManeger(context!!)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.extraLayoutSpace = DeviceUtils(context!!).getScreenHeight()
        layoutManager.reverseLayout = false
        view.disease_recyclerview.layoutManager = layoutManager
        view.disease_recyclerview.setHasFixedSize(true)
        view.disease_recyclerview.setItemViewCacheSize(10000)
        view.disease_recyclerview.isDrawingCacheEnabled = true
        view.disease_recyclerview.overScrollMode = View.OVER_SCROLL_NEVER
        view.disease_recyclerview.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

        val data: ArrayList<DiseaseData> = DataStringTools(context!!).DiseaseData(R.array.disease_title_text
                , R.array.disease_cause_text
                , R.array.disease_symptom_text
                , R.array.disease_treatment_text)

        val adapter = DiseaseAdapter(data, context!!)
        view.disease_recyclerview.adapter = adapter



        return view
    }


    private fun getShortText(text : TextView) {

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

}
