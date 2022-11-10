import java.time.LocalDate

class Disco(override val autor: String, override val titulo: String, override val fecha: LocalDate, val minutos : Int) : Publicacion(){
}