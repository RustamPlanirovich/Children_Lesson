package com.nauk0a.childrenlesson

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.widget.addTextChangedListener

class MainActivity : AppCompatActivity() {

    var textInEditText = ""

    val positiveButtonClick = { dialog: DialogInterface, which: Int ->
        Toast.makeText(
            applicationContext,
            android.R.string.yes, Toast.LENGTH_SHORT
        ).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edit = findViewById<EditText>(R.id.edit_text)
        val button = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)

        edit.addTextChangedListener { charSequence ->
            textInEditText = charSequence.toString()
        }

        button.setOnClickListener {
            basicAlert(it, "Ответ будет равен: ${2 * 2}")
        }
        button2.setOnClickListener {
            basicAlert(it, "Тебя зовут: $textInEditText")
        }
        button3.setOnClickListener {
            basicAlert(
                it, "Первый человек побывавший в космосе: Юрий Гагарин. " +
                        "полет был совершён 12-го апреля 1961-го года."
            )
        }
        button4.setOnClickListener {
            basicAlert(it, "Ты учишься в: 3В классе")
        }
    }

    fun basicAlert(view: View, text: String) {

        val builder = AlertDialog.Builder(this)

        with(builder)
        {
            setTitle("${textInEditText} - вот мой ответ")
            setMessage("$text")
            setPositiveButton("OK", DialogInterface.OnClickListener(function = positiveButtonClick))
            show()
        }


    }
}