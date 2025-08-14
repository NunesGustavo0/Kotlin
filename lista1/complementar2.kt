data class Candidato(val nInscricao: String?, val idade: Int?, val sexo: String?, val expServico: Boolean?){}

fun calcularSexo(candidatos: MutableList<Candidato>, aux: Int): Any{
    var cont: Int = 0
    if(aux == 0){
        candidatos.forEach {
            if(it.sexo == "F") cont++
        }
    }else if(aux == 1){
        candidatos.forEach {
            if(it.sexo == "M") cont++
        }
    }else{
        return "Valor inválido"
    }

    return cont
}

fun mediaIdade(candidatos: MutableList<Candidato>): Int{
    var media: Int = 0
    var cont: Int = 0

    candidatos.forEach {
        if (it.expServico == true && it.idade != null && it.sexo == "M") {
            media += it.idade
            cont++
        }
    }

    media = media / cont
    return media
}

fun porcentagemHomens(candidatos: MutableList<Candidato>): Double{
    var percento: Double = 0.0
    var cont1: Int = 0
    var cont2: Int = 0

    candidatos.forEach {
        if (it.sexo == "M") {
            cont1++

            if (it.idade != null && it.idade > 45) {
                cont2++
            }
        }
    }

    percento = (cont2.toDouble() / cont1.toDouble()) * 100
    return percento
}

fun contMulheres(candidatos: MutableList<Candidato>): Int{
    var cont: Int = 0

    candidatos.forEach {
        if(it.idade != null && it.idade < 35 && it.sexo == "F"){
            if(it.expServico == true){
                cont++
            }
        }
    }
    return cont
}

fun menorIdadeMulher(candidatos: MutableList<Candidato>): Int?{
    var menorIdade: Int? = null

    candidatos.forEach {
        if (it.sexo == "F" && it.expServico == true && it.idade != null) {
            if (menorIdade == null || it.idade < menorIdade) {
                menorIdade = it.idade
            }
        }
    }

    return menorIdade
}

fun inscricaoMulheres(candidatos: MutableList<Candidato>): MutableList<String?> {
    val inscricoes = mutableListOf<String?>()
    candidatos.forEach {
        if (it.sexo == "F" && it.idade != null && it.idade < 35 && it.expServico == true) {
            inscricoes.add(it.nInscricao)
        }
    }
    return inscricoes
}

fun main() {
    var decisao: Int = 0
    val candidatos = mutableListOf<Candidato>()

    repeat(20){
        val inscricao: String?
    }

    candidatos.add(Candidato("454512", 41, "M", true))
    candidatos.add(Candidato("665720", 19, "F", false))
    candidatos.add(Candidato("235858", 50, "M", true))
    candidatos.add(Candidato("458636", 9, "F", false))
    candidatos.add(Candidato("635241", 13, "M", false))
    candidatos.add(Candidato("188471", 23, "F", true))
    candidatos.add(Candidato("569887", 19, "M", false))
    candidatos.add(Candidato("258208", 14, "F", true))

    println("Calculos: ")
    println("a) ${calcularSexo(candidatos, 0)} candidatos do sexo femininos")
    println("b) ${calcularSexo(candidatos, 1)} candidatos do sexo masculino")
    println("c) Média de idades: ${mediaIdade(candidatos)}")
    println("d) Porcentagem dos homens com mais de 45 anos entre o total de homens: ${porcentagemHomens(candidatos)}")
    println("e) Mulheres com menos de 35 anos e com experiência no serviço: ${contMulheres(candidatos)}")
    println("f) Menor idade entre mulheres que já têm experiência no serviço: ${menorIdadeMulher(candidatos)}")
    println("O número de inscrição das mulheres com menos de 35 anos e com experiência no serviço: ${inscricaoMulheres(candidatos)}")

}
