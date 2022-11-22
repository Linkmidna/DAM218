package my.demo

fun main(){
    val nombres = arrayOf<String>("Julio","Pedro","Luis")
    var opc = 1

    while (opc != 5){
        println("1. Iniciales")
        println("2. Posicion")
        println("3. Buscar letra")
        println("4. Desplazar")
        println("5. Salir")

        opc = readln().toInt()

        when(opc){
            1 ->  {
                nombres.forEach {print("${it[0]}.") }
                println()
            }
            2 -> {
                println("Introduzca una posición:")
                val pos = readln().toInt()
                if (pos<nombres.size && pos>=0){
                    println(nombres[pos])
                }else{
                    println("La posicion introducida no es correcta.")
                }
            }
            3 -> {
                println("Introduce una letra:")
                val letra = readln()[0].lowercase()
                nombres.filter{it.lowercase().contains(letra)}
                    .forEach{println(it)}
            }
            4 -> {
                val aux = nombres.last()
                for (i in nombres.indices.reversed()){
                    if (i==0) nombres[i]=aux
                    else nombres[i]=nombres[i-1]
                }
            }
            5 -> println("Gracias por utilizar nuestro programa.")
            else -> println("Tienes que introducir un numero correcto.")
        }
    }

}