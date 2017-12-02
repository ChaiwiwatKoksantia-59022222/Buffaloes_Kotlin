package th.ac.up.agr.buffaloes

import android.app.FragmentManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import th.ac.up.agr.buffaloes.R

import kotlinx.android.synthetic.main.activity_multiply.*
import kotlinx.android.synthetic.main.fragment_vocabulary.*
import th.ac.up.agr.buffaloes.Fragment.*

class MultiplyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiply)

        val bundle = intent.extras
        val ID = bundle.getInt("ID")
        val title = bundle.getString("TITLE")

        //multiply_title_name.text = bundle.getString("TITLE")

        result_back_btn.setOnClickListener {
            finish()
        }

        Log.e("ID",ID.toString())

        when (ID){

            10 -> {

                val DAY = bundle.getInt("DAY")
                val MONTH = bundle.getInt("MONTH")
                val YEAR = bundle.getInt("YEAR")

                val fragment = ResultFirstFragment.newInstance(DAY,MONTH,YEAR)

                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame, fragment)
                        .commit()

            }

            30 -> {

                val subTitle = bundle.getString("SUB")

                val fragment = MainProgramFragment.newInstance(title,subTitle)

                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame, fragment)
                        .commit()

            }

            31 -> {

                val subTitle = bundle.getString("SUB")

                val fragment = DeviceFragment.newInstance(title,subTitle,ID)

                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame, fragment)
                        .commit()
            }
            40 -> {
                val subTitle = bundle.getString("SUB")
                val fragment = DeviceFragment.newInstance(title,subTitle,ID)

                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame, fragment)
                        .commit()
            }
            41 -> {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame, ImageFragment())
                        .commit()
            }
            42 -> {

                val subTitle = bundle.getString("SUB")
                val fragment = DeviceFragment.newInstance(title,subTitle,ID)

                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame, fragment)
                        .commit()
            }

            50 -> {

                val fragment = VocabularyFragment.newInstance(title)

                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame, fragment)
                        .commit()
            }

            51 -> {
                val fragment = BreedFragment.newInstance(title)

                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame, fragment)
                        .commit()
            }

            52 -> {
                val fragment = TreatFragment.newInstance(title)

                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame, fragment)
                        .commit()
            }

            53 -> {
                val fragment = DiseaseFragment.newInstance(title)

                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame,fragment)
                        .commit()
            }

            54 -> {

                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame,INFragment())
                        .commit()
            }

            55 -> {
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame,TeamFragment())
                        .commit()
            }
            99 -> {

                val subTitle = bundle.getString("SUB")
                val description = bundle.getString("DES")
                val image = bundle.getInt("IMAGE")
                val IDs = bundle.getInt("IDs")
                val fragment = ProsFragment.newInstance(title,subTitle,description,image,IDs)

                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame,fragment)
                        .commit()
            }
        }
    }

}
