package ru.example.mynewapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Tab2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab2, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Пример данных
        val usersActivities = listOf(
            ActivityListItem.DateHeader("Вчера"),
            ActivityListItem.ActivityItem("Бег", "30 минут", "5 км", "2 часа назад", "user123"),
            ActivityListItem.ActivityItem("Плавание", "45 минут", "1.5 км", "5 часов назад", "swimmer456"),
            ActivityListItem.DateHeader("11 апреля"),
            ActivityListItem.ActivityItem("Бег", "20 минут", "3 км", "11 апреля", "runner789"),
            ActivityListItem.DateHeader("1 апреля"),
            ActivityListItem.ActivityItem("Велосипед", "1 час", "15 км", "1 апреля", "cyclist101")
        )

        for (item in usersActivities) {
            when (item) {
                is ActivityListItem.DateHeader -> println("DateHeader: ${item.date}")
                is ActivityListItem.ActivityItem -> println(
                    "ActivityItem: ${item.type}, ${item.distance}, ${item.timeAgo}, ${item.username}"
                )
            }
        }

        // Инициализация адаптера
        val adapter = ActivityAdapter(usersActivities) { activityItem ->
            // Обработка нажатия на элемент активности
            // Здесь можно организовать переход на экран детализации
        }

        recyclerView.adapter = adapter
    }
}