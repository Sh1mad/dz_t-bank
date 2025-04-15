package com.example.dz_oop_part1.recycler.holders


import com.example.dz_oop_part1.R
import androidx.recyclerview.widget.RecyclerView
import com.example.dz_oop_part1.ItemType
import com.example.dz_oop_part1.LibraryItems.LibraryItem
import com.example.dz_oop_part1.databinding.ItemLibraryBinding

class ItemViewHolder (private val binding: ItemLibraryBinding) : RecyclerView.ViewHolder(binding.root){

    fun bind(item: LibraryItem) = with(binding) {
        bindName(item.name)
        bindId(item.id)
        bindIcon(item.getType())
        bindAvailability(item.isAvailable)
    }

    fun bindId(newId: Int) = with(binding){
        idItem.text = "ID = ${newId.toString()}"
    }

    fun bindIcon(type: ItemType) = with(binding){
        when (type) {
            ItemType.BOOK -> icon.setImageResource(R.drawable.ic_book)
            ItemType.NEWSPAPER -> icon.setImageResource(R.drawable.ic_newspaper)
            ItemType.DISK -> icon.setImageResource(R.drawable.ic_disk)
        }
    }

    fun bindName(newName: String) = with(binding){
        name.text = newName
    }

    fun bindAvailability(isAvailable: Boolean) = with(binding){
        val alpha = if (isAvailable) 1f else 0.3f
        name.alpha = alpha
        idItem.alpha = alpha

        val elevation = if (isAvailable) 10f else 1f
        cardContainer.cardElevation = elevation
    }

}