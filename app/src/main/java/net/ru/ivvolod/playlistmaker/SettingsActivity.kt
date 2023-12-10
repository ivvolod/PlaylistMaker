package net.ru.ivvolod.playlistmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        // Добавление тулбара
        val toolbar: Toolbar = findViewById(R.id.SettingToolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }
        //Реализация кнопки «Поделиться приложением»
        val btnShare = findViewById<TextView>(R.id.txv_share)
        btnShare.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            val shareMessage = "Проверьте курс по Андроид-разработке в Практикуме: https://practicum.yandex.ru/profile/android-developer/"
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(shareIntent, "Поделиться приложением"))
        }
        //Реализация кнопки «Написать в поддержку»
        val btnSupport = findViewById<TextView>(R.id.txv_support)
        btnSupport.setOnClickListener {
            val supportIntent = Intent(Intent.ACTION_SENDTO)
            supportIntent.data = Uri.parse("mailto:ivannikov.vladimir.v@yandex.ru")
            supportIntent.putExtra(Intent.EXTRA_SUBJECT, "Сообщение разработчикам и разработчицам приложения Playlist Maker")
            supportIntent.putExtra(Intent.EXTRA_TEXT, "Спасибо разработчикам и разработчицам за крутое приложение!")
            startActivity(Intent.createChooser(supportIntent, "Написать в поддержку"))
        }
        //Реализация кнопки «Пользовательское соглашение»
        val btnUserAgreement = findViewById<TextView>(R.id.txv_user_agreement)
        btnUserAgreement.setOnClickListener {
            val userAgreementIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://yandex.ru/legal/practicum_offer/"))
            startActivity(userAgreementIntent)
        }

    }
}
