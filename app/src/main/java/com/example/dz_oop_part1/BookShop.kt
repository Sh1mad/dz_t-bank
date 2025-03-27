package com.example.dz_oop_part1

// Реализация магазина книг
class BookShop() : Shop<Book> {
    private val book: Book = Book(id = 228, name = "А зори здесь тихие", isAvailable = true, pageCount = 128, author = "Борис васильев");
    override fun sell(): Book{
        return book
    }
}