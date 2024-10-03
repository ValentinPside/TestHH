package com.example.testhh1.domain.models

import com.example.testhh1.data.network.dto.ButonDto

data class Offer(
    val id: String?,
    val title: String,
    val button: Buton?,
    val link: String
)
