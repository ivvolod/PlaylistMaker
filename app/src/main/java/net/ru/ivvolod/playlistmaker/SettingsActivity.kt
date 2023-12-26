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
            val shareMessage = getString(R.string.shareMessage)
            val titleShareMessage = getString(R.string.titleShareMessage)
            shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            startActivity(Intent.createChooser(shareIntent, titleShareMessage))
        }
        //Реализация кнопки «Написать в поддержку»
        val btnSupport = findViewById<TextView>(R.id.txv_support)
        btnSupport.setOnClickListener {
            val supportIntent = Intent(Intent.ACTION_SENDTO)
            val uriMailSupport = getString(R.string.uriMailSupport)
            val mailTitle = getString(R.string.mailTitle)
            val mailText = getString(R.string.mailText)
            val titleSupport = getString(R.string.titleSupport)
            supportIntent.data = Uri.parse(uriMailSupport)
            supportIntent.putExtra(Intent.EXTRA_SUBJECT, mailTitle)
            supportIntent.putExtra(Intent.EXTRA_TEXT, mailText)
            startActivity(Intent.createChooser(supportIntent, titleSupport))
        }
        //Реализация кнопки «Пользовательское соглашение»
        val btnUserAgreement = findViewById<TextView>(R.id.txv_user_agreement)
        btnUserAgreement.setOnClickListener {
            val uriUserAgreement = getString(R.string.uriUserAgreement)
            val userAgreementIntent = Intent(Intent.ACTION_VIEW, Uri.parse(uriUserAgreement))
            startActivity(userAgreementIntent)
        }

    }
}
