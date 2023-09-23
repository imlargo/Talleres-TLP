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