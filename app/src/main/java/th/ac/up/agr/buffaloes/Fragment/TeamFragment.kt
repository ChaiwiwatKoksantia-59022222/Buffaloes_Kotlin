package th.ac.up.agr.buffaloes.Fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import th.ac.up.agr.buffaloes.R


/**
 * A simple [Fragment] subclass.
 */
class TeamFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_team, container, false)



        return view
    }

}
