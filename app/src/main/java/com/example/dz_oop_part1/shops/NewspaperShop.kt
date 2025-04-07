package com.example.dz_oop_part1.shops

import com.example.dz_oop_part1.LibraryItems.Month
import com.example.dz_oop_part1.LibraryItems.Newspaper
import com.example.dz_oop_part1.shops.Shop

// Реализация магазина газет
class NewspaperShop(): Shop<Newspaper> {
    private val newspaper: Newspaper = Newspaper(
        id = 17,
        name = "Думай",
        isAvailable = true,
        paperNumber = 56,
        month = Month.MARCH
    );
    override fun sell(): Newspaper {
        return newspaper
    }
}