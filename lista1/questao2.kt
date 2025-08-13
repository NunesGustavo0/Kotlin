fun ehPar(numero: Int): Boolean = if((numero % 2) == 0) true else false

fun String.inverter(): String{
    var result: String = ""
    for(i in this.length-1 downTo 0){
        result += this[i]
    }
    return result
}

fun main(){
    println(ehPar(92))
    val palavra = "Gustavo"
    println(palavra.inverter())
}
