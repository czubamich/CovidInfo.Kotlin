package com.mczuba.covidwpolsce.vm.region

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mczuba.covidwpolsce.data.CountryNews
import com.mczuba.covidwpolsce.data.Region
import com.mczuba.covidwpolsce.data.RegionHistory
import com.mczuba.covidwpolsce.databinding.ItemNewsBinding
import com.mczuba.covidwpolsce.databinding.ItemRegionBinding
import java.text.SimpleDateFormat

class NewsViewHolder(var binding: ItemNewsBinding, val context: Context) : RecyclerView.ViewHolder(binding.root) {
    fun onBind(data: CountryNews) {
        binding.news = data
        binding.info = "${data.author.name}, ${SimpleDateFormat("d MMMM yyy").format(data.timestamp)}"
        binding.executePendingBindings()
    }
}