%Sin tail
invertir(0, "") :- !.
     
invertir(N, X) :-
    Head is N // 10,
	Tail is N mod 10,
    invertir(Head, Temp),
    string_concat(Tail, Temp, Y),
    number_string(X, Y).


%primera manera?
invertir_tail(N, X) :-
    invertir_tail(N, "", Y),
    number_string(X, Y).

invertir_tail(0, C, C) :- !.

invertir_tail(N, C, X) :-
    Head is N // 10,
	Tail is N mod 10,
    number_string(Tail, L),
	string_concat(C, L, Final),
  	invertir_tail(Head, Final, X).


%segunda manera?
invertir_tail(0, C, C) :- !.

invertir_tail(N, R) :-
    invertir_tail(N, 0, R).

invertir_tail(N, C, R) :-
    N > 0,
    Digito is N mod 10,
    C2 is C * 10 + Digito,
    NuevoNumero is N // 10,
    invertir_tail(NuevoNumero, C2, R).


%Con tail
invertir(N, X) :-
    Head is N // 10,
	Tail is N mod 10,
    invertir(Head, Temp),
    string_concat(Tail, Temp, X).

%Sin azucar sintactico
invertir(N,X):-
    invertir_aux(N,ListaInvertida),
    lista_a_numero(ListaInvertida,X).

invertir_aux(0, []) :- !.
invertir_aux(N, ListaInvertida) :-
    Head is N // 10,
    Tail is N mod 10,
    invertir_aux(Head, TempLista),
    agregar_elemento(Tail, TempLista, ListaInvertida).

% Agregar un elemento al principio de la lista
agregar_elemento(Elemento, Lista, [Elemento|Lista]).

% Predicado para convertir una lista de dígitos en un número
lista_a_numero(Lista, Numero) :-
    lista_a_numero_aux(Lista, 0, Numero).

lista_a_numero_aux([], Numero, Numero).
lista_a_numero_aux([Digito|Resto], Acumulador, Numero) :-
    NuevoAcumulador is Acumulador * 10 + Digito,
    lista_a_numero_aux(Resto, NuevoAcumulador, Numero).
