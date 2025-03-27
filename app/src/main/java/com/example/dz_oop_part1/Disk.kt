package com.example.dz_oop_part1

// Доступные типы дисков
enum class DiskType{CD, DVD}

// Класс реализации дисков
data class Disk(
    override val id: Int,
    override var isAvailable: Boolean,
    override val name: String,
    val type: DiskType
) : LibraryItem(id, isAvailable, name), TakeHomeable, Returnable {
    override fun getDetailedInfo(): String =
        "${type} $name доступна: ${if (isAvailable) "Да" else "Нет"}"

    override fun getType(): ItemType = ItemType.DISK
    override fun canTakeHome(): Boolean = isAvailable
    override fun canReturn(): Boolean = !isAvailable

}