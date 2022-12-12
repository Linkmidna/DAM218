package es.ivanlorenzo.app_ut2_08.modelo

import es.ivanlorenzo.app_ut2_08.R
import java.io.Serializable

data class Producto(val id: Int, val nombre: String,
val imagenId: Int = R.drawable.desconocido): Serializable
