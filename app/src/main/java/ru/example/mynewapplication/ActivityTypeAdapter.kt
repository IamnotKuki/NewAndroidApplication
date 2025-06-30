package ru.example.mynewapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivityTypeAdapter(private val activityTypes: List<String>) :
    RecyclerView.Adapter<ActivityTypeAdapter.ActivityTypeViewHolder>() {

    class ActivityTypeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button: TextView = itemView.findViewById(R.id.button_velosiped)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityTypeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_activity_type, parent, false)
        return ActivityTypeViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActivityTypeViewHolder, position: Int) {
        holder.button.text = activityTypes[position]
    }

    override fun getItemCount(): Int = activityTypes.size
}