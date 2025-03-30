package com.example.dz_oop_part1

// Реализация системы библиотеки
class Library {
    val items = mutableListOf<LibraryItem>()

    fun addItems(newItems: List<LibraryItem>) {
        items.addAll(newItems)
    }

    private val manager = Manager<Shop<LibraryItem>>()
    private val diskConverter = DiskConverter<LibraryItem>()

    fun showItems(itemType: ItemType) {
        val filteredItems = items.filter { it.getType() == itemType }
        if (filteredItems.isEmpty()) {
            println("В библиотеке нет $itemType.")
            return
        }

        println("\nСписок $itemType:")
        filteredItems.forEachIndexed { index, item ->
            println("${index + 1}. ${item.getShortInfo()}")
        }

        print("Выберите номер элемента (или '0' для возврата): ")
        val choice = readlnOrNull()?.toIntOrNull()
        if (choice == null || choice < 0 || choice > filteredItems.size) {
            println("Неверный выбор.")
            return
        }

        if (choice == 0) return

        val selectedItem = filteredItems[choice - 1]
        showItemMenu(selectedItem)
    }

    private fun showItemMenu(item: LibraryItem){
        while(true) {
            println("\n--- Меню для '${item.name}' ---")
            println("1. Взять домой")
            println("2. Читать в читальном зале")
            println("3. Показать подробную информацию")
            println("4. Вернуть")
            println("5. Оцифровать")
            println("6. Назад к списку")

            print("Выберите действие: ")
            when (readlnOrNull()?.toIntOrNull()) {
                1 -> takeHome(item)
                2 -> readInReadingRoom(item)
                3 -> println("\n${item.getDetailedInfo()}")
                4 -> returnItem(item)
                5 -> convertToDisk(item)
                6 -> return
                else -> println("Неверный выбор.")
            }
        }
    }

    private fun takeHome(item: LibraryItem) {
        if (item is TakeHomeable && item.canTakeHome()) {
            item.isAvailable = false
            println("${item.getType()} ${item.id} взята домой.")
        } else {
            println("Этот объект нельзя взять домой.")
        }
    }

    private fun readInReadingRoom(item: LibraryItem) {
        if (item is ReadableInReadingRoom && item.canReadInReadingRoom()) {
            item.isAvailable = false
            println("${item.getType()} ${item.id} взята в читальный зал.")
        } else {
            println("Этот объект нельзя читать в читальном зале.")
        }
    }

    private fun returnItem(item: LibraryItem) {
        if (item is Returnable && item.canReturn()) {
            item.isAvailable = true
            println("${item.getType()} ${item.id} возвращена.")
        } else {
            println("Этот объект нельзя вернуть.")
        }
    }

    private fun convertToDisk(item: LibraryItem){
        if (item is Convertable) {
            if (item.canBeConverted()) {
                items.add(diskConverter.convert(item))
                println("\nДиск успешно добавлен!")
            } else println("\nОбъект в данный момент недоступен")
        } else println("Объект не может быть оцифрован!")
    }

    // Функция управления менеджером
    fun managerControl(){
        while(true) {
            println("\n--- Выберите магазин ---")
            println("1. Купить в книжном магазине")
            println("2. Купить в магазине газет")
            println("3. Купить в магазине дисков")
            println("4. Назад к списку")

            print("Выберите действие: ")
            when (readlnOrNull()?.toIntOrNull()) {
                1 -> items.add(manager.buy(BookShop()))
                2 -> items.add(manager.buy(NewspaperShop()))
                3 -> items.add(manager.buy(DiskShop()))
                4 -> return
                else -> println("Неверный выбор.")
            }
        }
    }
}