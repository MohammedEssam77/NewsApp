package com.example.newkotlindagger.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newkotlindagger.adapter.DataAdapter
import com.example.newkotlindagger.adapter.Navigate
import com.example.newkotlindagger.adapter.OnClickListner
import com.example.newkotlindagger.databinding.FragmentMainBinding
import com.example.newkotlindagger.pojo.NewsModel
import com.example.newkotlindagger.viewModel.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainFragment : Fragment(), OnClickListner {
    private var navigate: Navigate? = null
    var listModel: List<NewsModel> = emptyList()
    lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: NewsViewModel
    private var queryText = ""
    private val dataAdapter: DataAdapter by lazy {
        DataAdapter()
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.rvShowData.layoutManager = LinearLayoutManager(context)

        binding.searchKeyword.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                queryText = binding.searchKeyword.text.toString().trim().toLowerCase()

                true
            } else {
                false
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        binding.rvShowData.adapter = dataAdapter
        getData()

        viewModel.apiLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                dataAdapter.setList(it)
            } else {
                Toast.makeText(requireContext(), "Connection Failed", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun getData() {
        viewModel.getNews()

    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigate = context as Navigate
    }

    override fun onClick(position: Int) {
        navigate?.replaceFragments(listModel.get(position))
    }

}

