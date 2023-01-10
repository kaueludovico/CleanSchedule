package com.bigrocket.housekeeper.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bigrocket.housekeeper.R
import kotlinx.android.synthetic.main.fragment_success.*

class SuccessFragment : Fragment(R.layout.fragment_success) {

    private val scheduleArgs: SuccessFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setClickButton()
    }

    fun setClickButton() {
        button.setOnClickListener {
            var action  = SuccessFragmentDirections.actionSuccessFragmentToListScheduleFragment(
                scheduleArgs.schedule
            )
            findNavController().navigate(action)
        }
    }
}