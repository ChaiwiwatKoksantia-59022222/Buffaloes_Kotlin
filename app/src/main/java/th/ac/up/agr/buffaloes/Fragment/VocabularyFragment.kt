package th.ac.up.agr.buffaloes.Fragment

import android.annotation.SuppressLint
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_vocabulary.view.*
import th.ac.up.agr.buffaloes.Adapter.VocabularyAdapter
import th.ac.up.agr.buffaloes.Data.VocabularyData

import th.ac.up.agr.buffaloes.R
import th.ac.up.agr.buffaloes.Tools.DataStringTools
import th.ac.up.agr.buffaloes.Tools.DeviceUtils
import th.ac.up.agr.buffaloes.Tools.PreCachingLinearLayoutManeger

class VocabularyFragment : Fragment() {

    companion object {

        fun newInstance(title: String): VocabularyFragment {

            val args = Bundle()
            args.putString("TITLE", title)
            //args.putInt("value", value)
            //args.putSerializable("testData", testData)
            val fragment = VocabularyFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_vocabulary,container,false)

        val title = arguments.getString("TITLE")
        view.vocabulary_title_name.text = title

        val layoutManager = PreCachingLinearLayoutManeger(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        layoutManager.extraLayoutSpace = DeviceUtils(context).getScreenHeight()
        layoutManager.reverseLayout = false
        view.vocabulary_recyclerview.layoutManager = layoutManager
        view.vocabulary_recyclerview.setHasFixedSize(true)
        view.vocabulary_recyclerview.setItemViewCacheSize(10000)
        view.vocabulary_recyclerview.isDrawingCacheEnabled = true
        view.vocabulary_recyclerview.overScrollMode = View.OVER_SCROLL_NEVER
        view.vocabulary_recyclerview.drawingCacheQuality = View.DRAWING_CACHE_QUALITY_HIGH

        val data: ArrayList<VocabularyData> = DataStringTools(context).vocabularyData(R.array.vocabulary_word_text_data
                , R.array.vocabulary_meaning_text_data)

        val adapter = VocabularyAdapter(data,context)
        view.vocabulary_recyclerview.adapter = adapter

        return view
    }
}
