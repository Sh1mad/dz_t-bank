package com.example.dz_oop_part1

// Реализация конвертера объекта библиотеки в диск
class DiskConverter<in T: LibraryItem> {
    fun convert(item: T) : Disk {
        val disk: Disk = Disk(item.id, true, item.name, DiskType.CD)
        return disk
    }
}