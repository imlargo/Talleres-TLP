#Taller 1 Python María Alejandra Muñoz G CC.1000557085
import time
# PUNTO 1 
def verificarPrimo(numero):
    for i in range(2, int(numero**0.5)+1):
        if numero % i == 0:
            return False
    return True

def listaPrimosFilter(numero):
    lista = list(range(2,numero+1))
    listPrimos = list(filter(lambda x: verificarPrimo(x) == True, lista))
    print(f"Lista de números primos desde 2 hasta {numero}: \n{listPrimos}")
#Llamar así la función:
#listaPrimosFilter(20)

#PUNTO 2
def listaPrimosYield(numero):
    for i in range(2,numero+1):
        if verificarPrimo(i) == True:
            yield i
#print(list(listaPrimosYield(20)))

#PUNTO 3
def fibonacciSimple(numero):
    if numero <= 0:
        return 0
    elif numero == 1:
        return 1
    else:
        return fibonacciSimple(numero-1)+fibonacciSimple(numero-2)
    
tiempoInicio = time.time()
n = 30
resultado = fibonacciSimple(n)
tiempoFin = time.time()
duracion = tiempoFin-tiempoInicio
print(f"Tiempo ejecución Fibonacci Simple: {duracion} segundos \nCalculo de número en la posición {n}, el cual es: {resultado}")

def fibonacciCola(numero,ac=0,acum=1):
    if numero == 0:
        return ac
    else:
        return fibonacciCola(numero-1,acum,ac+acum)
    
tiempo_inicio = time.time()
result = fibonacciCola(n)
tiempo_fin = time.time()
duration = tiempo_fin-tiempo_inicio
print(f"Tiempo ejecución Fibonacci Cola: {duration} segundos \nCalculo de número en la posición {n}, el cual es: {result}")



