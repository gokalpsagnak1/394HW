package com.example.a394hw

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.a394hw.databinding.ActivityGameDetailBinding



class GameDetailActivity : AppCompatActivity() {
    companion object{
        const val GAME_TITLE = "game_title"
        const val GAME_DEVELOPER = "game_developer"
        const val GAME_DESCRIPTION = "game_description"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityGameDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_game_detail)

        val gameTitle = intent.getStringExtra(GAME_TITLE)
        val gameDeveloper = intent.getStringExtra(GAME_DEVELOPER)
        val gameDescription = intent.getStringExtra(GAME_DESCRIPTION)

        binding.titleView.text = gameTitle
        binding.developerView.text = gameDeveloper
        binding.descriptionView.text = gameDescription

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}