class Libro (val ISBN: String,val titulo : String,val autor : String){
    init{
        if(ISBN.length<13 ) println("Error, no llega a los 13 digitos.")
    }
    fun esEspañol() : Boolean = this.ISBN.substring(3,5).equals("84")

    override fun toString() : String{
        return "${titulo.uppercase()}, ${autor.lowercase().replaceFirst(autor.first(),autor.first().uppercaseChar()) }"
    }

}