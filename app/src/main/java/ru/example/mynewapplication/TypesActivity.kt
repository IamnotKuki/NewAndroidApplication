package ru.example.mynewapplication

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class TypesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_types)

        val image_button = findViewById<ImageButton>(R.id.imageButton_arrow)
        image_button.setOnClickListener {
            finish()
        }

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        val activityTypes = listOf("Велосипед", "Бег", "Ходьба")
        val adapter = ActivityTypeAdapter(activityTypes)
        recyclerView.adapter = adapter
    }
}