conexion(lugar1, lugar2, bus, 100)
    
ruta(Origen, Destino, Ruta, Precio, Total, Trasportes) :-
    ruta(Origen, Destino, [Origen], Ruta, Precio, Total, Trasportes, [], 0, []), 
    !.

ruta(Origen, Destino, CRuta, Ruta, Precio, Total, Transportes, CPrecio, CTotal, CTransportes) :-
    conexion(Origen, Destino, T, P),
    append(CRuta, [Destino], Ruta),
    
    append(CPrecio, [P], Precio),
    Total is CTotal + P,
    append(CTransportes, [T], Transportes),
    !.

ruta(Origen, Destino, CRuta, Ruta, Precio, Total, Trasportes, CPrecio, CTotal, CTransportes) :-
    conexion(Origen, X, T, P),
    
    append(CRuta, [X], C1),
    append(CPrecio, [P], C2),
    append(CTransportes, [T], C3),
    CT is CTotal + P,
    
    ruta(X, Destino, C1, Ruta, Precio, Total, Trasportes, C2, CT, C3).