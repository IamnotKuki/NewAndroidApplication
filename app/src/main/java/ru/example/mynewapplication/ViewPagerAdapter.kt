package ru.example.mynewapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Tab1Fragment() // Фрагмент для таба "Моя"
            1 -> Tab2Fragment() // Фрагмент для таба "Пользовательский"
            else -> throw IllegalArgumentException("Invalid position")
        }
    }
}