package com.example.dz_oop_part1.LibraryItems

import com.example.dz_oop_part1.interfaces.Convertable
import com.example.dz_oop_part1.ItemType
import com.example.dz_oop_part1.LibraryItems.LibraryItem
import com.example.dz_oop_part1.interfaces.ReadableInReadingRoom
import com.example.dz_oop_part1.interfaces.Returnable

// Месяцы выпуска газет
enum class Month(val monthName: String){
    JANUARY("Январь"),
    FEBRUARY("Февраль"),
    MARCH("Март"),
    APRIL("Апрель"),
    MAY("Март"),
    JUNE("Июнь"),
    JULY("Июль"),
    AUGUST("Август"),
    SEPTEMBER("Сентябрь"),
    OCTOBER("Октябрь"),
    NOVEMBER("Ноябрь"),
    DECEMBER("Декабрь")
}

// Класс реализации газет
data class Newspaper(
    override val id: Int,
    override var isAvailable: Boolean,
    override val name: String,
    val paperNumber: Int,
    val month: Month
) : LibraryItem(id, isAvailable, name), ReadableInReadingRoom, Returnable, Convertable {
    override fun getDetailedInfo(): String =
        "выпуск: $paperNumber газеты $name с id: $id, месяц выпуска ${month.monthName} доступен: ${if (isAvailable) "Да" else "Нет"}"

    override fun getType(): ItemType = ItemType.NEWSPAPER
    override fun canReadInReadingRoom(): Boolean = isAvailable
    override fun canReturn(): Boolean = !isAvailable
    override fun canBeConverted(): Boolean = isAvailable

}