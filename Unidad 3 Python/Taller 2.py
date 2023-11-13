# .................................. #
# Taller 2 Tlp                       #
# Estudiante: Juan Carlos Largo.     #
# .................................. # 

# Cargar datos
import pandas as pd
csv = pd.read_csv(f'/content/NBA_2024_per_game.csv')

# 1. Encontrar el jugador que mas tiempo haya jugado en la temporada.
maxTiempo = csv['MP'].idxmax()
rta1 = csv.loc[maxTiempo]["Player"]
#Resultado: "Shaedon Sharpe"
#................................

#2. Encontrar todos los jugadores que hayan jugado para los Cleveland Cavaliers (CLE) en la posición de Point Guard (PG).
rta2 = csv[(csv['Tm'] == 'CLE') & (csv['Pos'] == 'PG')]
#Resultado: Darius Garland, Craig Porter Jr.
#................................

#3. Encontrar los jugadores que tengan mas de 1 robo por partido y mas de 1 bloqueo por partido usando list comprehension.
# Opcion 1: csv[(csv['STL'] > 1) & (csv['BLK'] > 1)]
jugadores = [jugador for jugador, robos, bloqueos in zip(csv['Player'], csv['STL'], csv['BLK']) if (robos > 1 and bloqueos > 1)]
#Resultado: 'Scottie Barnes', 'Victor Wembanyama', 'Derrick White', 'Luguentz Dort', 'Aaron Gordon', 'Ausar Thompson', 'Herbert Jones', 'Robert Williams'
#................................

# 4. Encontrar cual es el porcentaje de canastas de 3 puntos se hacen en la liga.
rta4 = (csv['3P'].sum() / csv['3PA'].sum()) * 100
#Resultado: 35.37%
#................................

# Encontrar que jugadores estuvieron en 2 equipos o mas en una sola temporada.
equiposJugador[csv.groupby('Player')['Tm'].nunique() >= 2]
#Resultado: KJ Martin, Nicolas Batum, P.J. Tucker, Robert Covington
#.............................