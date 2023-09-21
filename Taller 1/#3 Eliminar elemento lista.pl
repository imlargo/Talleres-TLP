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