package net.ru.ivvolod.playlistmaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Обработчик для кнопки "Поиск"
        val btnSearch = findViewById<Button>(R.id.btn_search)
        btnSearch.setOnClickListener {
            val searchIntent = Intent(this, SearchActivity::class.java)
            startActivity(searchIntent)
        }

        // Обработчик для кнопки "Плейлист"
        val btnPlaylist = findViewById<Button>(R.id.btn_playlist)
        btnPlaylist.setOnClickListener {
            val playlistIntent = Intent(this, LibraryActivity::class.java)
            startActivity(playlistIntent)
        }

        // Обработчик для кнопки "Настройки"
        val btnSettings = findViewById<Button>(R.id.btn_settings)
        btnSettings.setOnClickListener {
            val settingIntent = Intent(this, SettingsActivity::class.java)
            startActivity(settingIntent)
        }

    }
}