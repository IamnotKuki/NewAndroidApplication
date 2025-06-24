package ru.example.mynewapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


//класс для начального экрана

class MainActivity : AppCompatActivity() {

    lateinit var vm: MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        vm = ViewModelProvider(this)[MyViewModel::class.java]

        vm.generateUsers()

        vm.users.observe(this){
            findViewById<TextView>(R.id.textView).text = it.toString()
        }
        findViewById<Button>(R.id.button1).setOnClickListener{
            vm.getAll()
        }


        // Ищем кнопку по ID
        val button = findViewById<Button>(R.id.button1)

        // для переключения на экран регистрации
        button.setOnClickListener {
            //val intent = Intent(this, RegActivity::class.java)
            //startActivity(intent)
        }

        val button3 = findViewById<TextView>(R.id.button3)

        // для переключения на экран авторизации
        button3.setOnClickListener {
            val intent = Intent(this, BeAuthorizedActivity::class.java)
            startActivity(intent)
        }


    }

}
