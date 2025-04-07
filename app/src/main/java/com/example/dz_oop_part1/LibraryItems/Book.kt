package com.example.dz_oop_part1.LibraryItems

import com.example.dz_oop_part1.interfaces.Convertable
import com.example.dz_oop_part1.ItemType
import com.example.dz_oop_part1.LibraryItems.LibraryItem
import com.example.dz_oop_part1.interfaces.ReadableInReadingRoom
import com.example.dz_oop_part1.interfaces.Returnable
import com.example.dz_oop_part1.interfaces.TakeHomeable

// Класс реализации книг
data class Book(
    override val id: Int,
    override var isAvailable: Boolean,
    override val name: String,
    val pageCount: Int,
    val author: String
) : LibraryItem(id, isAvailable, name), TakeHomeable, ReadableInReadingRoom, Returnable,
    Convertable {
    override fun getDetailedInfo(): String =
        "книга: $name ($pageCount стр.) автора: $author с id: $id доступна: ${if (isAvailable) "Да" else "Нет"}"

    override fun getType(): ItemType = ItemType.BOOK
    override fun canTakeHome(): Boolean = isAvailable
    override fun canReadInReadingRoom(): Boolean = isAvailable
    override fun canReturn(): Boolean = !isAvailable
    override fun canBeConverted(): Boolean = isAvailable
}