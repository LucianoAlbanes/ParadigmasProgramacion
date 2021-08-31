main :: IO ()
main = do
    print alphabet
    print (removeFirst alphabet)

-- Exercise 3 | Obtain a sublist from a list, removing the first element

alphabet :: [Char]
alphabet = ['a'..'z']

removeFirst :: [a] -> Maybe [a]
removeFirst [] = Nothing
removeFirst [x] = Nothing
removeFirst (x : xs) = Just xs
