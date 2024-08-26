package com.example.plutotvclone

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val buttonNames = listOf("Pluto TV", "Películas", "Series", "Retro", "Novelas", "Reality", "Competencia")
        val menuLinearLayout = findViewById<LinearLayout>(R.id.menuFil)

        for (name in buttonNames) {
            val button = Button(this)
            button.text = name
            button.setTextAppearance(R.style.MenuButtonStyle1)
            menuLinearLayout.addView(button)
        }

        val highlightedItems = listOf("Canal 1", "Canal 2")
        val movieItems = listOf("Acción", "Drama", "Comedia","suspenso","Terror","Aventura","Animación")

        val highlightedSection = findViewById<LinearLayout>(R.id.highlightedSection)
        val moviesSection = findViewById<LinearLayout>(R.id.moviesSection)

        for (item in highlightedItems) {
            val view = layoutInflater.inflate(R.layout.item_layout, highlightedSection, false)
            val textView = view.findViewById<TextView>(R.id.textView)
            textView.text = item
            highlightedSection.addView(view)
        }

        for (item in movieItems) {
            val view = layoutInflater.inflate(R.layout.item_layout, moviesSection, false)
            val textView = view.findViewById<TextView>(R.id.textView)
            textView.text = item
            moviesSection.addView(view)
        }




    }
}