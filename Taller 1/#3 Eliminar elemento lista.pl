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

concatenar_lista([], Lista, Lista).   
concatenar_lista([H|T], A, [H|T1]) :- concatenar_lista(T, A, T1).

eliminar(E, L, R):-
    eliminar(E, L, [], R), !.

eliminar(_, [], C, C) :- !.

eliminar(E, [H | T], C, R):-
    H \== E,
    concatenar_lista(C, [H], Y),
    eliminar(E, T, Y, R).

eliminar(E, [H | T], C, R) :-
    H == E,
    eliminar(E, T, C, R).
