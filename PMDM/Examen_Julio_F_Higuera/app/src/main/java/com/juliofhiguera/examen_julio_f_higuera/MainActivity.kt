package com.juliofhiguera.examen_julio_f_higuera

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import es.ivanlorenzo.examen2022_11.datos.DatosSelecciones

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerViewGrupos: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerViewGrupos = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerViewGrupos.adapter = GruposAdapter(){ grupo -> onClickGrupo(grupo)}
        recyclerViewGrupos.layoutManager = GridLayoutManager(this,2)

        recyclerViewGrupos.addItemDecoration(
            DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL)
        )
    }

    private fun onClickGrupo(grupo: Grupo)
    {
        val intent = Intent(applicationContext, GrupoActivity::class.java)
        intent.putExtra("grupo", grupo.nombre)
        startActivity(intent)
    }
}