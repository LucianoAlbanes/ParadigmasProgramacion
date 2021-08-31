% Exercise 7 | Calc factorial of a number

factorial(0, 1).
factorial(N, X) :-
    N > 0,
    NPrev is N-1,
    factorial(NPrev, XPrev),
    X is XPrev*N.
