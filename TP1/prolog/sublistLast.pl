% Exercise 4 | Obtain a sublist from a list, removing the last element

removeLast(X, Y):-
    reverse(X, [_|Rs]),
    reverse(Rs, Y).
