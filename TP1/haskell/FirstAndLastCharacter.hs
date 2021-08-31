main :: IO ()
main = do
    print charset
    print (getBorderChars charset)
    print alphabet
    print (getBorderChars alphabet)

-- Exercise 2 | Extract the first and last element of a list of characters

-- Some lists
charset :: [Char]
charset = ['a', 'b', 'c']
alphabet :: [Char]
alphabet = ['a'..'z']

-- Define function

getLast :: [Char] -> Maybe Char
getLast [] = Nothing 
getLast [x] = Just x
getLast (x : xs) = getLast xs

getBorderChars :: [Char] -> [Maybe Char]
getBorderChars [] = [Nothing, Nothing]
getBorderChars [x] = [Just x, Nothing]
getBorderChars (x : xs) = [Just x, getLast xs]

{- Alternative.
getBorderChars :: [a] -> (a, a)
getBorderChars xs = (head xs, last xs)
-}