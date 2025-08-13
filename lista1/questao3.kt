fun comprimentoOuZero(comprimento: String?): Int = comprimento?.length ?:0

fun descreveEndereco(rua: String?, numero: Int?, cidade: String?): String{
    val ruaNova = rua ?: "Não informado"
    val numeroNovo = numero ?: "Não informado"
    val cidadeNova = cidade ?: "Não informado"

    return "Rua $ruaNova, N* $numeroNovo, $cidadeNova"
}

fun main(){
    println(comprimentoOuZero(""))
    println(comprimentoOuZero("Gustavo"))

    println(descreveEndereco("Albano melo", 16, "Manaus"))
    println(descreveEndereco(null, 16, "Manaus"))
    println(descreveEndereco("Albano melo", null, "Manaus"))
    println(descreveEndereco("Albano melo", 16, null))
}
