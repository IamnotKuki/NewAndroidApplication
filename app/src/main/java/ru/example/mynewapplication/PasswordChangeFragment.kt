package ru.example.mynewapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton

class PasswordChangeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_password_change, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Находим ImageButton
        val imageButton = view.findViewById<ImageButton>(R.id.imageButton)

        // Устанавливаем обработчик нажатия
        imageButton.setOnClickListener {
            // Получаем текущие фрагменты из FragmentManager
            val profileFragment = parentFragmentManager.findFragmentByTag("PROFILE_FRAGMENT")
            val passwordChangeFragment = parentFragmentManager.findFragmentByTag("PASSWORD_CHANGE_FRAGMENT")

            parentFragmentManager.beginTransaction().apply {
                if (passwordChangeFragment != null) {
                    hide(passwordChangeFragment) // Скрываем текущий фрагмент
                }
                if (profileFragment != null) {
                    show(profileFragment) // Показываем фрагмент профиля
                } else {
                    add(R.id.fragment, ProfileFragment(), "PROFILE_FRAGMENT") // Добавляем новый фрагмент
                }
                addToBackStack(null) // Добавляем транзакцию в стек
            }.commit()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = PasswordChangeFragment()
    }
}