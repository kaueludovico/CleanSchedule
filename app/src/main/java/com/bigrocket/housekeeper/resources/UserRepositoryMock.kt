package com.bigrocket.housekeeper.resources

import com.bigrocket.housekeeper.model.Address
import com.bigrocket.housekeeper.model.Login
import com.bigrocket.housekeeper.model.User

class UserRepositoryMock {
    fun createUser(user: User, callback: (user: User) -> Unit) {
        callback.invoke(mockuser(user))
    }

    fun mockuser(user: User): User {
        return User(
            user.id,
            user.name,
            user.birth,
            user.cpf,
            user.rg,
            user.address,
            user.login
        )
    }
}