package es.ivanlorenzo.app_ut2_08.modelo

import es.ivanlorenzo.app_ut2_08.modelo.Producto
import java.io.Serializable

data class Categoria(val nombre: String, val productos: List<Producto>):
        Serializable
