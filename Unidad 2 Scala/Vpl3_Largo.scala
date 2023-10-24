/*
1 –Dada una listaTail de num letras distintas,
escribir un programa en Scala usando recursión que enumere todos los subconjuntos de estas letras (sin invertir letras).
No es necesario enumerar el conjunto vacío. Ejm. List('a','b','c') retorna a ab ac abc b bc c
Probar con val lista1 : List[Char] = List('a','b','c','d','e').
*/

/*
2- Se tienen 5 listaEstudiantes sentados de izquierda a derecha: "Juan","Anamaria","Pablo","Sofía","Alejandro“.
Escribir un programa en Scala que haga uso de la recursión mostrando todas las posibles combinacionesEs
en las que se pueden sentar los 5 listaEstudiantes. 
*/

/*3- La secuencia de los números triangulares es la representación de los números en una secuencia
de 1, 3, 6, 10, 15, 21, 28, 36, 45, etc.
Esta secuencia cumple que cada número se obtiene por medio de la suma del número anterior con la posición del número siguiente
y esto generará la secuencia de los números triangulares.

Escriba 2 programas en Scala que muestre los num primeros números triangulares usando recursión simple y tail-recursion
(recursión de tail). 
Ejemplo: Para num = 6, el resultado debe ser: 1, 3, 6, 10, 15, 21. 
Adicionalmente, debe mostrar el tiempo de ejecución para c/u cuando num=100.   
*/

/*
4. Realizar un programa en scala con expresiones regulares, que sea capaz de
separar correctamente entre placas de carros y motos,
en caso de no ser ninguna de las anteriores mostrar un mensaje que lo diga.
*/
object Vpl_3{
    def main(args: Array[String]): Unit = {
        //Ejercicio 1
        def enumeracion_subLetras(listaOriginal: List[Char]): Unit = {
            def combinacionCabeza (cabeza: Char, nuevalista: List[Char]): List[String] = {
                if (nuevalista.isEmpty) Nil
                else  (cabeza + nuevalista.head.toString) :: combinacionCabeza (cabeza, nuevalista.tail)
            }
            def listaResultado(listaTail: List[Char]): List[String] = listaTail match {
                case Nil => Nil
                case head :: tail if listaTail.size >= 3 => {
                    val xs = combinacionCabeza(head, tail)
                    head.toString +: (xs :+ listaTail.mkString) ::: listaResultado(tail)
                    }
                case head :: tail if listaTail.size <= 2 => {
                  val xs = combinacionCabeza(head, tail)
                 head.toString +: xs ::: listaResultado(tail)
                }
            }
            val x = listaResultado(listaOriginal)
            println(x.mkString(" "))
        }
        
        val lista1 : List[Char] = List('a','b','c','d','e')
        val respuesta = enumeracion_subLetras(lista1)

        //Ejercicio 2
        def combinacionesEstudiantes(listaEstudiantes: List[String]): List[List[String]] = {
            if (listaEstudiantes.isEmpty) {
                List(List())
            } else {
                for {
                    x1 <- listaEstudiantes
                    x2 <- combinacionesEstudiantes(listaEstudiantes.filterNot(_ == x1))
                } yield x1 :: x2
            }
        }
        val lista2= List("Juan", "AnaMaria", "Pablo", "Sofía", "Alejandro")
        val combinacionesEst = combinacionesEstudiantes(lista2)
        for (y <- combinacionesEst){
            println(y.mkString(" - "))
        }

        //Ejercicio 3
        //función con recursion simple
        var numerosTriangulares = List.empty[Int]
        def recursionSimpleTriangulares(num:Int):String = {
            def auxTriangularSimple(n1: Int):Int = {
                if (n1 <= 0)0
                else n1 + auxTriangularSimple(n1-1)
            }
            if (num>0){
                recursionSimpleTriangulares(num-1)
                val nTriang = auxTriangularSimple(num)
                numerosTriangulares = numerosTriangulares:+nTriang
            }
            numerosTriangulares.mkString(", ")
        }
        val n = 100
        val TiempoInicial = System.nanoTime()
        val x3 = recursionSimpleTriangulares(n)
        val TiempoFinal = System.nanoTime()
        val TiempoEjecucion = TiempoFinal - TiempoInicial
        println(x3)
        println(TiempoEjecucion)

        //funcion con tail recursion
        import scala.annotation.tailrec
        var numTriangTail = List.empty[Int]
        def recursionTailTriangulares(num1:Int):String = {
            @tailrec
            def auxTail(num2: Int,acc: Int = 0):Int={
                if (num2 <=0)acc
                else auxTail(num2-1,acc+num2)
            }
            @tailrec
            def aux2(num1:Int):Unit={
                if (num1>0){
                    val nTriangTail = auxTail(num1)
                    numTriangTail = nTriangTail +: numTriangTail
                    aux2(num1-1)
                }
            }
            aux2(num1)
            numTriangTail.mkString(", ")
        }
        val tiempoInicial = System.nanoTime()
        val x4 = recursionTailTriangulares(n)
        val tiempoFinal = System.nanoTime()
        val tiempoEjecucion = tiempoFinal - tiempoInicial
        println(x4)
        println(tiempoEjecucion)


        //Ejercicio 4
        case class Vehiculo(nombre: String, color: String, placa: String)
        //expresiones regulares
        val carro = "^[A-Z]{3}[0-9]{3}$".r
        val moto = "^[A-Z]{3}[0-9]{2}[A-Z]$".r
          
        def tipoPlaca(listaVehiculos: List[Vehiculo]):List[String] = {
            listaVehiculos.map { vehiculo => 
            vehiculo.placa match {
                case moto(_*) => "Es una Moto"
                case carro(_*) => "Es un Carro"
                case _ => "Placa no reconocida"
                }
            }
        }
        /*
        agregar lista y ejecutar la funcion tipoPlaca
        println(tipoPlaca(listaVehiculos))
        */
    }
}