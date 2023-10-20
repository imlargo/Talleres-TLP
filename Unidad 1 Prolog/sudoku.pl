% HECHOS
num(1). num(2). num(3). num(4).

% REGLAS
unicos(P,Q,R,S) :- 
    num(P), num(Q),num(R), num(S),
    \+ P=Q, \+ P=R, \+ P=S, \+ Q=R, \+ Q=S, \+ R=S.

sudoku(R11,R12,R13,R14,R21,R22,R23,R24,R31,R32,R33,R34,R41,R42,R43,R44) :-
    
    %Columnas unicas
    unicos(R11, R21, R31, R41),
    unicos(R12, R22, R32, R42),
    unicos(R13, R23, R33, R43),
    unicos(R14, R24, R34, R44),
    
    %Filas unicas
    unicos(R11, R12, R13, R14),
    unicos(R21, R22, R23, R24),
    unicos(R31, R32, R33, R34),
    unicos(R41, R42, R43, R44),

    %Cuadrantes 2x2 unicos
    unicos(R11, R12, R21, R22),
    unicos(R31, R32, R41, R42),
    unicos(R13, R14, R23, R24),
    unicos(R33, R34, R43, R44),
    
    R11 + R21 + R31 + R41 =:= 10,
    R12 + R22 + R32 + R42 =:= 10,
    R13 + R23 + R33 + R43 =:= 10,
    R14 + R24 + R34 + R44 =:= 10,
    
    R11 + R12 + R13 + R14 =:= 10,
    R21 + R22 + R23 + R24 =:= 10,
    R31 + R32 + R33 + R34 =:= 10,
    R41 + R42 + R43 + R44 =:= 10.


%Query: sudoku(R11,R12,1,R14,R21,1,R23,2,R31,R32,R33,3,R41,R42,4,R44)
%Soluciones: ...