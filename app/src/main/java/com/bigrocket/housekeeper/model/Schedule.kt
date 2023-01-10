package com.bigrocket.housekeeper.model

import java.io.Serializable

data class Schedule(
    var type: String,
    var date: String,
    var address: Address
) : Serializable
