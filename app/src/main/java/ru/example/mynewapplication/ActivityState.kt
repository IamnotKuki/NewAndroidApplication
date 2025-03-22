package ru.example.mynewapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityState : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)

        // Добавляем фрагмент "Активность" при первом запуске
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.fragment, ActiveFragment(), "ACTIVE_FRAGMENT")
            }
        }

        // Устанавливаем слушатель для BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_active -> {
                    showFragment("ACTIVE_FRAGMENT") { ActiveFragment() }
                    true
                }
                R.id.navigation_profile -> {
                    showFragment("PROFILE_FRAGMENT") { ProfileFragment() }
                    true
                }
                else -> false
            }
        }
    }

    // Метод для показа фрагментов
    private fun showFragment(tag: String, fragmentCreator: () -> Fragment) {
        val activeFragment = supportFragmentManager.findFragmentByTag("ACTIVE_FRAGMENT")
        val profileFragment = supportFragmentManager.findFragmentByTag("PROFILE_FRAGMENT")

        supportFragmentManager.commit {
            // Скрываем фрагменты, которые не соответствуют текущему табу
            if (activeFragment != null && tag != "ACTIVE_FRAGMENT") {
                hide(activeFragment)
            }
            if (profileFragment != null && tag != "PROFILE_FRAGMENT") {
                hide(profileFragment)
            }

            // Показываем или создаем новый фрагмент
            val currentFragment = supportFragmentManager.findFragmentByTag(tag)
            if (currentFragment != null) {
                show(currentFragment)
            } else {
                add(R.id.fragment, fragmentCreator(), tag)
            }
        }
    }
}