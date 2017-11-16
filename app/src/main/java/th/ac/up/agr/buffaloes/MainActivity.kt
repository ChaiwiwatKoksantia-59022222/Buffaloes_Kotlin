package th.ac.up.agr.buffaloes

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.roughike.bottombar.OnTabSelectListener

import kotlinx.android.synthetic.main.activity_main.*
import th.ac.up.agr.buffaloes.Fragment.*

class MainActivity : AppCompatActivity() {

    lateinit var s: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomBar.setOnTabSelectListener { tabId ->
            when (tabId){
                R.id.nav_tab_1 -> supportFragmentManager.beginTransaction().replace(R.id.main_frame,TabFirstFragment()).commit()
                R.id.nav_tab_2 -> supportFragmentManager.beginTransaction().replace(R.id.main_frame,TabSecondFragment()).commit()
                R.id.nav_tab_3 -> supportFragmentManager.beginTransaction().replace(R.id.main_frame,TabThirdFragment()).commit()
                R.id.nav_tab_4 -> supportFragmentManager.beginTransaction().replace(R.id.main_frame,TabFourthFragment()).commit()
                else -> supportFragmentManager.beginTransaction().replace(R.id.main_frame,TabFifthFragment()).commit()
            }
        }

    }

}
