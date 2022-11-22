import java.time.LocalDate

class Libro(override val autor: String, override val titulo: String, override val fecha: LocalDate , val paginas : Int) : Publicacion() {

}