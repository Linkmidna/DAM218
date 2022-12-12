package com.juliofhiguera.examen_julio_f_higuera

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import es.ivanlorenzo.examen2022_11.datos.DatosSelecciones

class GruposAdapter(private val onClickAdapter: (Grupo) -> Unit)
    : RecyclerView.Adapter<GruposAdapter.GrupoViewHolder>()
{
    private val listaGrupos = DatosSelecciones.getGrupos()

    class GrupoViewHolder(view: View,
                          private val onClickHolder: (Int) -> Unit
    ): RecyclerView.ViewHolder(view)
    {
        val textViewNombreGrupo = view.findViewById<TextView>(R.id.tvGrupo)
        val imagenEquipo1 = view.findViewById<ImageView>(R.id.ivEquipo1)
        val imagenEquipo2 = view.findViewById<ImageView>(R.id.ivEquipo2)
        val imagenEquipo3 = view.findViewById<ImageView>(R.id.ivEquipo3)
        val imagenEquipo4 = view.findViewById<ImageView>(R.id.ivEquipo4)

        init {
            view.setOnClickListener { onClickHolder(adapterPosition) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GrupoViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grupo, parent, false)

        return GrupoViewHolder(adapterLayout
        ){ pos -> onClickAdapter(listaGrupos[pos]) }

    }

    override fun onBindViewHolder(holder: GrupoViewHolder, position: Int) {
        val grupo = listaGrupos[position]
        holder.textViewNombreGrupo.text = grupo.nombre
        holder.imagenEquipo1.setImageResource(grupo.equipos[0].imagenBanderaId)
        holder.imagenEquipo2.setImageResource(grupo.equipos[1].imagenBanderaId)
        holder.imagenEquipo3.setImageResource(grupo.equipos[2].imagenBanderaId)
        holder.imagenEquipo4.setImageResource(grupo.equipos[3].imagenBanderaId)
    }

    override fun getItemCount(): Int =listaGrupos.size

}