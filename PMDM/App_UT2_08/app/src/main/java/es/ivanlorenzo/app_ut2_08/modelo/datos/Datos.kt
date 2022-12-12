package es.ivanlorenzo.app_ut2_08.modelo.datos

import es.ivanlorenzo.app_ut2_08.modelo.Categoria
import es.ivanlorenzo.app_ut2_08.modelo.Producto

object Datos {
    private val categorias = listOf<Categoria>(
        Categoria("Fruta",
            listOf<Producto>(
                Producto(1, "Manzanas"),
                Producto(2, "Peras"),
                Producto(3, "Plátanos"),
                Producto(4, "Mandarinas"),
            )
        ),
        Categoria("Legumbres",
            listOf<Producto>(
                Producto(5, "Alubias"),
                Producto(6, "Arroz largo"),
                Producto(7, "Arroz redondo"),
                Producto(8, "Garbanzos"),
                Producto(9, "Lentejas"),
            )
        ),
        Categoria("Carnicería",
            listOf<Producto>(
                Producto(10, "Pollo"),
                Producto(11, "Pavo"),
                Producto(12, "Cerdo"),
                Producto(13, "Conejo"),
                Producto(14, "Cordero"),
                Producto(15, "Ternera"),
            )
        ),
        Categoria("Refrescos",
            listOf<Producto>(
                Producto(16, "Cola"),
                Producto(17, "Naranja"),
                Producto(18, "Limón"),
                Producto(19, "Tónica")
            )
        )
    )


    fun nombresCategorias(): List<String>
    {
        return categorias.map { it.nombre }
    }

    fun getProductosCategoria(nombre: String): List<Producto>
    {
        return categorias.first { it.nombre == nombre }.productos
    }
}