fun main(args: Array<String>) {
    val masa = Masa(TipoMasa.NORMAL,23.5)
    val margarita = Pizza(masa,"Mozarella", 10.76,"Oregano",3.16)
    margarita.ing_2 = Ingrediente ("Tomate",33.12)
    margarita.ing_1.calorias=21.57
    println(margarita.toString())
}