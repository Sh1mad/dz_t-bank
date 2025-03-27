package com.example.dz_oop_part1

// Реализация менеджера
class Manager<in T : Shop<LibraryItem>> {
    fun buy(shop: T) = shop.sell()
}