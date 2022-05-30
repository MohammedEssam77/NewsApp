package com.example.newkotlindagger.pojo


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Source(
    val id: String?,
    val name: String
) : Parcelable