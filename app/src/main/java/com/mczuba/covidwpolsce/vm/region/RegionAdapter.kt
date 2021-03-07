package com.mczuba.covidwpolsce.vm.region

import android.content.Context
import android.view.*
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mczuba.covidwpolsce.R
import com.mczuba.covidwpolsce.data.RegionHistory
import com.mczuba.covidwpolsce.databinding.ItemRegionBinding
import com.mczuba.covidwpolsce.vm.RegionsFragmentDirections

class RegionAdapter(var context: Context, val regionHistory: ArrayList<RegionHistory>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemRegionBinding.inflate(layoutInflater, parent, false)
        val holder = RegionViewHolder(itemBinding, context)

        holder.itemView.setOnClickListener { view ->
            val action = RegionsFragmentDirections.actionNavigationRegionsToRegionDetailFragment(holder.binding.region!!.regionId.toString())
            view.findNavController().navigate(action)
        }

        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is RegionViewHolder) {
            holder.onBind(regionHistory[position])
        }
    }

    override fun getItemCount() = regionHistory.count()
}