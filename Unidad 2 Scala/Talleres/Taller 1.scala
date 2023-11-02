object Test {
    //Desarrollar las siguientes funciones anónimas y asignarlas a las constantes

    //(val) siguientes:

    //1 – val mcd (máximo común divisor) de 3 números. 

    //2 – val celsius que convierte grados fahrenheit a celsius a. 

    //3 – val millas que convierte kms en millas.(un kilometro equivale a 0.62137 millas)

    //4 – val area_circulo: devuelve el area de un círculo a partir del radio. (use como valor de pi=3.1416)

    //5 – Crear una funcion anónima para hacer una tasa de cambio (Euros A Pesos Colombianos) Utilizando la siguiente conversion: 1 Euro = 4.384,32 Pesos Colombianos

    //(val).
    
    // No Cambiar este Método, es el caso de prueba
    def main(args: Array[String]) : Unit = {
        val Numero = scala.io.StdIn.readInt()
        println(result(Numero))
    }



    def gcd(a: Float, b: Float): Float = {
            if (b == 0) a
            else gcd(b, a % b)
        }
     
    val mcd1 = (num1: Float, num2: Float, num3: Float) => {    
        val mcd1 = gcd(num1, num2)
        val mcd2 = gcd(mcd1, num3)
    
        mcd2
    }

    val celsius = (f : Float) => (f - 32) / 1.8
    
    val millas = (km : Float ) => km * 0.62137
    
    val area_circulo =  (r : Float) => 3.1416 * (r * r)
    
    val Pesos = (euros : Float) => euros * 4384.32
    
    //No borrar, esto sirve para que minaslap pueda hacer la evaluacion atumatica
    var result = (x:Int) => x match {
        case 1  => List(mcd1(25,50,15),mcd1(5,7,11),mcd1(100,10,50))
        case 4  => List(celsius(0),celsius(32),celsius(100)) 
        case 7  => List(millas(100),millas(666),millas(333))
        case 10 => List(area_circulo(10),area_circulo(100),area_circulo(666))
        case 13 => List(Pesos(1),Pesos(1000),Pesos(666))

    }
    
}