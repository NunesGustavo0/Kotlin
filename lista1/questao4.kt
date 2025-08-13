data class Aluno(val nome: String, val matricula: String, val notas: List<Double>){
    fun calcularMedia(): Double{
        var media: Double = 0.0
        for(i in notas){
            media += i
        }
        media = media / notas.size
        return media
    }
}

class Retangulo(val altura: Double, val largura: Double){
    fun calcularArea(): Double{
        return altura * largura
    }
    fun calcularPerimetro(): Double{
        return 2 * (altura + largura)
    }
    fun verificaRetangulo(): String = if (altura == largura) "Quadrado" else "Retangulo"
}

fun main(){
    val aluno1 = Aluno("Gustavo", "2024004958", listOf(10,7,8) as List<Double>)
    val retangulo1 = Retangulo(22.2, 53.0)

    println(aluno1.calcularMedia())
    println(retangulo1.calcularArea())
    println(retangulo1.calcularPerimetro())
    println(retangulo1.verificaRetangulo())
}
