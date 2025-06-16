package ru.example.mynewapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivityItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val typeTextView: TextView = itemView.findViewById(R.id.detailType)
    private val distanceTextView: TextView = itemView.findViewById(R.id.detailDistance)
    private val timeAgoTextView: TextView = itemView.findViewById(R.id.detailTimeAgo)
    private val durationTextView: TextView = itemView.findViewById(R.id.detailDuration)
    private val usernameTextView: TextView = itemView.findViewById(R.id.usernameTextView)

    fun bind(activityItem: ActivityListItem.ActivityItem, onItemClick: (ActivityListItem.ActivityItem) -> Unit) {
        typeTextView.text = activityItem.type
        distanceTextView.text = activityItem.distance ?: "Неизвестное расстояние"
        timeAgoTextView.text = activityItem.timeAgo ?: "Неизвестное время"
        durationTextView.text = activityItem.duration ?: "Неизвестная продолжительность"

        if (activityItem.username != null) {
            usernameTextView.visibility = View.VISIBLE
            usernameTextView.text = activityItem.username
        } else {
            usernameTextView.visibility = View.GONE
        }

        itemView.setOnClickListener { onItemClick(activityItem) }
    }


}