%Conexiones entre ciudades
conexion(bogota, cartagena, avion, 320000).
conexion(bogota, cartagena, bus, 250000).
conexion(medellin, cartagena, avion, 250000).
conexion(medellin, cartagena, bus, 160000).
conexion(bogota, medellin, avion, 160000).
conexion(bogota, medellin, bus, 120000).
conexion(cartagena, panama, crucero, 300000).
conexion(medellin, valledupar, avion, 450000).
conexion(medellin, valledupar, bus, 130000).
conexion(valledupar, cartagena, avion, 350000).
conexion(valledupar, cartagena, bus, 125000).
conexion(cartagena, baru, ferri, 80000).
conexion(medellin, barrancabermeja, bus, 80000).
conexion(barrancabermeja, codazzi, bus, 60000).
conexion(valledupar, codazzi, bus, 16000).
conexion(valledupar, codazzi, burra, 5000).
conexion(bogota, leticia, avion, 160000).
conexion(bogota, panama, avion, 450000).

%Reglas
enrutar(Origen, Destino, Ruta, Precio, Total, Trasportes) :-
    enrutar(Origen, Destino, [Origen], Ruta, Precio, Total, Trasportes, [], 0, []).

enrutar(Origen, Destino, CRuta, Ruta, Precio, Total, Transportes, CPrecio, CTotal, CTransportes) :-
    conexion(Origen, Destino, T, P),
    append(CRuta, [Destino], Ruta),
    
    append(CPrecio, [P], Precio),
    Total is CTotal + P,
    append(CTransportes, [T], Transportes).

enrutar(Origen, Destino, CRuta, Ruta, Precio, Total, Trasportes, CPrecio, CTotal, CTransportes) :-
    conexion(Origen, X, T, P),
    
    append(CRuta, [X], C1),
    append(CPrecio, [P], C2),
    append(CTransportes, [T], C3),
    CT is CTotal + P,
    
    enrutar(X, Destino, C1, Ruta, Precio, Total, Trasportes, C2, CT, C3).