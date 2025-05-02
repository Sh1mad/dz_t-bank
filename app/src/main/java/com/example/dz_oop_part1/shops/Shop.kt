package com.example.dz_oop_part1.shops

import com.example.dz_oop_part1.LibraryItems.LibraryItem

// Интерфейс магазина с функцией продажи предмета
interface Shop <out T: LibraryItem> {
    fun sell(): T
}