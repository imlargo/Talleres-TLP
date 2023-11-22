
import pandas as pd
import re
import sys

# Cargar el DataFrame desde el archivo CSV
df = pd.read_csv('olimpicos_suramerica.csv')

# Función para procesar los comandos
def procesar_comando(comando):
    # Definir patrón de expresión regular para analizar el comando
    patron = r'-C (-[VOBPTI]+) (-[VOBPTI]+) (-[AD])'
    # Buscar coincidencias en el comando
    coincidencia = re.match(patron, comando)
    
    if coincidencia:
        # Obtener grupos de la coincidencia
        columna_mostrar = coincidencia.group(1)
        columna_orden = coincidencia.group(2)
        orden = coincidencia.group(3)
        
        # Seleccionar las columnas a mostrar
        columnas = [col for col in sys.argv[1:] if re.match(r'-[VOBPTI]+', col)]
        
        # Agregar la columna de abreviatura del país (COL)
        columnas.append('COL')
        
        # Filtrar el DataFrame con las columnas seleccionadas
        df_filtrado = df[columnas]
        
        # Mostrar el DataFrame ordenado según la columna y el orden especificado
        df_ordenado = df_filtrado.sort_values(by=columna_orden, ascending=(orden == '-A'))
        print(df_ordenado.to_string(index=False, na_rep=''))
    else:
        print('Comando inválido. Por favor, siga el formato especificado.')

# Obtener el comando de la línea de comandos
if len(sys.argv) > 1:
    comando = ' '.join(sys.argv[1:])
    procesar_comando(comando)
else:
    print('Por favor, ingrese un comando.')

