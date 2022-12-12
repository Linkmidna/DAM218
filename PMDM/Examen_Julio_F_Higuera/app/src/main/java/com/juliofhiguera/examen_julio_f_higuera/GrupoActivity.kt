package com.juliofhiguera.examen_julio_f_higuera

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GrupoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grupo)

        val textViewNombre = findViewById<TextView>(R.id.textView)
        val intent = intent
        val nombre = intent.extras?.getString("grupo")
        textViewNombre.text=nombre
    }
}