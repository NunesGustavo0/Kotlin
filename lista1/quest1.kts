fun main(){
    val nome = "Gustavo Nunes de Oliveira"
    var idade = 19
    
    println("Meu nome é $nome e tenho $idade anos")
    
    idade += 1
    
    println("Agora tenho $idade")
    
    val i = 1
    var verificacao = if (i > 0) "positivo" else if (i < 0) "negativo" else "Zero"
	println(verificacao)
}
