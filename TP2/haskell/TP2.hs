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
    putStrLn "     4 - Exercise 5.1 ()"
    putStrLn "     5 - Exercise 5.2 ()"
    putStrLn "     6 - Exercise 5.4 ()"
    putStrLn "     7 - Exercise 5.5 ()"
    putStrLn "     8 - Exercise 5.6 ()"
    putStrLn "     9 - Exercise 5.7 ()"
    putStrLn "    10 - Exercise 6.1 ()"
    putStrLn "    11 - Exercise 6.2 ()"
    putStrLn "    12 - Exercise 6.3 ()"
    putStrLn "    13 - Exercise 6.4 ()"

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
