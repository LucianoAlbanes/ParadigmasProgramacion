main :: IO ()
main = do
    print someIntegers
    print (invertIntList someIntegers)


-- Excessive 5 | Invert a list of integer elements.

someIntegers :: [Integer]
someIntegers = [1..15]

invertIntList :: [Integer] -> [Integer]
invertIntList [] = []
invertIntList [x] = [x]
invertIntList (x : xs) = invertIntList xs ++ [x]

invertIntListLazy :: [Integer] -> [Integer]
invertIntListLazy  = reverse
