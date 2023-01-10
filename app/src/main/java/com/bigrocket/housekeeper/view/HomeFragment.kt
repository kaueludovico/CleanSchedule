package com.bigrocket.housekeeper.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bigrocket.housekeeper.R
import com.bigrocket.housekeeper.model.TypeService
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickButtons()
    }

    fun setClickButtons() {
        imageButtonEasy.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeToSchedule(
                1
            )
            findNavController().navigate(action)
        }
        imageButtonMedium.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeToSchedule(
                2
            )
            findNavController().navigate(action)
        }
        imageButtonHard.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeToSchedule(
                3
            )
            findNavController().navigate(action)
        }
    }
}