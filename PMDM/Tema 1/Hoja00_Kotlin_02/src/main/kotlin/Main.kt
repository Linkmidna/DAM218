fun main(args: Array<String>) {
    var car : Char? = '0'
    var num : Int = 0
    do {
        println("Introduce un caracter o un . para terminar")
        car = readLine()?.singleOrNull()
        if (car!='.' && car!=null){
            num+=1
        }
        if (car == null) {
            println("Debes introducir un caracter válido")
        }
    }while (car!='.')
    println("Has introducido $num caracteres.")
}