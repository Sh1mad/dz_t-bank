package com.example.dz_oop_part1

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dz_oop_part1.LibraryItems.LibraryItem
import com.example.dz_oop_part1.databinding.ActivityMainBinding
import com.example.dz_oop_part1.databinding.ItemLibraryBinding
import com.example.dz_oop_part1.recycler.adapters.ItemAdapter
import com.example.dz_oop_part1.recycler.utils.LibraryContent

class MainActivity : AppCompatActivity() {

    private val content = LibraryContent()
    private var items = mutableListOf<LibraryItem>()

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        items.clear()
        items.addAll(content.generateContent())

        val adapter = ItemAdapter().apply {
            setNewData(items)
        }

        with(binding.recyclerView){
            layoutManager = LinearLayoutManager(context)
            this.adapter = adapter
        }

    }

}