package th.ac.up.agr.buffaloes

import android.app.FragmentManager
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import th.ac.up.agr.buffaloes.R

import kotlinx.android.synthetic.main.activity_multiply.*
import kotlinx.android.synthetic.main.fragment_vocabulary.*
import th.ac.up.agr.buffaloes.Fragment.VocabularyFragment

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

        when (ID){
            50 -> {

                val fragment = VocabularyFragment.newInstance(title)

                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.multiply_frame, fragment)
                        .commit()
            }
        }
    }

}
