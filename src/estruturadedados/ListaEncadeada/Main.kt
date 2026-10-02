package estruturadedados.ListaEncadeada

class No(
    var valor: Int,
    var prox: No? = null
)
class ListaEncadeada {
    private var head: No? = null
    private var tail: No? = null

    // Insere um nó no final da lista
    fun inserirNoFinal(valor: Int) {
        val novoNo = No(valor)

        if (head == null) {
            // Lista vazia
            head = novoNo
            tail = novoNo
        } else {
            tail?.prox = novoNo
            tail = novoNo
        }
    }

    // Insere um nó no início da lista
    fun inserirNoInicio(valor: Int) {
        val novoNo = No(valor)

        if (head == null) {
            head = novoNo
            tail = novoNo
        } else {
            novoNo.prox = head
            head = novoNo
        }
    }

    // Imprime a lista
    fun imprimir() {
        var atual = head
        while (atual != null) {
            print("${atual.valor} ")
            atual = atual.prox

        }

        println()
    }
    fun imprimirQuantidadeElementos(){
        var atual = head
        var quantidadeElementos: Int = 0
        while (atual != null){
            quantidadeElementos++
            atual = atual.prox
        }
        println("A quantidade de elementos atual da lista é $quantidadeElementos")

    }
}
fun main() {
    val lista = ListaEncadeada()
    println("Imprimir quantidade de elementos de uma lista encadeada vazia(sem nenhum nó)")
    lista.imprimirQuantidadeElementos()
    println("Inserir o numero 1 no final da lista e imprimir a lista inteira")
    lista.inserirNoFinal(1)
    lista.imprimir()
    lista.imprimirQuantidadeElementos()
    println("Inserir o numero 2 no final da lista e imprimir a lista inteira")
    lista.inserirNoFinal(2)
    lista.imprimir()
    lista.imprimirQuantidadeElementos()
    println("Inserir o numero 3 no final da lista e imprimir a lista inteira")
    lista.inserirNoFinal(3)
    lista.imprimir()
    lista.imprimirQuantidadeElementos()
    println("Inserir o numero 0 no início da lista e imprimir a lista inteira")
    lista.inserirNoInicio(0)
    lista.imprimir()
    lista.imprimirQuantidadeElementos()
}