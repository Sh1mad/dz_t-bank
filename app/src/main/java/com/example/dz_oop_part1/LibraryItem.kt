package com.example.dz_oop_part1

// Базовый абстрактный класс для реализации объектов библиотеки
abstract class LibraryItem(
    open val id: Int,
    open var isAvailable: Boolean,
    open val name: String
) {
    fun getShortInfo(): String = "$name доступна: ${if (isAvailable) "Да" else "Нет"}"
    abstract fun getDetailedInfo(): String
    abstract fun getType(): ItemType
}