
#Escriba un programa que solicite repetidamente al usuario números enteros
#hasta que el usuario ingrese "hecho".
#Una vez que haya ingresado "listo", imprima el mayor y el menor de los números.
#Si el usuario ingresa algo que no sea un número válido,
#tómelo con try/except y envíe un mensaje apropiado e ignore el número.
#Ingrese 7, 2, bob, 10 y 4 y haga coincidir el resultado a continuación.

numero_menor = None
numero_mayor = None

while True:
    entrada_usuario = input()

    if entrada_usuario.lower() == 'hecho':
        break

    try:
        numero = int(entrada_usuario)

        if numero_menor is None or numero < numero_menor:
            numero_menor = numero

        if numero_mayor is None or numero > numero_mayor:
            numero_mayor = numero

    except ValueError:
        print("Invalid input")

if numero_menor is not None and numero_mayor is not None:
    print(f"Maximum is {numero_menor}")
    print(f"Minimum {numero_mayor}")
else:
    print("No se ingresaron números.")





valores = []
finales = []
while True:
    entrada_usuario = input()
    if entrada_usuario.lower() == 'hecho':
        break
    valores.append(entrada_usuario)

for valor in valores:
    try:
        numero = int(valor)
        finales.append(numero)
    except ValueError:
        print("Invalid input")

print(f"Maximum is {max(finales)}")
print(f"Minimum {min(finales)}")