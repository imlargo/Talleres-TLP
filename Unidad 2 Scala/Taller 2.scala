object Test {
    
    // No Cambiar este Método, es el caso de prueba
    def main(args: Array[String]) {
        val Numero = scala.io.StdIn.readInt()
        if (Numero < 8) println(result(Numero)) else result(Numero)
        
    }
    

    val f2 = (a : Float, b : Float, c : Float) => a + b > c
                                    
    def verificarTriangulo(f : (Float, Float, Float) => Boolean, a : Float, b : Float, c : Float) : Boolean = {
        return f(a,b,c) && f(a,c,b) && f(b,c,a)
    }
    
    def reverse(texto : String ) : String = {
        return texto.reverse
    }

    def palindromo(f : (String) => String, texto : String ) : Boolean = {
        return f(texto) == texto
    }
    
    val filtro = (letra : Char) => {
        val vocales = List('a', 'e', 'i', 'o', 'u')
        vocales.contains(letra)
    }
    
    def vocal1( f : (Char) => Boolean, text : String ) : String = {
        return text.filter(f)
    }

    def vocal2( f : (Char) => Boolean, text : String ) : String = {
        return text.map((char) => if (f(char)) char else "").mkString("")
    }
        
    def vocal3( f : (Char) => Boolean, text : String ) : Unit = {
        text.foreach((caracter : Char) => {
            if (f(caracter)) {
                print(caracter)
            }
        })
    }
    
    //añada aqui en comentarios los casos de prueba que utilizo y  que imprime.
    
    //No borrar, esto sirve para que minaslap pueda hacer la evaluacion atumatica
    var result = (x:Int) => x match {
        case 1  => verificarTriangulo(f2,1,3,2)&&verificarTriangulo(f2,8,3,20) 
        case 2  => verificarTriangulo(f2,4,3,2)
        case 4  => palindromo(reverse,"annitalavalatinna") && palindromo(reverse,"allivesasevilla")  && palindromo(reverse,"allisimariaavisayasivaairamisilla")  
        case 7  => palindromo(reverse,"noespalindromo")
        case 8  => print(vocal1(filtro,"hola"))
        case 9  => print(vocal2(filtro,"suanaoria"))
        case 10  => vocal3(filtro,"quevivaeldoctor")
    }
    
}