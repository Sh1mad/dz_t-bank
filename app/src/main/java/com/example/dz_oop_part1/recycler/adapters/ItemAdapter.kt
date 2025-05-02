package com.example.dz_oop_part1.recycler.adapters

import android.content.Context
import android.content.SyncContext
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.dz_oop_part1.LibraryItems.LibraryItem
import com.example.dz_oop_part1.databinding.ItemLibraryBinding
import com.example.dz_oop_part1.recycler.holders.ItemViewHolder
import com.example.dz_oop_part1.recycler.utils.LibraryItemDiffUtil

class ItemAdapter (
    private val data: MutableList<LibraryItem>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<ItemViewHolder>() {

    fun setNewData(newData: List<LibraryItem>) {
        val diffUtil = LibraryItemDiffUtil(data, newData)
        DiffUtil.calculateDiff(diffUtil).dispatchUpdatesTo(this)

        data.clear()
        data.addAll(newData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding = ItemLibraryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        
        return ItemViewHolder(binding).apply {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION){
                    onItemClick(position)
                }
            }
        }
    }

//    private fun handlePersonClick(context: Context, position: Int) {
//        if (position != RecyclerView.NO_POSITION) {
//            val item = data[position]
//
//            makeText(context, "Элемент с id ${item.id}", LENGTH_SHORT).show()
//
//            item.isAvailable = !item.isAvailable
//            notifyItemChanged(position)
//        }
//    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size

}