package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import com.example.navigation.data.RandomData
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass.
 *
 * create an instance of this fragment.
 */
class FirstFragement : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        firstButton.setOnClickListener {
            //get the action from the saferargs
            val randomData = RandomData().apply {
                this.data = "This data is from 1st fragment!"
            }
            val action: NavDirections =
                FirstFragementDirections.actionFirstFragementToSecondFragment(randomData)
            it.findNavController().navigate(action)
        }
    }
}