package ru.example.mynewapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivityAdapter (
    private val items: List<ActivityListItem>,
    private val onItemClick: (ActivityListItem.ActivityItem) -> Unit
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_DATE_HEADER = 0
        private const val VIEW_TYPE_ACTIVITY_ITEM = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ActivityListItem.DateHeader -> VIEW_TYPE_DATE_HEADER
            is ActivityListItem.ActivityItem -> VIEW_TYPE_ACTIVITY_ITEM
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            VIEW_TYPE_DATE_HEADER -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_date, parent, false)
                DateHeaderViewHolder(view)
            }
            VIEW_TYPE_ACTIVITY_ITEM -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_activity, parent, false)
                ActivityItemViewHolder(view)
            }
            else -> throw IllegalArgumentException("Unknown view type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is ActivityListItem.DateHeader -> (holder as DateHeaderViewHolder).bind(item.date)
            is ActivityListItem.ActivityItem -> (holder as ActivityItemViewHolder).bind(item, onItemClick)
        }
    }

    override fun getItemCount(): Int = items.size

    class DateHeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val dateTextView: TextView = itemView.findViewById(R.id.dateTextView)

        fun bind(date: String) {
            dateTextView.text = date
        }
    }

    class ActivityItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val typeTextView: TextView = itemView.findViewById(R.id.detailTypeTextView)
        private val durationTextView: TextView = itemView.findViewById(R.id.detailDurationTextView)

        fun bind(activityItem: ActivityListItem.ActivityItem, onItemClick: (ActivityListItem.ActivityItem) -> Unit) {
            typeTextView.text = activityItem.type
            durationTextView.text = activityItem.duration

            itemView.setOnClickListener { onItemClick(activityItem) }
        }
    }
}