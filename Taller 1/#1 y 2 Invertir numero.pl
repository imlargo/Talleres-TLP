%primera manera?
invertir_num(N, X) :-
    invertir_num(N, "", Y),
    number_string(X, Y).

invertir_num(0, C, C) :- !.

invertir_num(N, C, X) :-
    Head is N // 10,
	Tail is N mod 10,
    number_string(Tail, L),
	string_concat(C, L, Final),
  	invertir_num(Head, Final, X).


%segunda manera?
invertir(0, C, C) :- !.

invertir(N, R) :-
    invertir_numero(N, 0, R).

invertir(N, C, R) :-
    N > 0,
    Digito is N mod 10,
    C2 is C * 10 + Digito,
    NuevoNumero is N // 10,
    invertir_numero(NuevoNumero, C2, R).