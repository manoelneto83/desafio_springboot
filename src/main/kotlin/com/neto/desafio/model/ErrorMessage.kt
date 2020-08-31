package com.neto.desafio.model

import java.util.*

data class ErrorMessage(

        val timestamp: Date = Date(),
        var status: Int,
        val error: String = "",
        val message: String = ""

)