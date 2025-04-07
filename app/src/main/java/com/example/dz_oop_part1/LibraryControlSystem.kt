package com.example.dz_oop_part1

import com.example.dz_oop_part1.LibraryItems.Book
import com.example.dz_oop_part1.LibraryItems.Disk
import com.example.dz_oop_part1.LibraryItems.DiskType
import com.example.dz_oop_part1.LibraryItems.Month
import com.example.dz_oop_part1.LibraryItems.Newspaper

fun main() {
    val library = Library()

    // Создаем объекты для тестирования в одну строку
    val books = listOf(
        Book(
            id = 1,
            name = "Маугли",
            isAvailable = true,
            pageCount = 202,
            author = "Джозеф Киплинг"
        ),
        Book(
            id = 2,
            name = "Война и мир",
            isAvailable = false,
            pageCount = 1225,
            author = "Лев Толстой"
        )
    )
    val newspapers = listOf(
        Newspaper(
            id = 3,
            name = "Сельская жизнь",
            isAvailable = true,
            paperNumber = 794,
            month = Month.AUGUST
        ),
        Newspaper(
            id = 4,
            name = "Правда",
            isAvailable = false,
            paperNumber = 1234,
            month = Month.MAY
        )
    )
    val disks = listOf(
        Disk(id = 5, name = "Дэдпул и Росомаха", isAvailable = true, type = DiskType.DVD),
        Disk(id = 6, name = "Музыкальный альбом", isAvailable = false, type = DiskType.CD)
    )

    // Добавляем все предметы в библиотеку
    library.addItems(books)
    library.addItems(newspapers)
    library.addItems(disks)

    // Главное меню
    var running = true
    while (running) {
        println("\n--- Библиотечная система ---")
        println("1. Показать книги")
        println("2. Показать газеты")
        println("3. Показать диски")
        println("4. Управлять менеджером")
        println("5. Выход")

        print("Выберите действие: ")
        when (readlnOrNull()?.toIntOrNull()) {
            1 -> library.showItems(ItemType.BOOK)
            2 -> library.showItems(ItemType.NEWSPAPER)
            3 -> library.showItems(ItemType.DISK)
            4 -> library.managerControl()
            5 -> running = false
            else -> println("Неверный выбор. Попробуйте снова.")
        }
    }
}

// Все доступные объекты в библиотеке
enum class ItemType{
    BOOK,
    NEWSPAPER,
    DISK
}

// Инлайн функция для получения списка предметов конкретного типа
inline fun <reified T> getSpecialType(collection: List<Any>): List<T>{
    return collection.filterIsInstance<T>()
}