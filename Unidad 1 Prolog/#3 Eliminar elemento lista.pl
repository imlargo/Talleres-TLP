eliminar(E, L, R):-
    eliminar(E, L, [], R), !.

eliminar(_, [], C, C) :- !.

eliminar(E, [H | T], C, R):-
    H \== E,
    append(C, [H], Y),
    eliminar(E, T, Y, R).

eliminar(E, [H | T], C, R) :-
    H == E,
    eliminar(E, T, C, R).


%Sin azucar sintactico
quitar(E, L, N):-
    quitar(E, L, [], N), !.

quitar(_, [], C, C) :- !.

quitar(E, [H | T], C, N):-
    H \== E,
    concatenar_lista(C, [H], Y),
    quitar(E, T, Y, N).

quitar(E, [H | T], C, N) :-
    H == E,
    quitar(E, T, C, N).

concatenar_lista([], Lista, Lista).   
concatenar_lista([H|T], A, [H|T1]) :- concatenar_lista(T, A, T1).


%Sin azucar sintactico
quitar(E, L, N):-
    quitar(E, L, [], N), !.

quitar(_, [], C, C) :- !.

quitar(E, [H | T], C, N):-
    H \== E,
    append(C, [H], Y),
    quitar(E, T, Y, N).

quitar(E, [H | T], C, N) :-
    H == E,
    quitar(E, T, C, N).
