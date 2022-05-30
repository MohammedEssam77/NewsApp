package com.example.newkotlindagger.pojo


import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class NewsModel(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
) : Parcelable

