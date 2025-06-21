package ru.example.mynewapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.Date

sealed class ActivityListItem {
    data class DateHeader(val date: String) : ActivityListItem() // Заголовок с датой
    data class ActivityItem(
        val distance: String,
        val duration: String,
        val type: String,
        val username: String,
        val timeAgo: String,

        val startTime: String,
        val endTime: String
    ) : ActivityListItem()
}

class ActivityAdapter(
    private val items: List<ActivityListItem>,
    private val onItemClick: ((ActivityListItem.ActivityItem) -> Unit)? = null // Nullable лямбда
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
        private val distanceTextView: TextView = itemView.findViewById(R.id.detailDistance)
        private val durationTextView: TextView = itemView.findViewById(R.id.detailDuration)
        private val typeTextView: TextView = itemView.findViewById(R.id.detailType)
        private val usernameTextView: TextView = itemView.findViewById(R.id.usernameTextView)
        private val timeAgoTextView: TextView = itemView.findViewById(R.id.detailTimeAgo)

        fun bind(activityItem: ActivityListItem.ActivityItem, onItemClick: ((ActivityListItem.ActivityItem) -> Unit)?) {
            distanceTextView.text = activityItem.distance
            durationTextView.text = activityItem.duration
            typeTextView.text = activityItem.type
            timeAgoTextView.text = activityItem.timeAgo

            if (activityItem.username != null) {
                usernameTextView.visibility = View.VISIBLE
                usernameTextView.text = activityItem.username
            } else {
                usernameTextView.visibility = View.GONE
            }

            // Устанавливаем обработчик кликов только если он передан
            if (onItemClick != null) {
                itemView.setOnClickListener { onItemClick(activityItem) }
            } else {
                itemView.setOnClickListener(null) // Убираем обработчик, если он не нужен
            }
        }
    }
}



/*
class ActivityAdapter(
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
        private val distanceTextView: TextView = itemView.findViewById(R.id.detailDistance)
        private val durationTextView: TextView = itemView.findViewById(R.id.detailDuration)
        private val typeTextView: TextView = itemView.findViewById(R.id.detailType)
        private val usernameTextView: TextView = itemView.findViewById(R.id.usernameTextView)
        private val timeAgoTextView: TextView = itemView.findViewById(R.id.detailTimeAgo)

        fun bind(activityItem: ActivityListItem.ActivityItem, onItemClick: (ActivityListItem.ActivityItem) -> Unit) {
            distanceTextView.text = activityItem.distance
            durationTextView.text = activityItem.duration
            typeTextView.text = activityItem.type
            timeAgoTextView.text = activityItem.timeAgo

            if (activityItem.username != null) {
                usernameTextView.visibility = View.VISIBLE
                usernameTextView.text = activityItem.username
            } else {
                usernameTextView.visibility = View.GONE
            }

            itemView.setOnClickListener { onItemClick(activityItem) }
        }
    }
}

*/



/*
data class Item(
    val str1: String,
    val str2: String,
    val str3: String,
    val str4: String,
    val date: Date
)


class ActivityAdapter (private val list: List<Item>) : RecyclerView.Adapter<ActivityAdapter.MyView>() {

    class MyView(private val itemView: View) : RecyclerView.ViewHolder(itemView){
        val str1: TextView = itemView.findViewById(R.id.detailDistance)
        val str2: TextView = itemView.findViewById(R.id.detailDuration)
        val str3: TextView = itemView.findViewById(R.id.detailType)
        val str4: TextView = itemView.findViewById(R.id.usernameTextView)
        val dateTextView: TextView? = itemView.findViewById(R.id.detailTimeAgo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {

        val view = if (viewType == VIEW_TYPE1){
            LayoutInflater.from(parent.context).inflate(R.layout.item_activity, parent, false)
        } else {
            LayoutInflater.from(parent.context).inflate(R.layout.item_activity2, parent, false)
        }

       return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        holder.str1.text = list[position].str1
        holder.str2.text = list[position].str2
        holder.str3.text = list[position].str3
        holder.str4.text = list[position].str4
        holder.dateTextView?.text = list[position].date.toString()
    }

    override fun getItemViewType(position: Int): Int {
        val currentDate = Date(System.currentTimeMillis()) // Текущая дата
        val itemDate = list[position].date // Дата элемента

        // Разница между текущей датой и датой элемента в миллисекундах
        val timeDifference = currentDate.time - itemDate.time

        // Если разница меньше 24 часов (в миллисекундах), возвращаем VIEW_TYPE1
        return if (timeDifference < 24 * 60 * 60 * 1000) {
            VIEW_TYPE1
        } else {
            VIEW_TYPE2
        }
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    companion object{
        const val VIEW_TYPE1 = 101
        const val VIEW_TYPE2 = 102
    }
}*/