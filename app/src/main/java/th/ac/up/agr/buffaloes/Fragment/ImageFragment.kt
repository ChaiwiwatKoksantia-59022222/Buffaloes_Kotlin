package th.ac.up.agr.buffaloes.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_image.view.*

import th.ac.up.agr.buffaloes.R


/**
 * A simple [Fragment] subclass.
 */
class ImageFragment : Fragment() {


    var check = true

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater!!.inflate(R.layout.fragment_image, container, false)

        showHide(false,view,true)

        view.image_rotate_p_btn.setOnClickListener {
            showHide(check,view,false)
        }

        return view
    }

    fun showHide(switch :Boolean,view: View,start :Boolean){

        if (!start){
            if (switch) {
                view.image_rotate_p_btn.visibility = View.VISIBLE
                view.image_rotate_p_image.visibility = View.GONE
                view.image_rotate_l_image.visibility = View.VISIBLE
                view.image_rotate_l_btn.visibility = View.GONE
                check = false

            } else {
                view.image_rotate_p_btn.visibility = View.VISIBLE
                view.image_rotate_p_image.visibility = View.VISIBLE
                view.image_rotate_l_image.visibility = View.GONE
                view.image_rotate_l_btn.visibility = View.GONE
                check = true
            }
        } else {
            view.image_rotate_p_btn.visibility = View.VISIBLE
            view.image_rotate_p_image.visibility = View.VISIBLE
            view.image_rotate_l_image.visibility = View.GONE
            view.image_rotate_l_btn.visibility = View.GONE
        }


    }

}
