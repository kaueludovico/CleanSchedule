package com.bigrocket.housekeeper.model

import java.io.Serializable

data class TypeService(
    var easy: Int,
    var medium: Int,
    var hard: Int
) : Serializable
