enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

class Usuario(val nome: String, var pontuacao: Int = 0)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel:Nivel, var conteudos: MutableList<ConteudoEducacional> = mutableListOf()) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
    
    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        for ((index, conteudo) in conteudos.withIndex()) {
            println("${index + 1}. ${conteudo.nome} - Duração: ${conteudo.duracao} horas.")
        }
    }
    
    fun listarInscritos() {
        println("Inscritos na formação $nome:")
        for ((index, inscrito) in inscritos.withIndex()) {
            println("${index + 1}. ${inscrito.nome}")
        }
    }
    
    fun atualizarPontuacao(usuario: Usuario, pontuacao: Int) {
        usuario.pontuacao += pontuacao
    }
    
    fun listarRanking() {
        val ranking = inscritos.sortedByDescending { it.pontuacao }
        println("Ranking da formação $nome:")
        for ((index, aluno) in ranking.withIndex()) {
            println("${index + 1}. ${aluno.nome} - Pontuação: ${aluno.pontuacao}")
        }
    }
}

fun main() {
//     TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
//     TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")

    val usuario1 = Usuario("João")
    val usuario2 = Usuario("Maria")

    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin")
    val conteudo2 = ConteudoEducacional("Desenvolvimento Android", 90)

    val formacaoKotlin = Formacao("Formação Kotlin", Nivel.INTERMEDIARIO, mutableListOf(conteudo1, conteudo2))
    formacaoKotlin.matricular(usuario1)
    formacaoKotlin.matricular(usuario2)

    // atualização de pontuação
    formacaoKotlin.atualizarPontuacao(usuario1, 50)
    formacaoKotlin.atualizarPontuacao(usuario2, 75)

    formacaoKotlin.listarConteudos()
    formacaoKotlin.listarInscritos()
    
    // Listar ranking
    formacaoKotlin.listarRanking()
}