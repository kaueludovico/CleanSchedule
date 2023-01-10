package com.bigrocket.housekeeper.model

import java.io.Serializable

data class User(
    var id: Int,
    var name: String,
    var birth: String,
    var cpf: String,
    var rg: String,
    var address: Address,
    var login: Login
) : Serializable
