import pandas as pd
import re

# Importar el dataset
dfOlimpicos = pd.read_csv("./olimpicos_suramerica.csv")

def getCol(columna):
    keyCols = {
        'V': 'Verano',
        'I': 'Invierno',
        'T': 'Combinados',
        'O': 'Oro',
        'P': 'Plata',
        'B': 'Bronce'
    }
    if len(columna) == 2:
        return keyCols[columna[0]] + columna[1]
    else:
        return keyCols[columna]

def getPais(pais):
    coincidencias = re.search(
        r'\((.*?)\)',
        pais
    )
    if coincidencias:
        return coincidencias.group(1)
    else:
        return pais

def procesar(comando):
    coincidencia = re.match(
        r"-C\s*-([VITOPB][VITOPB]?)\s*-([AD])(?:\s*(.*))?",
        comando
    )

    if coincidencia:
        columna = coincidencia.group(1)
        orden = coincidencia.group(2)
        opciones = list(map(lambda s: s.replace("-", ""), coincidencia.group(3).split(" ")))

        if opciones[0] == "":
          showData(columna, orden, [])
        else:
          showData(columna, orden, opciones)

    else:
        print("Comando no válido")

def showData(columna, orden, args):
    columna = getCol(columna)
    colsAdicionales = [getCol(key) for key in args]
    allCols = ( ["Pais"] + [columna] + colsAdicionales )

    dfOlimpicos["Pais"] = dfOlimpicos["Pais"].apply(lambda pais: getPais(pais))
    print()
    print()

    print(
        dfOlimpicos[allCols].sort_values(by = columna, ascending=(orden == 'A'))
    )
    print()
    print(" . . . . . . . . . . . . . ")

while True:
    comando = input("> ")
    if comando == "exit" or comando == "salir":
      break

    procesar(comando)

"""---

### 2. Usando el dataframe Horror Movies IMDb.csv:
"""

import pandas as pd

# Importar el dataset
df = pd.read_csv("./Horror Movies IMDb.csv")

# Imprimir los primeros 5 datos
print("Imprimir los primeros 5 datos")
print(df.head())

# Encontrar la longitud del dataset
print("Encontrar la longitud del dataset.")
longitud = df.shape[0]

print(f"Longitud del dataset: {longitud}")
# Longitud: 836

# Imprimir los encabezados
print("Imprimir los encabezados: ")
print()

encabezados = df.columns

for encabezado in encabezados:
    print(encabezado)

# Movie Title, Movie Year, Runtime, Genre, Rating, Director, Votes, Gross

# Obtener un sub dataFrame con películas desde 1980 hasta la actualidad
print("Obtener un sub dataFrame con películas desde 1980 hasta la actualidad")

subDf = df[df['Movie Year'] >= 1980]

# Limpiar datos
subDf = subDf.dropna()
subDf['Votes'] = subDf['Votes'].apply(lambda x: int(str(x).replace(",", "")))
subDf['Gross'] = subDf['Gross'].apply(lambda x: float(str(x).replace("$", "").replace("M", "")))

print(subDf)

# Dado el sub dataFrame anterior: encontrar la película más corta, la menos rentable y el promedio de duración
print("Dado el sub dataFrame anterior: encontrar la película más corta, la menos rentable y el promedio de duración ")
print("\n\n")

masCorta = subDf.loc[subDf['Runtime'].idxmin()]
menosRentable = subDf.loc[subDf['Gross'].idxmin()]
duracionPromedio = subDf['Runtime'].mean()

# Imprimir los resultados

print(" - - - > Película más corta:")
print(masCorta) #The Monster Squad
print("\n\n")

print("\n - - - > Película menos rentable:")
print(menosRentable) # Ginger Snaps
print("\n")

print("\n - - - > Promedio de duración de las películas:")
print(duracionPromedio) # 100.72

# Encontrar la desviación estándar de las calificaciones de la película en el sub dataFrame
print("Encontrar la desviación estándar de las calificaciones de la película en el sub dataFrame")

dsv = subDf['Rating'].std()
print(f"Desviación estándar: {dsv}") # 0.904

# Encontrar el promedio de votos agrupados género
print("Encontrar el promedio de votos agrupados por género")
print()

promedios = subDf.groupby('Genre')['Votes'].mean()
print(promedios)

# Encontrar los directores y el número de ocurrencias en el dataset, ordenados descendentemente
print("Encontrar los directores y el número de ocurrencias en el dataset, ordenados descendentemente")

print(df['Director'].value_counts())

# Encontrar la películas mejor calificadas y que pertenezcan incluyan estos 3 géneros (Horror, Mystery, Sci-Fi)
print("Encontrar la películas mejor calificadas y que pertenezcan incluyan estos 3 géneros (Horror, Mystery, Sci-Fi)")

# Alien
# Psycho
# The Shining
# The Thing
# Tumbbad
# The Exorcist
# Diabolique
# Rosemary's Baby
# What Ever Happened to Baby Jane?
# The Cabinet of Dr. Caligari


print("Películas mejor calificadas en los géneros Horror, Mystery y Sci-Fi:")
print()

# (Se hizo teniendo en cuenta a las que pertenezcan a los 3 generos al mismo tiempo)

horror = df['Genre'].str.contains('Horror', case=False, regex=True)
misterio = df['Genre'].str.contains('Mystery', case=False, regex=True)
scifi = df['Genre'].str.contains('Sci-Fi', case=False, regex=True)

print(df[horror & misterio & scifi].sort_values(by='Rating', ascending=False))