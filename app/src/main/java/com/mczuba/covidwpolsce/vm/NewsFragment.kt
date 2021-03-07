package com.mczuba.covidwpolsce.vm

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mczuba.covidwpolsce.data.CountryNews
import com.mczuba.covidwpolsce.data.RegionHistory
import com.mczuba.covidwpolsce.databinding.FragmentNewsBinding
import com.mczuba.covidwpolsce.databinding.FragmentRegionsBinding
import com.mczuba.covidwpolsce.vm.region.NewsAdapter
import com.mczuba.covidwpolsce.vm.region.RegionAdapter

class NewsFragment : Fragment() {
    private lateinit var binding : FragmentNewsBinding
    private val viewModel by lazy {
        ViewModelProvider(this).get(NewsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        viewModel.entry.observe(viewLifecycleOwner, newsObserver)
        //viewModel.updateData()
    }

    private val newsObserver = Observer<List<CountryNews>> { news ->
        binding.progressBar.visibility = View.INVISIBLE

        val adapter = NewsAdapter(requireContext(), ArrayList(news))
        binding.rvNews.adapter = adapter

        if(binding.rvNews.layoutManager==null)
            binding.rvNews.layoutManager = GridLayoutManager(requireContext(), 1)
    }
}