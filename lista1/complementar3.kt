import kotlin.collections.mutableListOf
import kotlin.random.Random

data class AlunoCt3(val nMatricula: Int?, val notas: List<Int>?, val frequencia: Int?)

fun notaFinal(notas: List<Int>?): Int{
    var media: Int = 0

    if(notas != null){ media = notas.sum() }
    media = media / 3
    return media
}

fun maiorMenor(alunos: MutableList<AlunoCt3>){
    var maior: Int = 0
    var menor: Int? = null

    alunos.forEach {
        if(it.notas != null){
            for(i in it.notas){
                if(i > maior){
                    maior = i
                }else if(menor == null || i < menor){
                    menor = i
                }
            }
        }
    }
    println("Maior nota da turma: $maior")
    println("Menor nota da turma: $menor")
}

fun mediaNota(alunos: MutableList<AlunoCt3>){
    var media: Int = 0
    var cont: Int = 0

    alunos.forEach {
        it.notas?.let {notas ->
            for(i in notas){
                media += i
                cont++
            }
        }
    }
    media = media / cont
    println("Média da turma: $media")
}

fun alunosReprovados(alunos: MutableList<AlunoCt3>){
    var total: Int = 0

    alunos.forEach {
        if(aprovadoReprovado(it.frequencia, it.notas) == "Reprovado") total++
    }
    println("Total de alunos reprovados: $total")
}

fun reproInfrequencia(alunos: MutableList<AlunoCt3>){
    var reproNota: Int = 0
    var reprofalta: Int = 0
    var porcentagem: Double = 0.0

    alunos.forEach {
        it.frequencia?.let { frequencia ->
            if(frequencia < 40){
                it.notas?.let { notas ->
                    if(notas.sum() < 60){
                        reproNota += 1
                    }else{
                        reprofalta += 1
                    }
                }
            }
        }
    }

    porcentagem = (reprofalta.toDouble() / (reproNota.toDouble() + reprofalta.toDouble())) * 100
    println("$porcentagem % de alunos reprovados por infrequência")
}

fun aprovadoReprovado(frequencia: Int?, notas: List<Int>?): String{
    frequencia?.let { frequencia ->
        notas?.let { notas ->
            if(frequencia >= 40 && notas.sum() >= 60) {
                return "Aprovado"
            }else{
                return "Reprovado"
            }
        }
    }
    return "Valor nulo"
}

fun inserirAlunos(alunos: MutableList<AlunoCt3>){
    repeat(100){
        val matricula: Int? = Random.nextInt(10_000_000, 99_999_999)
        val notas: List<Int>? = List(3){ Random.nextInt(0,101) }
        val frequencia: Int? = Random.nextInt(0, 101)

        alunos.add(AlunoCt3(matricula, notas, frequencia))
    }
}

fun main(){
    val alunos = mutableListOf<AlunoCt3>()

    inserirAlunos(alunos)

    alunos.forEach {
        println("Matricula: ${it.nMatricula}, frequência: ${it.frequencia}, nota final: ${notaFinal(it.notas)}, Aluno ${aprovadoReprovado(it.frequencia, it.notas)}")
    }

    maiorMenor(alunos)
    mediaNota(alunos)
    alunosReprovados(alunos)
    reproInfrequencia(alunos)
}
