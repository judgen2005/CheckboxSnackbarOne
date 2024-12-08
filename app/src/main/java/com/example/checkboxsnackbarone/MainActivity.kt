package com.example.checkboxsnackbarone

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editTextInput)
        val textView = findViewById<TextView>(R.id.textViewOutput)
        val buttonSave = findViewById<Button>(R.id.buttonSave)
        val buttonDelete = findViewById<Button>(R.id.buttonDelete)

        buttonSave.setOnClickListener {
            val inputText = editText.text.toString()
            textView.text = inputText
        }

        buttonDelete.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Вы действительно хотите удалить данные?")
            builder.setPositiveButton("Удалить") { _, _ ->
                textView.text = ""
                Snackbar.make(it, "Данные удалены", Snackbar.LENGTH_SHORT).show()
            }
            builder.setNegativeButton("Отмена", null)
            builder.show()
        }
    }
}