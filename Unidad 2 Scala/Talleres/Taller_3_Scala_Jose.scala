object Vpl3_Scala{
    def main(args: Array[String]): Unit = {
        //Punto (1)
        def letras_sub(l: List[Char]): Unit = {
            def primera_letra (primero: Char, l2: List[Char]): List[String] = {
                if (l2.isEmpty) Nil
                else  (primero + l2.head.toString) :: primera_letra(primero, l2.tail)
            }
            def lista_letras(l3: List[Char]): List[String] = l3 match {
                case Nil => Nil
                case head :: tail if l3.size <= 2 => {
                    val subc_letras = primera_letra(head, tail)
                    head.toString+:subc_letras:::lista_letras(tail)
                }
                case head :: tail if l3.size >= 3 => {
                    val subc_letras = primera_letra(head, tail)
                    head.toString+:(subc_letras:+l3.mkString):::lista_letras(tail)
                }
            }
            val retorno = lista_letras(l)
            println(retorno.mkString(" "))
        }
        val lista1 : List[Char] = List('a','b','c','d','e')
        letras_sub(lista1)

        //Punto (2)
        def combinaciones_posibles(l4: List[String]): List[List[String]] = {
            if (l4.isEmpty) {
                List(List())
            } else {
                for {
                    i <- l4
                    j <- combinaciones_posibles(l4.filterNot(_ == i))
                } yield i :: j
            }
        }
        val l4= List("Juan", "AnaMaria", "Pablo", "Sofía", "Alejandro")
        val resultado = combinaciones_posibles(l4)
        for (i1 <- resultado){
            println(i1.mkString(" , "))
        }

        //Punto (3)
        //Simple
        var l5 = List.empty[Int]
        def numeros_triangulares_simple(n1:Int):String = {
            def ts_aux(n1: Int):Int = {
                if (n1 <= 0)0
                else n1 + ts_aux(n1-1)
            }
            if (n1>0){
                numeros_triangulares_simple(n1-1)
                val num_triangular = ts_aux(n1)
                l5 = l5:+num_triangular
            }
            l5.mkString(", ")
        }
        val n = 100
        val tiempo_de_inicio = System.nanoTime()
        val resultado_simple = numeros_triangulares_simple(n)
        val tiempo_de_fin = System.nanoTime()
        val tiempo_de_ejecucion = tiempo_de_fin - tiempo_de_inicio
        println(resultado_simple)
        println(tiempo_de_ejecucion)

        //Tail
        import scala.annotation.tailrec
        var l6 = List.empty[Int]
        def numeros_triangulares_tail(n2:Int):String = {
            @tailrec
            def tt_aux(num2: Int,acumulador_tail: Int = 0):Int={
                if (num2 <=0)acumulador_tail
                else tt_aux(num2-1,acumulador_tail+num2)
            }
            @tailrec
            def tail_aux(n2:Int):Unit={
                if (n2>0){
                    val num_triangular_tail = tt_aux(n2)
                    l6 = num_triangular_tail +: l6
                    tail_aux(n2-1)
                }
            }
            tail_aux(n2)
            l6.mkString(", ")
        }
        val Tiempo_de_inicio = System.nanoTime()
        val resultado_tail = numeros_triangulares_tail(n)
        val Tiempo_de_fin = System.nanoTime()
        val Tiempo_de_ejecucion = Tiempo_de_fin - Tiempo_de_inicio
        println(resultado_tail)
        println(Tiempo_de_ejecucion)


        //Punto (4)
        case class Vehiculo(nombre: String, color: String, placa: String)
        val moto = "^[A-Z]{3}[0-9]{2}[A-Z]$".r
        val carro = "^[A-Z]{3}[0-9]{3}$".r
        def diferencias_Placas(Vehiculos_lista: List[Vehiculo]):List[String] = {
            Vehiculos_lista.map { Vehiculo => 
            Vehiculo.placa match {
                case moto(_*) => "Es una Moto"
                case carro(_*) => "Es un Carro"
                case _ => "Placa no reconocida"
                }
            }
        }
    }
}