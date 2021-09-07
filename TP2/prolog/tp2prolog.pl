/*
* Paradigmas de Programación 2021 - F. Ingeniería - UNCUYO
* ALBANES Luciano Joaquín
*/


/*-----  SECTION 2.1  ----*/

% TEST FAMILY TREE
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


% NEEDED RULES
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
left_of(bike, camera). % The bike is at the left of the camera left_of(atLeft, atRight).
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

% EXAMPLE COURSES (COVID-19 Edition)
course(paradigms, time(tuesday,    8, 11), lecturer(sergio,    prof), location(aula_abierta, bbb  )).
course(paradigms, time(thursday,   8, 11), lecturer(sergio,    prof), location(aula_abierta, bbb  )).
course(os,        time(monday,    18, 21), lecturer(alejandro, prof), location(aula_abierta, meet1)).
course(os,        time(tuesday,   18, 21), lecturer(alejandro, prof), location(aula_abierta, meet1)).
course(ai,        time(monday,    17, 20), lecturer(carlos,    prof), location(aula_abierta, meet2)).
course(ai,        time(wednesday, 17, 20), lecturer(carlos,    prof), location(aula_abierta, meet2)).
course(fooCourse, time(wednesday, 18, 21), lecturer(alice,     prof), location(aula_abierta, meet2)). % This one conflicts with ai wednesday (17-20) (meet2)

% PREDEFINED RULES
lecturer(Lecturer, Course):- 
   course(Course, _, Lecturer, _).

duration(Course, Length):- 
    course(Course, time(_, Start, Finish), _, _),
    plus(Start, Length, Finish).

teaches(Lecturer, Day):-
    course(_, time(Day, _, _), Lecturer, _).

occupied(Room, Day, Time):-
    course(_, time(Day, Start, Finish), _, Room),
    Start =< Time, Time =< Finish.


% 2.2.i
% Add rules defining the relations location(Course, Building), busy(Lecturer, Time),
% and cannot_meet(Lecturer1, Lecturer2). Test with your own course facts.
location(Course, Building):-
    course(Course, _, _, location(Building, _)).

busy(Lecturer, Day, Time):- % !!! Added a Day variable, because if not will return true if ANY day of the week is busy at that Time.
    course(_, time(Day, Start, Finish), Lecturer, _),
    Start =< Time, Time =< Finish.

cannot_meet(Lecturer1, Lecturer2, Day, Time):- % !!! Added Day and Time variable. If both lecturers are in a course in the specified time and day, verifies true.
    course(_, time(Day, Start1, Finish1), Lecturer1, _),
    course(_, time(Day, Start2, Finish2), Lecturer2, _),
    Lecturer1 \= Lecturer2,
    Start1 =< Time, Time =< Finish1,
    Start2 =< Time, Time =< Finish2.


% 2.2.ii
% Possibly using relations from Exercise (i),
% define the relation schedule_conflict(Time, Place, Course1, Course2).
schedule_conflict(Time, Place, Course1, Course2):-
    course(Course1, time(Day1, Start1, Finish1), _, Place),
    course(Course2, time(Day2, Start2, Finish2), _, Place),
    Course1 \= Course2,
    Start1 =< Time, Time =< Finish1,
    Start2 =< Time, Time =< Finish2,
    Day1 == Day2.


% 2.2.iii
% Write a program to check if a student has met the requirements for a college degree.
% Facts will be used to represent the courses that the student has taken and the grades obtained,
% and rules will be used to enforce the college requirements.
taken_courses(student_1, paradigms, 8).
taken_courses(student_1, os,        9).
taken_courses(student_1, ai,        7).
taken_courses(student_1, fooCourse, 7).
taken_courses(student_2, paradigms, 5).
taken_courses(student_2, os,        8).
taken_courses(student_2, ai,        9).
taken_courses(student_2, fooCourse, 9).

% This degree only has 4 courses. The minimum obtained grade per course is 6. 
met_degree_requirements(Student) :-
    taken_courses(Student, paradigms, A), A >= 6,
    taken_courses(Student, os,        B), B >= 6,
    taken_courses(Student, ai,        C), C >= 6,
    taken_courses(Student, fooCourse, D), D >= 6.


% 2.2.iv
% Design a small database for an application of your own choice.
% Use a single predicate to express the information, and invent suitable rules.

% products_db(sku, brand, model, price, tax_porcentaje, stock, provider).
products_db(100, amd,   ryzen_9_5950X,  723, 10.5, 5, computers_SA).
products_db(101, amd,   ryzen_9_5900X,  497, 10.5, 3, computers_SA).
products_db(102, amd,   ryzen_7_5800X,  373, 10.5, 9, computers_SA).
products_db(103, amd,   ryzen_5_5600X,  271, 10.5, 8, computers_SA).
products_db(104, amd,   ryzen_7_5700G,  324, 10.5, 4, computers_SA).
products_db(105, amd,   ryzen_5_5600G,  234, 10.5, 5, computers_SA).
products_db(106, intel, core_i9_11900K, 487, 10.5, 3, moore_INC   ).
products_db(107, intel, core_i9_11900,  397, 10.5, 5, moore_INC   ).
products_db(108, intel, core_i7_11700K, 361, 10.5, 0, moore_INC   ).
products_db(109, intel, core_i5_11600K, 237, 10.5, 9, moore_INC   ).
products_db(110, intel, core_i5_11500,  173, 10.5, 7, moore_INC   ).

below_stock(Threshold, SKU) :-
    products_db(SKU, _, _, _, _, Stock, _),
    Stock =< Threshold.

price_with_tax(SKU, Price) :-
    products_db(SKU, _, _, Before_Tax_Price, Tax_Porcentaje, _, _),
    Price is Before_Tax_Price * (1 + Tax_Porcentaje / 100).


/*-----  SECTION 2.3  ----*/

% 2.3.i
% A stack of blocks can be described by a collection of facts on(Block1, Block2),
% which is true if Block1 is on Block2. Define a predicate above(Block1, Block2)
% that is true if Block1 is above Block2 in the stack.
% (Hint: above is the transitive closure of on.)
on(5, 4).
on(4, 3).
on(3, 2).
on(2, 1).
on(1, 0).

above2(High, Low) :- % above/2 conflicts with predicate at line 140
    on(High, Low).
above2(High, Low) :-
    on(High, Temp),
    above2(Temp, Low).


% 2.3.ii
% Add recursive rules for left_of and above from Exercise 2.1.iii
% Define higher (Object1,Object2), which is true if Object1
% is on a line higher than Object2 in Figure 2.3.
% For example, the bicycle is higher than the fish in the figure.
at_left(L, R) :-
    left_of(L, R).
at_left(L, R) :-
    left_of(T, R),
    at_left(L, T).

higher(H, L) :-
    above(H, L).
higher(H, L) :-
    above(H, T),
    higher(T, L).


% 2.3.iii
% How many nodes are there in the proof tree for connected(a,e) using Programs 2.6 and 2.7?
% In general, using Program 2.6 and a collection of edge/2 facts, how many nodes are there in a
% proof tree establishing that two nodes are connected by a path containing n intermediate nodes?

% Answer = 5 nodes.
