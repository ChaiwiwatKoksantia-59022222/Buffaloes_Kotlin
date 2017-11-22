package th.ac.up.agr.buffaloes.Tools

import android.content.Context
import android.content.res.TypedArray
import th.ac.up.agr.buffaloes.Data.*

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

    fun programData(title: Int, circleText: Int, description: Int, image: Int, defaultRes: Int): ArrayList<ProgramData> {

        val typedArrayTitle: TypedArray = context.resources.obtainTypedArray(title)
        val typedArrayCircle: TypedArray = context.resources.obtainTypedArray(circleText)
        val typedArrayDes: TypedArray = context.resources.obtainTypedArray(description)
        val typedArrayImage: TypedArray = context.resources.obtainTypedArray(image)
        var data: ArrayList<ProgramData> = ArrayList()
        (0 until typedArrayTitle.length()).mapTo(data) {
            ProgramData(typedArrayTitle.getString(it)
                    , typedArrayCircle.getString(it)
                    , typedArrayDes.getString(it)
                    , typedArrayImage.getResourceId(it, defaultRes))
        }
        typedArrayImage.recycle()
        typedArrayCircle.recycle()
        typedArrayTitle.recycle()
        typedArrayDes.recycle()
        return data

    }

    fun treatData(title: Int, desText: Int): ArrayList<TreatData> {
        val typedArrayTitle: TypedArray = context.resources.obtainTypedArray(title)
        val typedArrayDes: TypedArray = context.resources.obtainTypedArray(desText)
        var data: ArrayList<TreatData> = ArrayList()
        var count = 0
        (0 until typedArrayTitle.length()).mapTo(data) {
            TreatData(typedArrayTitle.getString(it)
                    , typedArrayDes.getString(it))
        }
        typedArrayTitle.recycle()
        typedArrayDes.recycle()
        return data

    }

    fun breedData(title: Int, desText: Int): ArrayList<BreedData> {
        val typedArrayTitle: TypedArray = context.resources.obtainTypedArray(title)
        val typedArrayDes: TypedArray = context.resources.obtainTypedArray(desText)
        var data: ArrayList<BreedData> = ArrayList()
        var count = 0
        (0 until typedArrayTitle.length()).mapTo(data) {
            BreedData(typedArrayTitle.getString(it)
                    , typedArrayDes.getString(it))
        }
        typedArrayTitle.recycle()
        typedArrayDes.recycle()
        return data

    }

    fun DeviceData(title: Int, image: Int, defaultRes: Int): ArrayList<DeviceData> {
        val typedArrayTitle: TypedArray = context.resources.obtainTypedArray(title)
        val typedArrayImage: TypedArray = context.resources.obtainTypedArray(image)
        var data: ArrayList<DeviceData> = ArrayList()
        var count = 0
        (0 until typedArrayTitle.length()).mapTo(data) {
            DeviceData(typedArrayTitle.getString(it)
                    , typedArrayImage.getResourceId(it, defaultRes))
        }
        typedArrayTitle.recycle()
        typedArrayImage.recycle()
        return data

    }

    fun DiseaseData(title: Int, cause: Int, symptom: Int, treatment: Int): ArrayList<DiseaseData> {

        val typedArrayTitle: TypedArray = context.resources.obtainTypedArray(title)
        val typedArrayCause: TypedArray = context.resources.obtainTypedArray(cause)
        val typedArraySymptom: TypedArray = context.resources.obtainTypedArray(symptom)
        val typedArrayTreatment: TypedArray = context.resources.obtainTypedArray(treatment)
        var data: ArrayList<DiseaseData> = ArrayList()
        (0 until typedArrayTitle.length()).mapTo(data) {
            DiseaseData(typedArrayTitle.getString(it)
                    , typedArrayCause.getString(it)
                    , typedArraySymptom.getString(it)
                    , typedArrayTreatment.getString(it))
        }
        typedArrayTitle.recycle()
        typedArrayCause.recycle()
        typedArraySymptom.recycle()
        typedArrayTreatment.recycle()
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