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

class Tab2Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_tab2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Пример данных
        val activities = listOf(
            ActivityListItem.DateHeader("Вчера"),
            ActivityListItem.ActivityItem("14.32 км", "2 часа 46 минут", "Серфинг", "@van_darkholme", "14 часов назад", "14:49", "16:31"),
            ActivityListItem.ActivityItem("228 м", "14 часов 48 минут", "Качели", "@techniquepasha", "14 часов назад", "02:48", "16:48"),
            ActivityListItem.ActivityItem("10 км", "1 час 10 минут", "Езда на кадилак", "@morgen_shtern", "14 часов назад", "12:05", "13:05")
        )

        // Устанавливаем адаптер
        val adapter = ActivityAdapter(activities)
        recyclerView.adapter = adapter
    }
}