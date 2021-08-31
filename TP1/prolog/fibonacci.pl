% Exercise 8 | Calc n-th fibonacci number [O(2^n)]

fibonacci(0, 0).
fibonacci(1, 1).
fibonacci(N, X) :-
    N > 0,
    N1 is N-1,
    N2 is N-2,
    fibonacci(N1, X1),
    fibonacci(N2, X2),
    X is X1+X2.
