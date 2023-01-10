package com.bigrocket.housekeeper.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bigrocket.housekeeper.model.User
import com.bigrocket.housekeeper.view.LoginFragment
import kotlinx.android.synthetic.main.fragment_login.*

class LoginViewModel(val fragment: LoginFragment) : ViewModel() {

    fun validateLogin(user: User, callback: (result: (Boolean)) -> Unit) {
        if (user.login.email != fragment.editTextEmail.text.toString() ||
            user.login.senha != fragment.editTextPassword.text.toString()) {
            callback.invoke(false)
        } else {
            callback.invoke(true)
        }
    }

    class LoginViewModelFactory(
        val fragment: LoginFragment
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return LoginViewModel(fragment) as T
        }
    }
}