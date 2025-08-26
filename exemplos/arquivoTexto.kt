import java.io.File

fun main(){
    File("dados.txt").writeText("Olá, mundo!\n")

    File("dados.txt").appendText("Está é a segunda linha!\n")

    val conteudo = File("dados.txt").readText()
    println("Conteudo:\n$conteudo")

    println("Linhas dos arquivos\n")
    File("dados.txt").forEachLine {println(">$it")}

    val linhas = File("dados.txt").readLines()
    println("\nLista de linhas: $linhas")
}
