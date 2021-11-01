{-
Paradigmas de Programación 2021 - F. Ingeniería - UNCUYO
ALBANES Luciano Joaquín
-}

import System.IO ( hSetBuffering, stdout, BufferMode(NoBuffering) )
main :: IO ()

main = do
    hSetBuffering stdout NoBuffering
    putStrLn "Insert the exercise number..."
    putStrLn "    1 - Third character of a string"
    putStrLn "    2 - Factorial"
    putStrLn "    3 - Exponential operator"
    putStrLn "    4 - Greatest common divisor"
    putStrLn "    5 - Replicate string into an array"
    putStrLn "    6 - Pythagorean triples"
    putStrLn "    7 - Perfect numbers"

    putStr "Your choice: "
    userChoice <- readLn
    case userChoice of
        1 -> do
            putStr "\nInsert the string to get his third character: "
            userString <- getLine
            putStr "\nThe third character of \""
            putStr userString
            putStrLn "\" is: "
            print (third userString)
            return ()

        2 -> do
            putStr "\nInsert an integer to get his factorial: "
            userInput <- readLn
            putStr "The factorial of "
            putStr (show userInput)
            putStr " is: "
            print (factorial userInput)
            return ()

        3 -> do
            putStr "\nInsert a base and an exponent to get the exponential result:"
            putStr "\nBase: " 
            userBase <- readLn
            putStr "Exponent: "
            userExponent <- readLn
            putStr "The result of "
            putStr (show userBase)
            putStr "^"
            putStr (show userExponent)
            putStr " is: "
            print (exponentiation userBase userExponent)
            return ()

        4 -> do
            putStrLn "\nInsert two integers to calculate their GCD:"
            putStr "First number: "
            userFirstNumber <- readLn
            putStr "Second number: "
            userSecondNumber <- readLn
            putStr "The GCD of "
            putStr (show userFirstNumber)
            putStr " and "
            putStr (show userSecondNumber)
            putStr " is: "
            print (euclid userFirstNumber userSecondNumber)
            return ()

        5 -> do
            putStr "\nInsert the string to replicate: "
            userString <- getLine
            putStr "How many times?: "
            userTimes <- readLn
            print (replicate' userTimes userString)
            return ()

        6 -> do
            putStr "\nGenerating all pythagorean triples up to?: "
            userLimit <- readLn
            print (pyths userLimit)
            return ()

        7 -> do
            putStr "\nFinding all perfect numbers up to?: "
            userLimit <- readLn
            print (perfects userLimit)
            return ()

        _ -> do
            putStrLn "\nInvalid value, please try again."
            main

-- Some Exercises

-- 4.2
-- Define a function third :: [a] -> a that returns the third element
-- in a list that contains at least this many elements using:
--      a. head and tail
--      b. list indexing !!
--      c. pattern matching.
third :: [a] -> a
third = head.tail.tail


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


-- 6.1
-- How does the recursive version of the factorial function behave if applied to a negative argument,
-- such as (-1) ? Modify the definition to prohibit negative arguments by adding a guard to the
-- recursive case.
factorial :: Integer -> Integer
factorial n
        | n < 0 = -1 -- Will return (-1) if a negative number is introduced
        | n == 0 = 1
        | otherwise = n * factorial (n-1)


-- 6.3
-- Define the exponentiation operator ^ for non-negative integers using the same pattern of recursion
-- as the multiplication operator *, and show how the expression 2 ^ 3 is evaluated using your
-- definition.
exponentiation :: Integer -> Integer -> Integer
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
