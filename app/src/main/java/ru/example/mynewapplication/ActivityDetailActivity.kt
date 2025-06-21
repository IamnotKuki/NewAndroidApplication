package ru.example.mynewapplication

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ActivityDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_activity)

        val image_button = findViewById<ImageButton>(R.id.imageButton)
        image_button.setOnClickListener {
            finish()
        }

        // Получаем данные из Intent
        val type = intent.getStringExtra("type") ?: "Неизвестный тип"
        val duration = intent.getStringExtra("duration") ?: "Неизвестная продолжительность"
        val distance = intent.getStringExtra("distance") ?: "Неизвестное расстояние"
        val timeAgo = intent.getStringExtra("timeAgo") ?: "Неизвестное время"

        val startTime = intent.getStringExtra("startTime") ?: "Неизвестно"
        val endTime = intent.getStringExtra("endTime") ?: "Неизвестно"


        // Находим TextView и устанавливаем текст
        val detailTypeTextView: TextView = findViewById(R.id.detailType)
        val detailDurationTextView: TextView = findViewById(R.id.detailDuration)
        val detailDistanceTextView: TextView = findViewById(R.id.detailDistance)
        val detailTimeAgoTextView: TextView = findViewById(R.id.detailTimeAgo)

        val detailTimeStartTextView: TextView = findViewById(R.id.detailTimeStart)
        val detailTimeEndTextView: TextView = findViewById(R.id.detailTimeEnd)

        detailTypeTextView.text = type
        detailDurationTextView.text = duration
        detailDistanceTextView.text = distance
        detailTimeAgoTextView.text = timeAgo

        detailTimeStartTextView.text = "$startTime"
        detailTimeEndTextView.text = "$endTime"
    }

}