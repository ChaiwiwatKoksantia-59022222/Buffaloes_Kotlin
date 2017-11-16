package th.ac.up.agr.buffaloes.Tools

import android.content.Context
import android.content.res.TypedArray
import th.ac.up.agr.buffaloes.Data.TabFifthListData
import th.ac.up.agr.buffaloes.Data.TabSecondListData
import th.ac.up.agr.buffaloes.Data.VocabularyData

/**
 * Created by androidstudio on 11/13/2017 AD.
 */
class DataStringTools {

    private val context: Context

    constructor(context: Context) {
        this.context = context
    }

    fun getData(resourceID: Int): ArrayList<String> {
        val typedArray: TypedArray = context.resources.obtainTypedArray(resourceID)
        var arrayString: ArrayList<String> = ArrayList()
        (0 until typedArray.length()).mapTo(arrayString) { typedArray.getString(it) }
        typedArray.recycle()
        return arrayString
    }

    fun vocabularyData(title: Int, desText: Int): ArrayList<VocabularyData> {

        val typedArrayTitle: TypedArray = context.resources.obtainTypedArray(title)
        val typedArrayDes: TypedArray = context.resources.obtainTypedArray(desText)
        var data: ArrayList<VocabularyData> = ArrayList()
        (0 until typedArrayTitle.length()).mapTo(data) {
            VocabularyData(typedArrayTitle.getString(it)
                    , typedArrayDes.getString(it))
        }
        typedArrayTitle.recycle()
        typedArrayDes.recycle()
        return data

    }

    fun tab2Data(title: Int, desText: Int, image: Int, defaultRes: Int): ArrayList<TabSecondListData> {
        val typedArrayTitle: TypedArray = context.resources.obtainTypedArray(title)
        val typedArrayDes: TypedArray = context.resources.obtainTypedArray(desText)
        val typedArrayImage: TypedArray = context.resources.obtainTypedArray(image)
        var data: ArrayList<TabSecondListData> = ArrayList()
        (0 until typedArrayTitle.length()).mapTo(data) {
            TabSecondListData(typedArrayTitle.getString(it)
                    , typedArrayImage.getResourceId(it, defaultRes)
                    , typedArrayDes.getString(it))
        }
        typedArrayTitle.recycle()
        typedArrayDes.recycle()
        typedArrayImage.recycle()
        return data
    }

    fun tab5MenuData(text: Int, image: Int, defaultRes: Int): ArrayList<TabFifthListData> {
        val typedArrayTitle: TypedArray = context.resources.obtainTypedArray(text)
        val typedArrayImage: TypedArray = context.resources.obtainTypedArray(image)
        var data: ArrayList<TabFifthListData> = ArrayList()
        (0 until typedArrayTitle.length()).mapTo(data) {
            TabFifthListData(typedArrayTitle.getString(it)
                    , typedArrayImage.getResourceId(it, defaultRes))
        }
        typedArrayTitle.recycle()
        typedArrayImage.recycle()
        return data
    }

}