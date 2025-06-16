package ru.example.mynewapplication

import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.text.style.ForegroundColorSpan
import android.widget.ImageButton
import androidx.core.content.ContextCompat

// класс регистрации

class RegActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reg)

        // Обеспечиваем отступы от системных баров
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // для переключения на главный экран
        val image_button = findViewById<ImageButton>(R.id.imageButton)
        image_button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val textView: TextView = findViewById(R.id.textView3)
        val fullText = getString(R.string.agree)
        val spannableString = SpannableString(fullText)

        val clickableWord = "политикой конфиденциальности"
        val clickableWord2 = "пользовательское соглашение"
        val highlightColor = ContextCompat.getColor(this, R.color.purple_500)

        // Выделяем цветом и делаем кликабельными слова
        setClickableSpan(spannableString, fullText, clickableWord, highlightColor) {
            Toast.makeText(this, "Политика конфиденциальности", Toast.LENGTH_SHORT).show()
        }

        setClickableSpan(spannableString, fullText, clickableWord2, highlightColor) {
            Toast.makeText(this, "Пользовательское соглашение", Toast.LENGTH_SHORT).show()
        }

        textView.text = spannableString
        textView.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun setClickableSpan(spannable: SpannableString, fullText: String, word: String, color: Int, onClick: () -> Unit) {
        val startIndex = fullText.indexOf(word)
        if (startIndex != -1) {
            val endIndex = startIndex + word.length
            spannable.setSpan(object : ClickableSpan() {
                override fun onClick(widget: View) {
                    onClick()
                }
            }, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

            // Выделяем цветом purple_500
            spannable.setSpan(ForegroundColorSpan(color), startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }
    }

}
