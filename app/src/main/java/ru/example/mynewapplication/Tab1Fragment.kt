package ru.example.mynewapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Tab1Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tab1, container, false)
        return view

    }
/*
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView2: TextView = view.findViewById(R.id.textView2)
        val textView: TextView = view.findViewById(R.id.textView)
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val list = mutableListOf<Item>()

        for (i in 0..20){
            list.add(Item(
                "${i} км",
                "${i} часа ${i+3} минут назад",
                "Сёрфинг ${i}",
                "user_${i}",
                "${i} часов назад"
            ))
        }
        recyclerView.adapter = ActivityAdapter(list)

        // Проверяем, есть ли данные в списке
        if (list.isNotEmpty()) {
            // Если данные есть, показываем RecyclerView и скрываем TextView
            recyclerView.visibility = View.VISIBLE
            textView2.visibility = View.GONE
            textView.visibility = View.GONE

            // Устанавливаем адаптер
            recyclerView.adapter = ActivityAdapter(list)
        } else {
            // Если данных нет, скрываем RecyclerView и показываем TextView
            recyclerView.visibility = View.GONE
            textView2.visibility = View.VISIBLE
            textView.visibility = View.VISIBLE
        }

*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView2: TextView = view.findViewById(R.id.textView2)
        val textView: TextView = view.findViewById(R.id.textView)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Пример данных
        val activities = listOf(
            ActivityListItem.DateHeader("Вчера"),
            ActivityListItem.ActivityItem("14.32 км", "2 часа 46 минут", "Серфинг", "", "14 часов назад", "14:49", "16:31"),

            ActivityListItem.DateHeader("Май 2022 года"),
            ActivityListItem.ActivityItem("1000 м", "60 минут", "Велосипед", "", "29.05.2022", "10:00", "11:00")
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
                putExtra("endTime", activityItem.endTime)
            }
            startActivity(intent)
        }

        // Проверяем, есть ли данные в списке
        if (activities.isNotEmpty()) {
            // Если данные есть, показываем RecyclerView и скрываем TextView
            recyclerView.visibility = View.VISIBLE
            textView2.visibility = View.GONE
            textView.visibility = View.GONE

        } else {
            // Если данных нет, скрываем RecyclerView и показываем TextView
            recyclerView.visibility = View.GONE
            textView2.visibility = View.VISIBLE
            textView.visibility = View.VISIBLE
        }

        recyclerView.adapter = adapter
    }
/*
        // Пример данных
        val activities = mutableListOf<ActivityListItem>()
        activities.add(ActivityListItem.DateHeader("Вчера"))

        // Добавляем несколько активностей для "Вчера"
        activities.add(ActivityListItem.ActivityItem("Бег", "30 минут", "5 км", "21 час назад"))
        activities.add(ActivityListItem.ActivityItem("Плавание", "45 минут", "1.5 км", "15 часов назад"))

        // Добавляем заголовок для "23 апреля"
        activities.add(ActivityListItem.DateHeader("23 апреля"))
        activities.add(ActivityListItem.ActivityItem("Бег", "20 минут", "3 км", "23 апреля"))
        activities.add(ActivityListItem.ActivityItem("Велосипед", "1 час", "15 км", "23 апреля"))

        // Инициализация адаптера
        val adapter = ActivityAdapter(activities) { activityItem ->
            // Обработка нажатия на элемент активности
            val intent = Intent(requireContext(), ActivityDetailActivity::class.java).apply {
                putExtra("type", activityItem.type)
                putExtra("duration", activityItem.duration)
                putExtra("distance", activityItem.distance)
                putExtra("timeAgo", activityItem.timeAgo)
            }
            startActivity(intent)
        }

        recyclerView.adapter = adapter

        // Проверяем, есть ли данные в списке
        if (activities.isNotEmpty()) {
            recyclerView.visibility = View.VISIBLE
            textView2.visibility = View.GONE
            textView.visibility = View.GONE
        } else {
            recyclerView.visibility = View.GONE
            textView2.visibility = View.VISIBLE
            textView.visibility = View.VISIBLE
        }
*/
}