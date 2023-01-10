package com.bigrocket.housekeeper.view

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bigrocket.housekeeper.R
import com.bigrocket.housekeeper.model.Address
import com.bigrocket.housekeeper.model.Login
import com.bigrocket.housekeeper.model.User
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.buttonCalendar
import kotlinx.android.synthetic.main.fragment_register.editTextAddress
import kotlinx.android.synthetic.main.fragment_register.editTextCity
import kotlinx.android.synthetic.main.fragment_register.editTextCountry
import kotlinx.android.synthetic.main.fragment_register.editTextDistrict
import kotlinx.android.synthetic.main.fragment_register.editTextNumber
import kotlinx.android.synthetic.main.fragment_register.editTextState
import java.text.SimpleDateFormat
import java.util.*


class RegisterFragment : Fragment(R.layout.fragment_register) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonRegisterAction.setOnClickListener {
            setCreateUser()
        }

        buttonCalendar.setOnClickListener {
            callCalendar()
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

            editTextBirth.setText(dateFormatted)
        }, year, month, day)
        dpd.show()
    }

    fun setCreateUser() {
        val user = User(
            0,
            editTextName.text.toString(),
            editTextBirth.text.toString(),
            editTextCpf.text.toString(),
            editTextRg.text.toString(),
            Address(
                editTextAddress.text.toString(),
                editTextNumber.text.toString(),
                editTextDistrict.text.toString(),
                editTextCity.text.toString(),
                editTextState.text.toString(),
                editTextCountry.text.toString()
            ),
            Login(
                editTextEmailRegister.text.toString(),
                editTextPasswordRegister.text.toString()
            )
        )

        val action = RegisterFragmentDirections.actionRegisterFragmentToLoginFragment(
            user
        )
        findNavController().navigate(action)
    }
}