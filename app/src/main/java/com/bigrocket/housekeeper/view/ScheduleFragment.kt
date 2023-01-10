package com.bigrocket.housekeeper.view

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bigrocket.housekeeper.R
import com.bigrocket.housekeeper.model.Address
import com.bigrocket.housekeeper.model.Schedule
import kotlinx.android.synthetic.main.fragment_schedule.*
import java.text.SimpleDateFormat
import java.util.Calendar

class ScheduleFragment : Fragment(R.layout.fragment_schedule) {

    val args: ScheduleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonCalendar.setOnClickListener {
            if (savedInstanceState == null) {
                callCalendar()
            }
        }
        setNavigationButtonClick()
        receiveTypeService()
    }

    private fun receiveTypeService() {
        when (args.typeService) {
            1 -> textViewTypeService.setText("Limpeza Leve")
            2 -> textViewTypeService.setText("Limpeza Média")
            3 -> textViewTypeService.setText("Limpeza Pesada")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun callCalendar() {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(requireContext(), { _, _, _, _ ->
            val dateFormatter = SimpleDateFormat("dd/MM/YYYY")
            val dateFormatted = dateFormatter.format(c.time)

            editTextDate.setText(dateFormatted)
        }, year, month, day)
        dpd.show()
    }

    private fun setNavigationButtonClick() {
        buttonSchedule.setOnClickListener {
            var schedule = Schedule(
                textViewTypeService.text.toString(),
                editTextDate.text.toString(),
                Address(
                    editTextAddress.text.toString(),
                    editTextNumber.text.toString(),
                    editTextDistrict.text.toString(),
                    editTextCity.text.toString(),
                    editTextState.text.toString(),
                    editTextCountry.text.toString())
            )
            var action = ScheduleFragmentDirections.actionScheduleToSuccess(
                schedule
            )
            findNavController().navigate(action)
        }
    }
}
