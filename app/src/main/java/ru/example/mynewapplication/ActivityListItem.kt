package ru.example.mynewapplication

sealed class ActivityListItem {
    data class DateHeader(val date: String) : ActivityListItem() // Секция с датой

    data class ActivityItem(
        val type: String, // Тип активности (например, "Бег")
        val duration: String, // Продолжительность (например, "30 минут")
        val distance: String, // Расстояние (например, "5 км")
        val timeAgo: String, // Время добавления записи (например, "2 часа назад")
        val username: String? = null // Никнейм пользователя (только для таба "Пользователи")
    ) : ActivityListItem()
}