package ru.example.mynewapplication

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ActivityState : AppCompatActivity() {

    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var imageButton1: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        imageButton1 = findViewById(R.id.imageButton1) // Инициализация кнопки

        val rv : RecyclerView = findViewById(R.id.rv)
        rv.layoutManager = LinearLayoutManager(text.this)

        val list = mutableListOf<Item>()

        for (i in 0..100){
            list.add(Item(
                "TEXT ${i}",
                "TEXT ${i}",
                "TEXT ${i}",
                "TEXT ${i}"
            ))
        }
        rv.adapter = ActivityAdapter(list)


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
                    imageButton1.visibility = View.VISIBLE // Показываем кнопку

                    // Удаляем PasswordChangeFragment, если он существует
                    val passwordChangeFragment = supportFragmentManager.findFragmentByTag("PASSWORD_CHANGE_FRAGMENT")
                    if (passwordChangeFragment != null) {
                        supportFragmentManager.beginTransaction()
                            .remove(passwordChangeFragment) // Удаляем фрагмент
                            .commit()
                    }
                    true
                }
                R.id.navigation_profile -> {
                    showFragment("PROFILE_FRAGMENT") { ProfileFragment() }
                    imageButton1.visibility = View.GONE // Скрываем кнопку

                    // Удаляем PasswordChangeFragment, если он существует
                    val passwordChangeFragment = supportFragmentManager.findFragmentByTag("PASSWORD_CHANGE_FRAGMENT")
                    if (passwordChangeFragment != null) {
                        supportFragmentManager.beginTransaction()
                            .remove(passwordChangeFragment) // Удаляем фрагмент
                            .commit()
                    }
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