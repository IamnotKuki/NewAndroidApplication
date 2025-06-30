package ru.example.mynewapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.textfield.TextInputLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Tab2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Находим RecyclerView и устанавливаем LayoutManager
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val activities = listOf(
            ActivityListItem.DateHeader("Вчера"),
            ActivityListItem.ActivityItem(
                distance = "14.32 км",
                duration = "2 часа 46 минут",
                type = "Серфинг",
                username = "@van_darkholme",
                timeAgo = "14 часов назад",
                startTime = "14:49",
                endTime = "16:31"
            ),
            ActivityListItem.ActivityItem(
                distance = "228 м",
                duration = "14 часов 48 минут",
                type = "Качели",
                username = "@techniquepasha",
                timeAgo = "14 часов назад",
                startTime = "02:48",
                endTime = "16:48"
            ),
            ActivityListItem.ActivityItem(
                distance = "10 км",
                duration = "1 час 10 минут",
                type = "Езда на кадилак",
                username = "@morgen_shtern",
                timeAgo = "14 часов назад",
                startTime = "12:05",
                endTime = "13:05"
            )
        )

        // Инициализация адаптера с обработчиком нажатия
        val adapter = ActivityAdapter(activities) { activityItem ->
            // Обработка нажатия на элемент активности
            val intent = Intent(requireContext(), ActivityDetailActivity::class.java).apply {
                putExtra("type", activityItem.type)
                putExtra("duration", activityItem.duration)
                putExtra("distance", activityItem.distance)
                putExtra("timeAgo", activityItem.timeAgo)
                putExtra("startTime", activityItem.startTime)
                putExtra("username", activityItem.username)
                putExtra("endTime", activityItem.endTime)
                putExtra("HIDE_BUTTONS", true) // Флаг для скрытия кнопок
            }
            startActivity(intent)
        }

        // Устанавливаем адаптер для RecyclerView
        recyclerView.adapter = adapter
    }
}