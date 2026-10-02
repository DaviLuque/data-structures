package estruturadedados

class lista{
    var head: No? = null

    class No(
        var valor: Int,
        var prox: No?
    )

    fun add(valor: Int) {
        if (head == null) {
            head = No(valor, null)
        }else{
            var aux = head
            while (aux?.prox != null) {
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

    fun check(valor: Int): Boolean{
        var aux = head
        while (aux != null) {
            if (aux.valor == valor) {
                return true
            }
            aux = aux.prox
        }
        return false
    }
}

fun main(){
    val Lista = lista()

    Lista.add(10)
    Lista.add(20)
    Lista.add(30)

    println(Lista.check(20))
    println(Lista.check(80))

}