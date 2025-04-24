package ru.example.mynewapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator

class ActiveFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_active, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<androidx.viewpager2.widget.ViewPager2>(R.id.viewPager)
        val tabLayout = view.findViewById<com.google.android.material.tabs.TabLayout>(R.id.tabLayout)

        // Устанавливаем адаптер для ViewPager2
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter

        // Связываем TabLayout с ViewPager2
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Моя"
                1 -> "Пользователей"
                else -> ""
            }
        }.attach()
    }

}