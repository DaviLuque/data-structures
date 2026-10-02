package estruturadedados

class Tree {
    private class No(
        var data: Int,
        var left: No? = null,
        var right: No? = null
    )

    private var root: No? = null


    //algoritmo de adição de nós na árvore
    private fun add(rootNo: No?, newNo: No): No {

        if (rootNo == null)
            return newNo

        //algoritmo para percorrer a árvore
        // decidir de para pela esquerda ou pela direia
        if (newNo.data < rootNo.data)
            rootNo.left = add(rootNo.left, newNo)
        if (newNo.data > rootNo.data)
            rootNo.right = add(rootNo.right, newNo)

        return rootNo
    }

    fun add(data: Int) { //5, 3
        val newNo = No(data)
        root = add(root, newNo)
    }


    //    private fun max(rootNo: No?): Int?{
//
//    }
//



    private fun max(rootNo: No?):Int?{
        if (rootNo == null)
            return null

        var atual = rootNo

        while (atual?.right != null)
            atual = atual.right
        return atual?.data
    }

    fun max(): Int?{
        return max (root)
    }

    private fun min(rootNo: No?):Int?{
        if (rootNo == null)
            return null

        var atual = rootNo
        while (atual?.left != null)
            atual = atual.left
        return atual?.data
    }
    fun min(): Int?{
    return min(root)//retorna o menor valor...

    }

    private fun find(rootNo: No? , valor: Int): Int?{
        if (rootNo == null )
            return null

        return when{
            valor == rootNo.data -> rootNo.data
            valor < rootNo.data -> find(rootNo.left, valor)
            else -> find(rootNo.right, valor)
        }


    }

    fun find(valor: Int): Int?{ //busca um valor...
        return find(root, valor)

    }

//    private fun find(rootNo: No?, valor: Int):Int?{
//        if (rootNo == null)
//            return null
//
//        return when{
//            valor > rootNo.data -> rootNo.data
//            valor < rootNo.data -> find(rootNo.left, valor)
//            else -> find(rootNo.right, valor)
//        }
//    }
    private fun countMin(rootNo:No?, valor:Int):Int{
        if (rootNo == null)
            return 0

        return if (rootNo.data < valor){
            1 + countMin(rootNo.left,valor) + countMin(rootNo.right,valor)
        }else{
            countMin(rootNo.left,valor)
        }
    }

    fun countMin(valor: Int): Int{ //conta todos os valores menores que...
        return countMin(root, valor)

    }

    private fun height(rootNo: No?): Int{
        if (rootNo == null)
            return 0

        val esquerda = height(rootNo.left)
        val direita = height(rootNo.right)

        return 1 + maxOf(esquerda, direita)
    }
    fun height(): Int{
        return height(root)
    }

    private fun count(rootNo: No?): Int{
        if (rootNo == null)
            return 0

        return 1 + count(rootNo.left) + count(rootNo.right)
    }
fun count(): Int{
    return count(root)
}

    private fun printPares(rootNo: No?){
        if (rootNo == null)
            return

       if (rootNo.data % 2 == 0 ){
           println(rootNo.data)
       }

           printPares(rootNo.left)
           printPares(rootNo.right)
    }

    fun printPares(){
        return printPares(root)
    }


    private fun printImpares(rootNo: No?){
        if (rootNo == null)
            return

        if (rootNo.data % 2 != 0 ){
            println(rootNo.data)
        }

        printPares(rootNo.left)
        printPares(rootNo.right)
    }

    fun printImpares(){
        return printImpares(root)
    }






    private fun remove(rootNo: No?,valor:Int):No?{
        if (rootNo == null)
            return null
        if (valor < rootNo.data)
            rootNo.left = remove(rootNo.left,valor)
        else if (valor > rootNo.data)
            rootNo.right = remove(rootNo.right,valor)
        else {
            if (rootNo.left == null) return null
            if (rootNo.right == null) return null

            val sucessor = min(rootNo.right)
            rootNo.data = sucessor!!
            rootNo.right = remove(rootNo.right,sucessor)

        }
        return rootNo
    }
    fun remove(valor: Int){
        root = remove(root, valor)
    }

