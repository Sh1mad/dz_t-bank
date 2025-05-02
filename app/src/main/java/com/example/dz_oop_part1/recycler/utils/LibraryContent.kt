package com.example.dz_oop_part1.recycler.utils

import com.example.dz_oop_part1.LibraryItems.Book
import com.example.dz_oop_part1.LibraryItems.Disk
import com.example.dz_oop_part1.LibraryItems.DiskType
import com.example.dz_oop_part1.LibraryItems.LibraryItem
import com.example.dz_oop_part1.LibraryItems.Month
import com.example.dz_oop_part1.LibraryItems.Newspaper

class LibraryContent {
    private val data = mutableListOf<LibraryItem>()

    fun generateContent(): List<LibraryItem> {
        data.clear()
        data.addAll(
            listOf(
                // Книги
                Book(id = 1, name = "Маугли", isAvailable = true, pageCount = 202, author = "Джозеф Киплинг"),
                Book(id = 2, name = "Война и мир", isAvailable = false, pageCount = 1225, author = "Лев Толстой"),
                Book(id = 7, name = "Преступление и наказание", isAvailable = true, pageCount = 576, author = "Фёдор Достоевский"),
                Book(id = 8, name = "Гарри Поттер и философский камень", isAvailable = true, pageCount = 336, author = "Джоан Роулинг"),
                Book(id = 9, name = "1984", isAvailable = false, pageCount = 328, author = "Джордж Оруэлл"),
                Book(id = 10, name = "Маленький принц", isAvailable = true, pageCount = 96, author = "Антуан де Сент-Экзюпери"),

                // Газеты
                Newspaper(id = 3, name = "Сельская жизнь", isAvailable = true, paperNumber = 794, month = Month.AUGUST),
                Newspaper(id = 4, name = "Правда", isAvailable = false, paperNumber = 1234, month = Month.MAY),
                Newspaper(id = 11, name = "Комсомольская правда", isAvailable = true, paperNumber = 543, month = Month.JANUARY),
                Newspaper(id = 12, name = "The New York Times", isAvailable = false, paperNumber = 987, month = Month.OCTOBER),
                Newspaper(id = 13, name = "The Guardian", isAvailable = true, paperNumber = 654, month = Month.FEBRUARY),

                // Диски
                Disk(id = 5, name = "Дэдпул и Росомаха", isAvailable = true, type = DiskType.DVD),
                Disk(id = 6, name = "Музыкальный альбом", isAvailable = false, type = DiskType.CD),
                Disk(id = 14, name = "Игра престолов (1 сезон)", isAvailable = true, type = DiskType.CD),
                Disk(id = 15, name = "Нирвана - Nevermind", isAvailable = false, type = DiskType.DVD)
            )
        )
        return data
    }

}