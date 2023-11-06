
#Función de orden superior que devuelva todos los números primos desde el 2
# hasta un numero que se entregue como parámetro,
# esta función deberá utilizar filter dentro de su implementación.

def isPrimo(n):
    for d in range(2, int(n ** 0.5) + 1):
        if n % d == 0:
            return False
    return True
    

def primos1(n, isPrimo):
    return filter(isPrimo, list(range(2, n+1)))

#Deberá realizar una función que encuentre los números primos hasta un numero dado
# (básicamente repetir el ejercicio anterior), pero usando el generador Yield en su implementación.

def primos2(n):
    for num in range(2, n + 1):
        if isPrimo(num):
            yield num

#Programar Fibonacci Simple y Fibonacci Recursivo Cola comparando los tiempos de ejecución
# y analizar la ganancia en tiempo.
    
def fib_simple(n):
    if n <= 0:
        return 0
    elif n == 1:
        return 1
    else:
        return fib_simple(n - 1) + fib_simple(n - 2)

def fib_tail(n, a=0, b=1):
    if n == 0:
        return a
    else:
        return fib_tail(n - 1, b, a + b)

import time
n = 2000
tiempo_inicio = time.time()
result = fib_simple(n)
tiempo_fin = time.time()

duration = tiempo_fin-tiempo_inicio
print(f"Tiempo ejecución Fibonacci Cola: {duration} segundos \nCalculo de número en la posición {n}, el cual es: {result}")