    private fun removemin(rootNo: No?):No? {
        if (rootNo == null)
            return null

        if (rootNo.left == null)
            return rootNo.right

        rootNo.left = removemin(rootNo.left)
        return rootNo
    }

    fun removeMin(){
        root = removemin(root)
    }





//        private fun min(rootNo: No?):Int?{
//            if (rootNo == null)
//                return null
//
//            var atual = rootNo
//            while (atual?.left != null)
//                atual = atual.left
//            return atual?.data
//        }
//        fun min(): Int?{
//            return min(root)//retorna o menor valor...
//
//        }






//
 //   Aqui está a função remove completa integrada ao seu código:
//    private fun remove(rootNo: No?, valor: Int): No? {
//        if (rootNo == null) return null
//
//        if (valor < rootNo.data)
//            rootNo.left = remove(rootNo.left, valor)
//        else if (valor > rootNo.data)
//            rootNo.right = remove(rootNo.right, valor)
//        else {
//             Nó encontrado — 3 casos:
//
//             Caso 1: sem filho esquerdo
//            if (rootNo.left == null) return rootNo.right
//
//             Caso 2: sem filho direito
//            if (rootNo.right == null) return rootNo.left
//
//             Caso 3: dois filhos → acha o menor da subárvore direita
//            var minNo = rootNo.right
//            while (minNo?.left != null)
//                minNo = minNo.left
//
//            rootNo.data = minNo!!.data
//            rootNo.right = remove(rootNo.right, minNo.data)
//        }
//
//        return rootNo
//    }
//
//    fun remove(valor: Int) {
//        root = remove(root, valor)
//    }

    private fun check(rootNo: No?, valor: Int): Boolean {
        if (rootNo == null)
            return false

        return when {
            valor == rootNo.data -> true
            valor < rootNo.data -> check(rootNo.left, valor)
            else -> check(rootNo.right, valor)
        }
    }

    fun check(valor: Int): Boolean {
        return check(root, valor)
    }

    private fun removeAll(rootNo: No?, valor: Int, resultado: BooleanArray): No? {
        if (rootNo == null)
            return null

        rootNo.left = removeAll(rootNo.left, valor, resultado)
        rootNo.right = removeAll(rootNo.right, valor, resultado)

        return if (rootNo.data == valor) {
            resultado[0] = true
            null
        } else rootNo
    }

    fun removeAll(valor: Int): Boolean {
        val resultado = BooleanArray(1) { false }
        root = removeAll(root, valor, resultado)
        return resultado[0]
    }



    //algoritmo de impressão em pré-ordem
    private fun show(rootNo: No?){
        if (rootNo == null)
            return
        print("(")
        print(rootNo.data)
        show(rootNo.left)
        show(rootNo.right)
        print(")")
    }

    fun show(){
        show(root)
        println()
    }

    private fun invertTree(rootNo: No?): No?{
        if (rootNo == null) return null

        val temp = rootNo.left
        rootNo.left = rootNo.right
        rootNo.right = temp


        invertTree(rootNo.right)
        invertTree(rootNo.left)
        return rootNo
    }

    fun invertTree(){
        root = invertTree(root)
    }


}

fun main() {

    val arvore = Tree()


    //Nó Raiz
    arvore.add(10)

    //Nó Nivel 2
    arvore.add(5)
    arvore.add(15)

    //Nó Nivel 3
    arvore.add(3)
    arvore.add(7)
    arvore.add(12)
    arvore.add(18)

    println("Antes:")
    arvore.show()

   arvore.invertTree()
    println("Depois: ")
    arvore.show()
    arvore.remove(7)
    arvore.show()
    arvore.removeMin()
    arvore.show()
    arvore.check(5)
    arvore.show()
    println("${arvore.check(5)} ")  // true
        // false


    arvore.show()
    arvore.removeAll(5)
    arvore.show()


}