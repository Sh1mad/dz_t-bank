package com.example.dz_oop_part1

import com.example.dz_oop_part1.LibraryItems.LibraryItem
import com.example.dz_oop_part1.shops.Shop

// Реализация менеджера
class Manager<in T : Shop<LibraryItem>> {
    fun buy(shop: T) = shop.sell()
}