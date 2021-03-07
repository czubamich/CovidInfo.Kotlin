package com.mczuba.covidwpolsce.vm.region

import android.content.Context
import android.view.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mczuba.covidwpolsce.R
import com.mczuba.covidwpolsce.data.CountryNews
import com.mczuba.covidwpolsce.data.RegionHistory
import com.mczuba.covidwpolsce.databinding.ItemNewsBinding
import com.mczuba.covidwpolsce.databinding.ItemRegionBinding
import com.mczuba.covidwpolsce.vm.RegionsFragmentDirections

class NewsAdapter(var context: Context, val news: ArrayList<CountryNews>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemNewsBinding.inflate(layoutInflater, parent, false)
        val holder = NewsViewHolder(itemBinding, context)

        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is NewsViewHolder) {
            holder.onBind(news[position])
        }
    }

    override fun getItemCount() = news.count()
}