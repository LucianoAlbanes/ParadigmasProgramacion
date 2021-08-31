% Exercise 2 | Extract the first and last element of a list of characters

getFirstAndLast([F|Xs], F, L) :- % 'F'irst 'L'ast
    reverse(Xs, [L|_]).


/* ~~~ V.2 | Old with variables~~~
continue([X], L) :-
    L is X.

continue([_|Xs], L) :-
    continue(Xs, L).

getFirstAndLast([F|Xs], F, L) :- % 'F'irst 'L'ast
    continue(Xs, L).
*/

/* ~~~ V.1 | Old with write ~~~
% Recursion until no tail.
continue([X]) :-
    write("Last = "),
    write(X).

continue([_|Xs]) :-
    continue(Xs).

% Cases: Empty, only one value, more than 1. 

getFirstAndLast([]) :- 
    write("Empty list"), nl.

getFirstAndLast([X]) :- 
    write("First = "),
    write(X), nl.

getFirstAndLast([X|Xs]) :- 
    write("First = "),
    write(X), nl,
    continue(Xs).
*/
