% Implementation of quicksort in prolog recursively.
% get pivot
pivot(_, [], [], []).
pivot(P, [H|T], [H|L], R) :-
    H =< P,
    pivot(P, T, L, R).
pivot(P, [H|T], L, [H|R]) :-
    H > P,
    pivot(P, T, L, R).

quicksort([], []).
quicksort([H|T], S) :-
    pivot(H, T, L, R),
    quicksort(L, S1),
    quicksort(R, S2),
    append(S1, [H|S2], S).