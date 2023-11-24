import pandas as pd
import re

dfOlimpicos = pd.read_csv("/content/olimpicos_suramerica.csv")

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
        
        showData(columna, orden, opciones)
    else:
        print("Comando no válido")

def showData(columna, orden, args):
    # Mapear las abreviaturas a nombres de columnas completos
    columna = getCol(columna)
    
    colsAdicionales = [getCol(key) for key in args]
    allCols = ( ["Pais"] + [columna] + colsAdicionales )

    # Limpiar datos pais
    dfOlimpicos["Pais"] = dfOlimpicos["Pais"].apply(lambda pais: getPais(pais))
    print()
    print(" . . . . . . . . . . . . . ")
    print()
    
    print(
        dfOlimpicos[allCols].sort_values(by = columna, ascending=(orden == 'A'))
    )

while True:
    comando = input("> ")
    procesar(comando)
