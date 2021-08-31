% Exercise 9 and 10 | Family tree and relationships

% Define relationships

% Family root
parent(alice, cristian).
parent(alice, sara).
parent(bob, cristian).
parent(bob, sara).

% Family 0
parent(cristian, child1M).
parent(cristian, child2W).
parent(cristian, child3M).
parent(danna, child1M).
parent(danna, child2W).
parent(danna, child3M).

% Family 1
parent(donald, child4M).
parent(donald, child5W).
parent(donald, child6M).
parent(sara, child4M).
parent(sara, child5W).
parent(sara, child6M).

% Family 2
parent(george, child7M).
parent(george, child8W).
parent(andrew, child7M).
parent(andrew, child8W).

% Family 3
parent(anne, child9M).
parent(anne, child10W).
parent(anne, child11M).


% Gender definitions
woman(alice).
woman(sara).
woman(danna).
woman(anne).
woman(child2W).
woman(child5W).
woman(child8W).
woman(child10W).


male(bob).
male(cristian).
male(donald).
male(andrew).
male(george).
male(child1M).
male(child4M).
male(child7M).
male(child9M).
male(child3M).
male(child6M).
male(child11M).



% General rules
children(X, Y) :-
    parent(Y, X).

sibling(X, Y):-
    parent(Z, X),
    parent(Z, Y),
    X \= Y. % X can't be a sibling of X.

cousin(X, Y):-
    sibling(A, B),
    parent(A, X),
    parent(B, Y).


% Gender rules
father(X, Y):-
    parent(X, Y),
    male(X).

mother(X, Y):-
    parent(X, Y),
    woman(X).

brother(X, Y):-
    sibling(X, Y),
    male(X).

sister(X, Y):-
    sibling(X, Y),
    woman(X).

cousinMale(X, Y):-
    cousin(X, Y),
    male(X).

cousinWomen(X, Y):-
    cousin(X, Y),
    woman(X).
