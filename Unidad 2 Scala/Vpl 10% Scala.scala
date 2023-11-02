object Main {

  def main(args: Array[String]): Unit = {

    def max_min(lista: List[Int]): List[Int] = {
      max_min_Tail(lista.tail, lista.head, lista.head)
    }

    def max_min_recursion(lista: List[Int], max: Int, min: Int): (Int, Int) = {
      if (lista.isEmpty) {
        (max, min)
      } else {
        val head = lista.head
        val newMax = if (head > max) head else max
        val newMin = if (head < min) head else min
        max_min_recursion(lista.tail, newMax, newMin)
      }
    }

    def mcd(a: Int, b: Int): Int = {
      if (b == 0) return a else mcd(b, a % b)
    }

    def largest(palabras: List[String]): String = {
      return palabras.reduceLeft((palabra1, palabra2) => {
        if (palabra1.length() > palabra2.length()) palabra1 else palabra2
      })
    }

    val dist = (A: (Float, Float), B: (Float, Float)) => {
      val x = A._1 - B._1
      val y = A._2 - B._2
      math.sqrt(math.pow(x, 2) + math.pow(y, 2))
    }

    def minDistancia(
        puntos: List[(Float, Float)],
        dist: ((Float, Float), (Float, Float)) => Float
    ): Float = {
      // Permutar las distancias y hallar el minimo

    }

    def empresa(codigos: List[String]): List[String] = {
      val regexExito = "Exi-[!#$%&/()]{3}".r
      val regexFalabella = "[A-Z]{4}\\d{4}".r
      val regexFlamingo = "FL[AEI]([0-9])(?!\\1{5}){5}".r

      val getEmpresa = (codigo: String) => {
        codigo match {
          case regexExito()     => "Exito"
          case regexFalabella() => "Falabella"
          case regexFlamingo()  => "Flamingo"
          case _ => "Ninguno"
        }
      }

      codigos.map((codigo) => getEmpresa(codigo))
    }
  }
}
