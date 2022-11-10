import java.util.TreeSet

class Almacen {
    val articulos = linkedSetOf<Articulo>()

    fun Insertar(articulo: Articulo):Boolean = articulos.add(articulo)

    fun buscar(cod : String): Articulo? {
        return articulos.filter { a -> a.codigo.equals(cod) }.firstOrNull()
    }

    fun pedidos ():List<Articulo>{
        return articulos.filter { a -> a.existencias<5 }.sortedBy { it.existencias }
    }

}