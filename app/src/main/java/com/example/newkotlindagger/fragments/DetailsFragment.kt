package com.example.newkotlindagger.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
 import com.example.newkotlindagger.databinding.FragmentDetailsBinding
import com.example.newkotlindagger.pojo.NewsModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class DetailsFragment : Fragment() {
    private lateinit var newsModel: NewsModel
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (getArguments() != null) newsModel = requireArguments().getParcelable("ApiModelObj")!!
        binding.textTitle.text = newsModel.title
        binding.descriptionTitle.text = newsModel.description
        Picasso.get().load(newsModel.url).into(binding.coverImg)

        binding = FragmentDetailsBinding.inflate(inflater)
        return binding.root
    }

}