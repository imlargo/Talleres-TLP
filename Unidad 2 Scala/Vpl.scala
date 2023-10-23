/*
1 –Dada una lista de n letras distintas,
escribir un programa en Scala usando recursión que enumere todos los subconjuntos de estas letras (sin invertir letras).
No es necesario enumerar el conjunto vacío. Ejm. List('a','b','c') retorna a ab ac abc b bc c
Probar con val lista1 : List[Char] = List('a','b','c','d','e').
*/

/*
2- Se tienen 5 estudiantes sentados de izquierda a derecha: "Juan","Anamaria","Pablo","Sofía","Alejandro“.
Escribir un programa en Scala que haga uso de la recursión mostrando todas las posibles posiciones
en las que se pueden sentar los 5 estudiantes. 
*/

/*3- La secuencia de los números triangulares es la representación de los números en una secuencia
de 1, 3, 6, 10, 15, 21, 28, 36, 45, etc.
Esta secuencia cumple que cada número se obtiene por medio de la suma del número anterior con la posición del número siguiente
y esto generará la secuencia de los números triangulares.

Escriba 2 programas en Scala que muestre los n primeros números triangulares usando recursión simple y tail-recursion
(recursión de cola). 
Ejemplo: Para n = 6, el resultado debe ser: 1, 3, 6, 10, 15, 21. 
Adicionalmente, debe mostrar el tiempo de ejecución para c/u cuando n=100.   
*/

/*
4. Realizar un programa en scala con expresiones regulares, que sea capaz de
separar correctamente entre placas de carros y motos,
en caso de no ser ninguna de las anteriores mostrar un mensaje que lo diga.
*/
object Vpl{
    def main(args: Array[String]): Unit = {
        def subconjuntoLetras(lista: List[Char]): List[String] = {
            /*PUNTO 1*/
            def concatenarPrimero(caracter: Char, resto: List[Char]): List[String] = {
                if (resto.isEmpty) Nil
                else (caracter + resto.head.toString) :: concatenarPrimero(caracter, resto.tail)
                }
            def concatenarLista(lista: List[Char]): List[String] = lista match {
                case Nil => Nil
                case cabeza :: cola => {
                    val combinaciones = concatenarPrimero(cabeza, cola)
                    (cabeza.toString +: combinaciones) ::: concatenarLista(cola)
                    }
                }
            val resultado = concatenarLista(lista)
            println(resultado.mkString(" "))
            resultado
        }
        val lista1 : List[Char] = List('a','b','c','d','e')
        val concatenacion = subconjuntoLetras(lista1)

        /*PUNTO 2*/
        def posiblesPosiciones(estudiantes: List[String]): List[List[String]] = {
            if (estudiantes.isEmpty) {
                List(List())
            } else {
                for {
                    estudiante <- estudiantes
                    resto <- posiblesPosiciones(estudiantes.filterNot(_ == estudiante))
                } yield estudiante :: resto
            }
        }
        val estudiantes= List("Juan", "AnaMaria", "Pablo", "Sofía", "Alejandro")
        val posiciones = posiblesPosiciones(estudiantes)
        for (posicion <- posiciones){
            println(posicion.mkString(", "))
        }

        /*PUNTO 3*/
        //recursion simple
        var listaNumeros = List.empty[Int]
        def triangularSimple(n:Int):String = {
            def calculo(numero: Int):Int = {
                if (numero <= 0)0
                else numero + calculo(numero-1)
            }
            if (n>0){
                triangularSimple(n-1)
                val numeroTriangular = calculo(n)
                listaNumeros = listaNumeros:+numeroTriangular
            }
            listaNumeros.mkString(", ")
        }
        val n=6
        println(triangularSimple(n))

        //recursion de cola
        import scala.annotation.tailrec
        var listNumbers = List.empty[Int]
        def triangularTail(nu:Int):String = {
            @tailrec
            def tailCalculo(number: Int,acumulador: Int = 0):Int={
                if (number <=0)acumulador
                else tailCalculo(number-1,acumulador+number)
            }
            @tailrec
            def aux(nu:Int):Unit={
                if (nu>0){
                    val triangularNumber = tailCalculo(nu)
                    listNumbers = listNumbers :+ triangularNumber
                    aux(nu-1)
                }
            }
            aux(nu)
            listNumbers.reverse.mkString(", ")
        }
        val nu = 6
        println(triangularTail(nu))


        /*PUNTO 4*/
        case class Vehiculo(nombre: String, color: String, placa: String)
        // la lista de vehiculos
        val vehiculos= List(Vehiculo("rayo mceen","rojo con rachos cuchau","XXX123"), Vehiculo("Initial D","Negro con blanco","ABC98A"))

        val carro = "^[A-Z]{3}[0-9]{3}$".r
        val moto = "^[A-Z]{3}[0-9]{2}[A-Z]$".r
          
        def identificarPlaca(vehiculos: List[Vehiculo]):List[String] = {
            vehiculos.map { vehiculo => 
            vehiculo.placa match {
                case carro(_*) => "Es un Carro"
                case moto(_*) => "Es una Moto"
                case _ => "Placa no reconocida"
                }
            }
        }
        val respuesta = identificarPlaca(vehiculos)
        println(respuesta)
    }
}