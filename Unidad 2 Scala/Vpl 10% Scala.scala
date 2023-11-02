object Main {

  def main(args: Array[String]): Unit = {

    def max_min(lista : List[Int]) : List[Int] = {
    }

    def mcd(a : Int, b : Int) : Int = {
        if (b == 0) return a else mcd(b, a % b)
    }

    def largest(palabras : List[String]) : String = {
      return palabras.reduceLeft((palabra1, palabra2) => {
        if (palabra1.length() > palabra2.length()) palabra1 else palabra2
      })
    }

    def minDistancia(puntos : List[(Int, Int)], dist : ((Int, Int), (Int, Int)) => Float) : Float = {
    }

    def empresa(codigo : String) : String = {
        val regex = ""
    }

  }
}
