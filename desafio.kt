// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val email: String)

data class ConteudoEducacional(
    val nome: String, 
    val duracao: Int = 60 // duração em minutos
) 

data class Formacao(
    val nome: String,
    val nivel: Nivel,
    val conteudos: List<ConteudoEducacional>
) {
    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }
}

fun main() {
    // Criando conteúdos
    val kotlinBasico = ConteudoEducacional("Introdução ao Kotlin", 90)
    val androidStudio = ConteudoEducacional("Android Studio Essentials", 120)
    
    // Criando formação
    val formacaoMobile = Formacao(
    	nome = "Formacao Mobile Kotlin",
    	nivel = Nivel.INTERMEDIARIO,
    	conteudos = listOf(kotlinBasico, androidStudio)
    )
    
    // Criando usuários
    val aluno1 = Usuario("Maria", "maria@email.com")
    val aluno2 = Usuario("Joao", "joao@email.com")
    
    // Matriculando usuários
    formacaoMobile.matricular(aluno1)
    formacaoMobile.matricular(aluno2)
    
    // Exibindo inscritos
    println("Inscritos na formação ${formacaoMobile.nome}:")
    formacaoMobile.inscritos.forEach { println("- ${it.nome}") }
}