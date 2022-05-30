package com.example.newkotlindagger.adapter

import com.example.newkotlindagger.pojo.NewsModel

interface Navigate {
    fun replaceFragments (newsModel: NewsModel)
}