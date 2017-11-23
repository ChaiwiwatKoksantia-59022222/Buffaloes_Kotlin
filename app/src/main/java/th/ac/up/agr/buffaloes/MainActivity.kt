package th.ac.up.agr.buffaloes

import android.app.Dialog
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.Window
import com.roughike.bottombar.OnTabSelectListener

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog.*
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

    override fun onBackPressed() {
        exitDialog("คุณต้องการที่จะออกจากแอป?", "ยกเลิก", "ยืนยัน")
    }

    fun exitDialog(text :String,cancel :String,confirm :String){

        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.dialog)
        dialog.setCancelable(true)
        dialog.show()

        dialog.can_textview_dialog.text = text

        dialog.can_cancel_btn.text = cancel
        dialog.can_cancel_btn.visibility = View.VISIBLE
        dialog.can_cancel_btn.setOnClickListener {
            dialog.cancel()
        }

        dialog.can_confirm_btn.text = confirm
        dialog.can_confirm_btn.visibility = View.VISIBLE
        dialog.can_confirm_btn.setOnClickListener {

            dialog.cancel()
            finish()

        }

        //val textView = dialog.findViewById(R.id.can_textview_dialog)
        //textView.setText(text)



    }
}
