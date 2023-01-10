package com.bigrocket.housekeeper.view

import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bigrocket.housekeeper.R
import com.bigrocket.housekeeper.model.User
import com.bigrocket.housekeeper.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(R.layout.fragment_login) {

    private lateinit var viewModel: LoginViewModel
    private val args: LoginFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(
            this,
            LoginViewModel.LoginViewModelFactory(this)
        )[LoginViewModel::class.java]

        setClickButton()
    }
    fun setClickButton() {
        buttonLogin.setOnClickListener {
            callValidateLogin()
        }
        buttonRegister.setOnClickListener {
            findNavController().navigate(R.id.actionLoginToRegister)
        }
    }

    fun callValidateLogin() {
        args.login?.let { saveAndValidateWithViewModel(it) }
    }

    fun saveAndValidateWithViewModel(user: User) {
        viewModel.validateLogin(user) {
            if (it) {
                findNavController().navigate(R.id.actionLoginToHome)
            } else {
                Toast.makeText(
                    requireContext(),
                    "Erro ao validar login! Verifique seu email e senha e tente novamente.",
                    Toast.LENGTH_LONG)
            }
        }
    }
}