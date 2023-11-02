object Taller3Scala{
    def main(args: Array[String]): Unit = {
        /*PUNTO 1*/
        def subconjuntoLetras(lista: List[Char]): Unit = {
            def concatenarPrimero(caracter: Char, resto: List[Char]): List[String] = {
                if (resto.isEmpty) Nil
                else (caracter + resto.head.toString) :: concatenarPrimero(caracter, resto.tail)
            }
            def concatenarLista(lista: List[Char]): List[String] = lista match {
                case Nil => Nil
                case cabeza :: cola if cola.length >= 2 => {
                    val combinaciones = concatenarPrimero(cabeza, cola)
                    val concatenacionResultado: List[String] = cabeza.toString +: (combinaciones :+ lista.mkString)
                    concatenacionResultado ::: concatenarLista(cola)
                    }
                case cabeza :: cola if cola.length < 2 => {
                  val combinaciones = concatenarPrimero(cabeza, cola)
                  cabeza.toString +: combinaciones ::: concatenarLista(cola)
                }
            }
            val resultado = concatenarLista(lista)
            println(resultado.mkString(" "))
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
        val n=100
        val inicio = System.nanoTime()
        val resultadoTriangularSimple = triangularSimple(n)
        val fin = System.nanoTime()
        val duracion = fin - inicio
        println(s"Números triangulares: $resultadoTriangularSimple")
        println(s"Tiempo de ejecución en nanosegundos: $duracion")

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
        val nu = 100
        val start = System.nanoTime()
        val resultadoTriangularTail = triangularTail(nu)
        val end = System.nanoTime()
        val duracionT = end - start
        println(s"Números triangulares con Tail: $resultadoTriangularTail")
        println(s"Tiempo de ejecución en nanosegundos: $duracionT")


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