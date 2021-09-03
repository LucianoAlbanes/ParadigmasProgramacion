/*
* Paradigmas de Programación 2021 - F. Ingeniería - UNCUYO
* ALBANES Luciano Joaquín
*/

/*-----  Test family tree  ----*/
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
parent(andrewV2, child8W). % Useful for fullSibling

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


/*-----  NEEDED RULES  ----*/
sibling(X, Y):-
    parent(Z, X),
    parent(Z, Y),
    X \= Y. % X can't be a sibling of X.

father(X, Y):-
    parent(X, Y),
    male(X).

mother(X, Y):-
    parent(X, Y),
    woman(X).

brother(X, Y):-
    sibling(X, Y),
    male(X).


/*-----  SECTION 2.1  ----*/

% 2.1.i
% Modify the rule for brother on page 21 to give a rule for sister,
% the rule for uncle in Program 2.1 to give a rule for niece,
% and the rule for sibling in Program 2.1 so that it only recognizes
% full siblings, i.e., those that have the same mother and father.
sister(X, Y):-
    sibling(X, Y),
    woman(X).

niece(X, Y):-
    sibling(Z, Y),
    parent(Z, X),
    woman(X).

full_sibling(X, Y):-
    mother(M, X),
    mother(M, Y),
    father(F, X),
    father(F, Y),
    X \= Y. % X can't be a sibling of X.


% 2.1.ii
% Using a predicate married.couple (Wife, Husband), define the
% relationships mother_in_law, brother_in_law, and son_in_law.
married_couple(alice, bob).
married_couple(danna, cristian).
married_couple(sara, donald).
     
mother_in_law(X, Y):-
    married_couple(Y, Z),
    mother(X, Z).

brother_in_law(X, Y):-
    married_couple(Y, Z),
    brother(X, Z).

son_in_law(X, Y):-
    parent(Y, Z),
    married_couple(Z, X),
    male(X).


% 2.1.iii
% Describe the layout of objects in Figure 2.3 with facts using the predicates:
% left_of(Object1,Object2) and above(Object1,Object2).
% Define predicates right_of (Object1,Object2) and below(Object1,Object2)
% in terms of left_of and above, respectively.
left_of(bike, camera). % The bike is at the left of the camera
left_of(butterfly, fish).
left_of(hourglass, butterfly).
left_of(pencil, hourglass).

above(bike, pencil).
above(camera, butterfly).

right_of(X, Y):-
    left_of(Y, X).

below(X, Y):-
    above(Y, X).


/*-----  SECTION 2.2  ----*/

/*-----  SECTION 2.3  ----*/
