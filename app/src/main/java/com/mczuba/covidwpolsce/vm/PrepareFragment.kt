package com.mczuba.covidwpolsce.vm

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.mczuba.covidwpolsce.R
import com.mczuba.covidwpolsce.api.CovidDataProvider
import com.mczuba.covidwpolsce.databinding.FragmentPrepareBinding
import com.mczuba.covidwpolsce.databinding.FragmentRegionsBinding
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class PrepareFragment : Fragment() {
    lateinit var binding: FragmentPrepareBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentPrepareBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.btnRetry.setOnClickListener {
            binding.failedView.visibility = View.GONE
            binding.progressBar.visibility = View.VISIBLE
            TryConnect()
        }

        TryConnect()
    }

    fun TryConnect() {
        MainScope().launch {
            CovidDataProvider.init()
            val c = CovidDataProvider.country.value
            val r = CovidDataProvider.regions.value

            if(r!=null && c!=null)
            {
                val direction = PrepareFragmentDirections.actionPrepareFragmentToSummaryFragment()
                findNavController().run {
                    graph.startDestination = R.id.navigation_summary
                    navigate(direction)
                }
            }
            else
            {
                Toast.makeText(requireContext(),"Nie udało się połączyć!", Toast.LENGTH_LONG).show()
                binding.failedView.visibility = View.VISIBLE
                binding.progressBar.visibility = View.GONE
            }
        }
    }
}