%Sin tail
invertir(N, X) :-
	invertir_aux(N, Y),
    number_string(X, Y).

invertir(0, 0) :- !.

invertir_aux(0, "") :- !.

invertir_aux(N, X) :-
	Head is N // 10,
	Tail is N mod 10,
	invertir_aux(Head, Temp),
	string_concat(Tail, Temp, X).

%Con tail
invertir_tail(N, X) :-
    invertir_tail(N, "", Y), number_string(X, Y).

invertir_tail(0, 0) :- !.

invertir_tail(0, C, C) :- !.

invertir_tail(N, C, X) :-
    Head is N // 10, Tail is N mod 10,
    string_concat(C, Tail, Temp),
    invertir_tail(Head, Temp, X).
%...........

%Sin azucar sintactico (Obsesion de aleja)
invertir(N,X):-
    invertir_aux(N,ListaInvertida),
    lista_numero(ListaInvertida,X).

invertir_aux(0, []) :- !.
invertir_aux(N, ListaInvertida) :-
    Head is N // 10,
    Tail is N mod 10,
    invertir_aux(Head, TempLista),
    agregar_elemento(Tail, TempLista, ListaInvertida).

% regla para agregar un elemento al principio de una lista
agregar_elemento(Elemento, Lista, [Elemento|Lista]).

%reglas para convertir una lista a un número
lista_numero(Lista, Numero) :-
    lista_numero_aux(Lista, 0, Numero).
lista_numero_aux([], Numero, Numero).
lista_numero_aux([Digito|Resto], Acumulador, Numero) :-
    NuevoAcumulador is Acumulador * 10 + Digito,
    lista_numero_aux(Resto, NuevoAcumulador, Numero).
