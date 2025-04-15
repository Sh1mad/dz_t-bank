package com.example.dz_oop_part1.recycler.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.dz_oop_part1.LibraryItems.LibraryItem

class LibraryItemDiffUtil(
    private val oldList: List<LibraryItem>,
    private val newList: List<LibraryItem>
) : DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}