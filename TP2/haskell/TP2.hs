{-
Paradigmas de Programación 2021 - F. Ingeniería - UNCUYO
ALBANES Luciano Joaquín
-}

{-# OPTIONS_GHC -Wno-incomplete-patterns #-} -- 4.3 (contains at least this many elements {3})

main :: IO ()
main = do
    putStrLn "Insert the exercise number..."
    putStrLn "     1 - Exercise 4.1 (Split list into two halves)"
    putStrLn "     2 - Exercise 4.2 (Third element of a list using different methods)"
    putStrLn "     3 - Exercise 4.3 (Safetail)"
    putStrLn "     4 - Exercise 5.1 (Sum squares from 1 to 100)"
    putStrLn "     5 - Exercise 5.2 (Coordinate grid)"
    putStrLn "     6 - Exercise 5.4 (Replicate)"
    putStrLn "     7 - Exercise 5.5 (Pythagorean triples)"
    putStrLn "     8 - Exercise 5.6 (Perfect numbers)"
    putStrLn "     9 - Exercise 5.7 (Re-expressed list using single generators)"
    putStrLn "    10 - Exercise 6.1 (Factorial)"
    putStrLn "    11 - Exercise 6.2 (Sumdown)"
    putStrLn "    12 - Exercise 6.3 (Exponential operator)"
    putStrLn "    13 - Exercise 6.4 (Greatest common divisor)"

    putStrLn "Your choice: "
    userChoice <- readLn
    case userChoice of
        1 -> do
            putStrLn "\nHalving the following list:"
            print [0,1,2,3,4,5,6,7,8,9]
            print (halve [0,1,2,3,4,5,6,7,8,9])
            return ()

        2 -> do
            putStrLn "\nGetting the third element of the following list using all methods:"
            print [0,1,2,3,4,5,6,7,8,9]
            print (thirdA [0,1,2,3,4,5,6,7,8,9])
            print (thirdB [0,1,2,3,4,5,6,7,8,9])
            print (thirdC [0,1,2,3,4,5,6,7,8,9])
            return ()

        3 -> do
            putStrLn "\nGetting the tail of the following list using all methods:"
            putStrLn "[]"
            putStrLn "INFO: safetailX [] can't be placed inside the source code. Use ghci to verify."
            --print (safetailA [])
            --print (safetailB [])
            --print (safetailC [])

            putStrLn "\nGetting the tail of the following list using all methods:"
            print [1]
            print (safetailA [1])
            print (safetailB [1])
            print (safetailC [1])

            putStrLn "\nGetting the tail of the following list using all methods:"
            print [1,2,3]
            print (safetailA [1,2,3])
            print (safetailB [1,2,3])
            print (safetailC [1,2,3])
            return ()

        4 -> do
            putStrLn "\nThe sum is equal to:"
            print expression5_1
            return()

        5 -> do
            putStrLn "\nGenerating a gird of size 1 × 2:"
            print (grid 1 2)
            return ()

        6 -> do
            putStrLn "\nGenerating an array of size 4 with the string \"Hello\""
            print (replicate' 4 "Hello")
            return ()

        7 -> do
            putStrLn "\nGenerating all pythagorean triples up to 10."
            print (pyths 10)
            return ()

        8 -> do
            putStrLn "\nFinding all perfect numbers up to 1000."
            print (perfects 1000)
            return ()

        9 -> do
            putStrLn "\nThe resultant list is:"
            print expression5_7
            return ()

        10 -> do
            putStrLn "\nFactorial of 10:"
            print (factorial 10)
            putStrLn "\nFactorial of (-10) [returns (-1) when a negative number is introduced]:"
            print (factorial (-10))
            return ()

        11 -> do
            putStrLn "\nThe sumdown of 3 is:"
            print (sumdown 3)
            return ()

        12 -> do
            putStrLn "\nThe result of 2^3 is:"
            print (2 `exponentiation` 3)
            return ()

        13 -> do
            putStrLn "\nThe GCD of 27 and 6 is:"
            print (euclid 27 6)
            return ()

        _ -> do
            putStrLn "\nInvalid value, please try again."



{-----  CHAPTER 4  ----}

-- 4.1 
-- Using library functions, define a function halve :: [a] -> ([a], [a])
-- that splits an even-lengthed list into two halves. 
halve :: [a] -> ([a], [a])
halve [] = ([], [])
halve x = (a, b)
    where
        half = length x `div` 2
        a = take half x
        b = drop half x


-- 4.2
-- Define a function third :: [a] -> a that returns the third element
-- in a list that contains at least this many elements using:
--      a. head and tail
--      b. list indexing !!
--      c. pattern matching.
thirdA :: [a] -> a
thirdA = head.tail.tail

thirdB :: [a] -> a
thirdB x = x !! 2

thirdC :: [a] -> a
thirdC (x:(y:(z:zs))) = z


-- 4.3
-- Consider a function safetail :: [a] -> [a] that behaves in the same way as tail except that
-- it maps the empty list to itself rather than producing an error. Using tail and the function
-- null :: [a] -> Bool that decides if a list is empty or not, define safetail using:
--      a. conditional expression
--      b. guarded equations
--      c. pattern matching.
safetailA :: [a] -> [a]
safetailA x = if null x then x else tail x

safetailB :: [a] -> [a]
safetailB x
    | null x = x
    | otherwise = tail x

safetailC :: [a] -> [a]
safetailC [] = []
safetailC x = tail x



{-----  CHAPTER 5  ----}

-- 5.1
-- Using a list comprehension, give an expression that calculates the sum 1² + 2² + ... 100² of the first
-- one hundred integer squares.
expression5_1 :: Int
expression5_1 = sum [x^2 | x <- [1..100]]


-- 5.2
-- Suppose that a coordinate grid of size m × n is given by the list of all pairs (x, y) of integers such
-- that [ 0 <= x <= m  and  0 <= y <= n ]. Using a list comprehension, define a function
-- grid :: Int -> Int -> [(Int,Int)] that returns a coordinate grid of a given size. For example:
--      > grid 1 2
--      [(0,0),(0,1),(0,2),(1,0),(1,1),(1,2)]
grid :: Int -> Int -> [(Int,Int)]
grid m n = [(x, y) | x <- [0..m], y <- [0..n]]


-- 5.4
-- In a similar way to the function length , show how the library function
-- replicate :: Int -> a -> [a] that produces a list of identical elements
-- can be defined using a list comprehension.
replicate' :: Int -> a -> [a] -- replicate' to differentiate of replicate from Prelude
replicate' i x = [x | _ <- [1..i]]


-- 5.5
-- A triple (x, y, z) of positive integers is Pythagorean if it satisfies the equation x² + y² = z².
-- Using a list comprehension with three generators, define a function pyths :: Int -> [(Int,Int,Int)]
-- that returns the list of all such triples whose components are at most a given limit. For example:
--      > pyths 10
--      [(3,4,5),(4,3,5),(6,8,10),(8,6,10)]
pyths :: Int -> [(Int,Int,Int)]
pyths x = [(a, b, c) | a <- [1..x], b <- [1..x], c <- [1..x], a^2 + b^2 == c^2]


-- 5.6
-- A positive integer is perfect if it equals the sum of all of its factors, excluding the number itself.
-- Using a list comprehension and the function factors , define a function perfects :: Int -> [Int]
-- that returns the list of all perfect numbers up to a given limit.
perfects :: Int -> [Int]
perfects n = [x | x <- [1..n], (sum.factors) x == x]

factors :: Int -> [Int]
factors x = [f | f <- [1..x-1], x `mod` f == 0]


-- 5.7
-- Show how the list comprehension [(x,y) | x <- [1,2], y <- [3,4]] with two generators
-- can be re-expressed using two comprehensions with single generators. Hint: nest one
-- comprehension within the other and make use of the library function concat :: [[a]] -> [a].
expression5_7 :: Num a => [(a,a)]
expression5_7 = concat [[(x, y) | y <- [3, 4]] | x <- [1, 2]]



{-----  CHAPTER 6  ----}

-- 6.1
-- How does the recursive version of the factorial function behave if applied to a negative argument,
-- such as (-1) ? Modify the definition to prohibit negative arguments by adding a guard to the
-- recursive case.
factorial :: Int -> Int
factorial n
        | n < 0 = -1 -- Will return (-1) if a negative number is introduced
        | n == 0 = 1
        | otherwise = n * factorial (n-1)


-- 6.2
-- Define a recursive function sumdown :: Int -> Int that returns the sum of the non-negative
-- integers from a given value down to zero.
-- For example, sumdown 3 should return the result 3+2+1+0 = 6
sumdown :: Int -> Int
sumdown n
        | n < 0 = -1 -- Will return (-1) if a negative number is introduced
        | n == 0 = 0
        | otherwise = n + sumdown (n-1)


-- 6.3
-- Define the exponentiation operator ^ for non-negative integers using the same pattern of recursion
-- as the multiplication operator *, and show how the expression 2 ^ 3 is evaluated using your
-- definition.
exponentiation :: Int -> Int -> Int
exponentiation n 0 = 1
exponentiation n 1 = n
exponentiation n e = n * exponentiation n (e-1)


-- 6.4
-- Define a recursive function euclid :: Int -> Int -> Int that implements Euclid’s algorithm
-- for calculating the greatest common divisor of two non-negative integers: if the two numbers are
-- equal, this number is the result; otherwise, the smaller number is subtracted from the larger, and the
-- same process is then repeated. For example:
--      > euclid 6 27 = 3
euclid :: Int -> Int -> Int 
euclid a b
        | b == 0 = a
        | otherwise = euclid b (a `mod` b)
