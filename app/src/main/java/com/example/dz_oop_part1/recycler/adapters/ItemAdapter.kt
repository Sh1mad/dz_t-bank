package com.example.dz_oop_part1.recycler.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dz_oop_part1.LibraryItems.LibraryItem
import com.example.dz_oop_part1.databinding.ItemLibraryBinding
import com.example.dz_oop_part1.recycler.holders.ItemViewHolder

class ItemAdapter : RecyclerView.Adapter<ItemViewHolder>() {

    private val data = mutableListOf<LibraryItem>()

    fun setNewData(newData: List<LibraryItem>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemLibraryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

}