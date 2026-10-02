package estruturadedados.ListaEncadeada

//criar Classe No
//Criar Classe Lista
//Criar Função add
//Criar função printContent
class Lista {

    var head: No? = null

    class No( //Bloco Construtor
        var valor: Int,
        var prox: No?,

    )


    fun add(valor: Int) {
        if (head == null) {
            head = No(valor, null)

        } else { //algoritimo 1: Pecorrer até o final
            var aux = head
            while (aux?.prox != null) { //perrcorrer até o ultimo nó
                aux = aux.prox
            }
            aux?.prox = No(valor, null)

        }

    }

    fun printContent(){
        //[10,20,30] Vai mostrar Assim
        var aux = head
        print("[")

        while (aux != null) {
            print(aux.valor)
            if (aux.prox != null) {

                print(" -> ")
            }
            aux = aux.prox
        }
        println("]")
    }


    fun size():Int{
        var aux = head
        var count = 0

        while (aux != null) {
            count ++
            aux = aux.prox
        }
        return count
    }

    fun remove(index:Int): Boolean{
        if (index < 0 || index > size() -1 )
            return false

        if (index == 0){//algoritimo
            head = head?.prox
            return true
        }

        var aux = head
        for (i in 0 .. index -1){
            aux = aux?.prox
        }
        aux?.prox = aux?.prox?.prox
        return true
    }
    fun get(index: Int): Int? {
        var aux = head

        for (i in 0..index-1)
            aux = aux?.prox

        return aux?.valor
    }

    fun get2(index: Int): Int {
        var aux = head

        for (i in 0..index-1)
            aux = aux?.prox

        if (aux?.valor == null) //lança um erro se índice
            throw Exception("Índice inexistente!")

        return aux.valor
    }

    fun inserir(index: Int, valor: Int): Boolean{
        if (index < 0 || index > size()){
            return false
        }
        if (index == 0){
            var aux = head
            head = No(valor, head)
            return true
        }
        var aux = head
        for (i in 0 ..index-1){
            aux = aux?.prox
        }
        aux?.prox = No(valor, aux?.prox)
        return true

    }

    fun set(index:Int, novoValor:Int): Boolean{
        if (index < 0 || index >= size()){
            return false
        }
        var aux = head
        for (i in 0 ..index-1){
            aux = aux?.prox
        }
        aux?.valor = novoValor
        return true
    }

    fun indexof(valor: Int): Int?{
        var aux = head
        var contador = 0

        while (aux != null) {
            if (aux.valor == valor)
                return contador
            contador++
            aux = aux.prox
        }
        return null

    }

    fun max(): Int? {
        if (head == null)
            return null
          // o que fazer se a lista estiver vazia?

        var maior = head!!.valor // qual valor começa como referência?
        var aux = head

        while (aux != null) {
            if (aux.valor > maior) {  // compara com o que?
                maior = aux.valor         // o que atualiza?
            }
            aux = aux.prox
        }

        return maior  // o que retornar?
    }

}



fun main() {
    val lista = Lista()

    lista.add(10) //0
    lista.add(20) //1
    lista.add(30) //2

    lista.printContent()
    lista.add(75)
    lista.printContent()
    println(lista.max())






}
