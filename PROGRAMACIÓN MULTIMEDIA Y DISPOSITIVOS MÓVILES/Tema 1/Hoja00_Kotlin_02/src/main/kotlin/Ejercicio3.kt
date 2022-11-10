fun main(args: Array<String>) {
    var sum : Int = 0
    var med : Int = 0

    do {
        println("Introduce un numero positivo para sumarlo o negativo para terminar:")
        var num= readln().toInt()
        if (num>=0){
            sum+=num
            med++
        }
    }while (num>=0)
    println("La media de los números introducidos es: ${sum/med}")
}