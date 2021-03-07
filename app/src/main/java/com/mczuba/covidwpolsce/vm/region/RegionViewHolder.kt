package com.mczuba.covidwpolsce.vm.region

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mczuba.covidwpolsce.data.Region
import com.mczuba.covidwpolsce.data.RegionHistory
import com.mczuba.covidwpolsce.databinding.ItemRegionBinding

class RegionViewHolder(var binding: ItemRegionBinding, val context: Context) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: RegionHistory) {
        binding.region = data
        binding.executePendingBindings()
    }
}