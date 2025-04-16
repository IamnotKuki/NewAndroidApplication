package ru.example.mynewapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ProfileFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Находим кнопку button_change
        val buttonChange = view.findViewById<TextView>(R.id.button_change)

        // Устанавливаем обработчик нажатия
        buttonChange.setOnClickListener {
            val profileFragment = parentFragmentManager.findFragmentByTag("PROFILE_FRAGMENT")
            val passwordChangeFragment = parentFragmentManager.findFragmentByTag("PASSWORD_CHANGE_FRAGMENT")

            parentFragmentManager.beginTransaction().apply {
                if (profileFragment != null) {
                    hide(profileFragment) // Скрываем фрагмент профиля
                }
                if (passwordChangeFragment != null) {
                    remove(passwordChangeFragment) // Удаляем существующий фрагмент
                }
                add(R.id.fragment, PasswordChangeFragment.newInstance(), "PASSWORD_CHANGE_FRAGMENT") // Добавляем новый фрагмент
                addToBackStack(null) // Добавляем транзакцию в стек
            }.commit()
        }

    }

    companion object {

    }
}