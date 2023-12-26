package com.example.pam9.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Kontak(
    val id: Int,
    val nama: String,
    @SerialName("email")
    val alamat: String,
    @SerialName("nohp")
    val telpon: String
)
