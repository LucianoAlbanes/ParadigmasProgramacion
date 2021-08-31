main :: IO ()
main = do
    print someIntegers
    print (sumIntList someIntegers)

-- Exercise 6 | Add a list of integers.

someIntegers :: [Integer]
someIntegers = [1..15]

sumIntList :: Num p => [p] -> p
sumIntList [] = 0
sumIntList (x : xs) = x + sumIntList xs

-- Alternative. Use `sum` from default prelude
sumIntListAlt :: (Foldable t, Num a) => t a -> a
sumIntListAlt = sum

{- Equivalent to [sumIntListAlt xs = sum xs] -}
