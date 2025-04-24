package ru.example.mynewapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.item_activity)

        // Получаем данные из Intent
        val type = intent.getStringExtra("type") ?: "Неизвестный тип"
        val duration = intent.getStringExtra("duration") ?: "Неизвестная продолжительность"
        val distance = intent.getStringExtra("distance") ?: "Неизвестное расстояние"
        val timeAgo = intent.getStringExtra("timeAgo") ?: "Неизвестное время"

        // Находим TextView и устанавливаем текст
        val detailTypeTextView: TextView = findViewById(R.id.detailTypeTextView)
        val detailDurationTextView: TextView = findViewById(R.id.detailDurationTextView)
        val detailDistanceTextView: TextView = findViewById(R.id.detailDistanceTextView)
        val detailTimeAgoTextView: TextView = findViewById(R.id.detailTimeAgoTextView)

        detailTypeTextView.text = type
        detailDurationTextView.text = duration
        detailDistanceTextView.text = distance
        detailTimeAgoTextView.text = timeAgo
    }

}