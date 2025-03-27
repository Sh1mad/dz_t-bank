package com.example.dz_oop_part1

// Интерфейс магазина с функцией продажи предмета
interface Shop <out T: LibraryItem> {
    fun sell(): T
}