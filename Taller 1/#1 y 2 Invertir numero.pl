%primera manera?
alo(N, X) :-
    sexo(N, "", Y),
    number_string(X, Y).

alo(0, C, C) :- !.

alo(N, C, X) :-
    Head is N // 10,
	Tail is N mod 10,
    number_string(Tail, L),
	string_concat(C, L, Final),
  	sexo(Head, Final, X).


%segunda manera?
invertir(0, C, C) :- !.

invertir(N, C, R) :-
    N > 0,
    Digito is N mod 10,
    C2 is C * 10 + Digito,
    NuevoNumero is N // 10,
    invertir_numero(NuevoNumero, C2, R).
	
invertir(N, R) :-
    invertir_numero(N, 0, R).