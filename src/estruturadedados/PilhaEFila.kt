package estruturadedados


//Implemente uma função recursiva que, dado um número inteiro N,
//mostre a sequência decrescente de N até 1.

fun contarDecrescente(n: Int){
    if (n == 0) return
    println(n)
    contarDecrescente(n - 1)
}

fun sequenciaCrescente(x: Int, y: Int){
    if (x > y) return //caso base: passou do limite para
    println(x)
    sequenciaCrescente(x + 1,y)
}

fun fatorial(n: Int): Long{
    if (n == 0 || n == 1) return 1
    return n * fatorial(n - 1)
}

fun potenciaSimples(x: Int, n: Int): Long{
    if (n == 0) return 1

    val metade = potenciaSimples(x, n/2)

    return if (n % 2 == 0) {
        metade * metade
    }else{
        x * metade * metade
    }
}

fun parouimpar(n: Int): String{
    val positivo = if (n < 0) -n else n
    if (positivo == 0) return "Par"
    if (positivo == 1) return "Impar"
    return parouimpar(positivo - 2)
}

fun soma(lista: List<Int>): Int{
    if (lista.isEmpty()) return 0
    return lista[0] + soma(lista.drop(1))

}

fun main(){

   // println(fatorial(15))
    //println(potenciaSimples(2,10))
  //  println(potenciaSimples(5,25))
    println(parouimpar(5))
    println(soma(listOf(1,2,6,8,5)))
}
