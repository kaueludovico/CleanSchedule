package com.bigrocket.housekeeper.model

import java.io.Serializable

data class Address(
    var street: String,
    var number: String,
    var district: String,
    var city: String,
    var state: String,
    var country: String
) : Serializable
