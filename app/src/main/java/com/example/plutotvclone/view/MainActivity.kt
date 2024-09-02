package com.example.plutotvclone.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.plutotvclone.R
import com.example.plutotvclone.view.RV.adapters.ChannelAdapter
import com.example.plutotvclone.viewmodel.ChannelViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: ChannelViewModel by viewModels()
    private lateinit var adapter: ChannelAdapter
    private var recyclerViewState: Parcelable? = null
    @SuppressLint("MissingInflatedId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.home)
        setupRecyclerView()
        applyWindowInsets()
        createMenuButtons()
    }

    private fun applyWindowInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.home)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun createMenuButtons() {
        val buttonNames = listOf("Pluto TV", "Películas", "Series", "Retro", "Novelas", "Reality", "Competencia")
        val menuLinearLayout = findViewById<LinearLayout>(R.id.menuFil)

        for (name in buttonNames) {
            val button = Button(this)
            button.text = name
            button.setTextAppearance(R.style.MenuButtonStyle1)
            menuLinearLayout.addView(button)
        }
    }

    private fun setupRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = ChannelAdapter(emptyList()) { imageResId ->
            viewModel.updateImage(imageResId)
        }
        recyclerView.adapter = adapter

        viewModel.uiState.observe(this) { uiState ->
            recyclerViewState = recyclerView.layoutManager?.onSaveInstanceState()
            if (!uiState.isLoading) {
                adapter.updateChannels(uiState.channels ?: emptyList())
            }
            recyclerView.layoutManager?.onRestoreInstanceState(recyclerViewState)
            uiState.imageResId?.let { imageResId ->
                findViewById<ImageView>(R.id.videoImage).setImageResource(imageResId)
            }
        }
    }


}