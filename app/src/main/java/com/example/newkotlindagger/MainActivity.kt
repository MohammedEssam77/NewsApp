package com.example.newkotlindagger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.newkotlindagger.adapter.Navigate
import com.example.newkotlindagger.fragments.DetailsFragment
import com.example.newkotlindagger.fragments.MainFragment
import com.example.newkotlindagger.pojo.NewsModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Navigate {
    private var fragmentTransaction: FragmentTransaction? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentMain = MainFragment()
        replaceFragment(fragmentMain)
    }

    fun replaceFragment(fragment: Fragment?) {
        fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction!!.add(R.id.fragment, fragment!!).commit()
    }

    override fun replaceFragments(newsModel: NewsModel) {
        fragmentTransaction = supportFragmentManager.beginTransaction()
        val fragmentDetails = DetailsFragment()
        val bundle = Bundle()
        bundle.putParcelable("ApiModelObj", newsModel)
        fragmentDetails.setArguments(bundle)
        fragmentTransaction!!.addToBackStack("MainFragment")
        fragmentTransaction!!.replace(R.id.content, fragmentDetails).commit()
    }
}