%Fibonacci sin tail....
%Hechos
fibonacci(1, 1) :- !.
fibonacci(0, 0) :- !.

%Fibonacci sin tail
fibonacci(N, X) :-
    N1 is (N-1),
    N2 is (N-2),
    fibonacci(N1, F1),
    fibonacci(N2, F2),
    X is F1 + F2.
%....
    
%Fibonacci con tail (ChatGpt, ni idea xd)
fibn(N, Resultado) :-
    fibn(N, 0, 1, Resultado).

fibn(0, A, _, A) :- write("Done: "), write(A), !.


fibn(N, A, B, Resultado) :-
    N > 0,
    N1 is N - 1,
    write(N),nl,write(A),nl, write(B),nl,write("..."),nl,
    Suma is A + B,
    fibn(N1, B, Suma, Resultado).

%Como lo piden en el taller

%Hechos
fibonacci(1, 1) :- !.
fibonacci(0, 0) :- !.

%Fibonacci sin tail
fibonacci(X, Y) :-
    X1 is (X-1),
    X2 is (X-2),
    fibonacci(X1, F1),
    fibonacci(X2, F2),
    Y is F1 + F2.


%Fibonacci con tail
fibonacci_tail(X, Y) :-
    fibonacci_tail(X, 0, 1, Y).

fibonacci_tail(0, A, _, A) :-!.

fibonacci_tail(X, A, B, Y) :-
    X > 0,
    X1 is X - 1,
    Suma is A + B,
    fibonacci_tail(X1, B, Suma, Y).
