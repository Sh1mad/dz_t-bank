package com.example.dz_oop_part1

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dz_oop_part1.LibraryItems.LibraryItem
import com.example.dz_oop_part1.databinding.ActivityMainBinding
import com.example.dz_oop_part1.recycler.adapters.ItemAdapter
import com.example.dz_oop_part1.recycler.utils.LibraryContent

class MainActivity : AppCompatActivity() {

    private val content = LibraryContent()
    private var items = mutableListOf<LibraryItem>()
    private val adapter by lazy {
        ItemAdapter(items) {position ->
            handleItemClick(position)
        }
    }

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        items.clear()
        items.addAll(content.generateContent())

        with(binding.recyclerView){
            layoutManager = LinearLayoutManager(context)
            adapter = this@MainActivity.adapter
        }

    }

    private fun handleItemClick(position: Int) {
        if (position in items.indices) {
            val item = items[position]

            Toast.makeText(this, "Элемент с id ${item.id}", Toast.LENGTH_SHORT).show()

            item.isAvailable = !item.isAvailable

            adapter.notifyItemChanged(position)
        }
    }

}