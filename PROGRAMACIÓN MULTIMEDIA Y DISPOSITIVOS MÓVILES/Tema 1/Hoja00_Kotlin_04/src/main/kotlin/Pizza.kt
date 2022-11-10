class Pizza (val masa : Masa, nom_1 : String, cal_1 : Double, nom_2 : String, cal_2 : Double){
    var ing_1 : Ingrediente
    var ing_2 : Ingrediente

    init {
         ing_1 = Ingrediente(nom_1,cal_1)
         ing_2 = Ingrediente(nom_2,cal_2)
    }

    fun getCalorias(): Double = masa.calorias+ing_1.calorias+ing_2.calorias

    override fun toString(): String {
        return ("${masa.toString()}, ${ing_1.toString()}, ${ing_2.toString()}")
    }
}