package net.ru.ivvolod.playlistmaker

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.view.isVisible

class SearchActivity : AppCompatActivity() {
    //Создание константных переменных для сохранения состояния
    companion object {
        private const val SEARCH_TEXT_KEY = "SEARCH_TEXT_KEY"
        private const val DEFAULT_SEARCH_TEXT = ""
    }
    private var searchText: String = DEFAULT_SEARCH_TEXT
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Добавление тулбара
        val toolbar: Toolbar = findViewById(R.id.SearchToolbar)
        setSupportActionBar(toolbar)

        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val searchEditText = findViewById<EditText>(R.id.editText)
        val clearButton = findViewById<ImageView>(R.id.clearButton)

        // Добавление TextWatcher для отслеживания изменений в EditText
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {
                // Перед изменением текста
            }

            override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {
                // Сохранение значения в переменной
                searchText = charSequence.toString()

                // В процессе изменения текста
                if (charSequence.isNullOrEmpty()) {
                    clearButton.isVisible = false
                } else {
                    clearButton.isVisible = true
                }
            }

            override fun afterTextChanged(editable: Editable?) {
                // Ничего не делаем после изменения текста
            }
        })

        clearButton.setOnClickListener {
            searchEditText.text?.clear()
            clearButton.visibility = View.INVISIBLE
            hideKeyboard()
        }
    }
    //Сохранние состояния
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        // Сохранение значения из EditText в Bundle
        outState.putString(SEARCH_TEXT_KEY, searchText)
    }
    //Восстановление состояния
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        // Восстановление значения из Bundle
        val restoredText = savedInstanceState.getString(SEARCH_TEXT_KEY)

        // Проверка на null
        restoredText?.let {
            searchText = it
            val searchEditText = findViewById<EditText>(R.id.editText)
            // Установка восстановленного текста в EditText
            searchEditText.setText(searchText)
        }
    }

    // Метод для скрытия клавиатуры
    private fun hideKeyboard() {
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}