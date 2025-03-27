package com.example.dz_oop_part1

// Реализация магазина дисков
class DiskShop(): Shop<Disk> {
    private val disk: Disk = Disk(id = 23, name = "Сказки на ночь", isAvailable = true, type = DiskType.DVD);
    override fun sell(): Disk{
        return disk
    }
}