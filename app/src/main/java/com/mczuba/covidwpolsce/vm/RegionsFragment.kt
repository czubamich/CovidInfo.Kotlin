package com.mczuba.covidwpolsce.vm

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.mczuba.covidwpolsce.R
import com.mczuba.covidwpolsce.data.RegionHistory
import com.mczuba.covidwpolsce.databinding.FragmentRegionsBinding
import com.mczuba.covidwpolsce.vm.region.RegionAdapter

class RegionsFragment : Fragment() {
    private lateinit var binding : FragmentRegionsBinding
    private val viewModel by lazy {
        ViewModelProvider(this).get(RegionsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegionsBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        viewModel.regionsSummary.observe(viewLifecycleOwner, regionsObserver)
        viewModel.updateData()
    }

    private val regionsObserver = Observer<List<RegionHistory>> { summary ->
        binding.progressBar.visibility = View.INVISIBLE

        val adapter = RegionAdapter(requireContext(), ArrayList(summary))
        binding.rvHistory.adapter = adapter

        if(binding.rvHistory.layoutManager==null)
            binding.rvHistory.layoutManager = GridLayoutManager(requireContext(), 1)
    }
}