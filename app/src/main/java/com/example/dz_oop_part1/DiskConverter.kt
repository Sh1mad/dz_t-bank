package com.example.dz_oop_part1

import com.example.dz_oop_part1.LibraryItems.Disk
import com.example.dz_oop_part1.LibraryItems.DiskType
import com.example.dz_oop_part1.LibraryItems.LibraryItem

// Реализация конвертера объекта библиотеки в диск
class DiskConverter<in T: LibraryItem> {
    fun convert(item: T) : Disk {
        val disk: Disk = Disk(item.id, true, item.name, DiskType.CD)
        return disk
    }
}