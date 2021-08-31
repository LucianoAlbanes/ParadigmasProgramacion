main :: IO ()
main = do
    print alphabet
    print (removeLast alphabet)

-- Exercise 4 | Obtain a sublist from a list, removing the last element

alphabet :: [Char]
alphabet = ['a'..'z']

removeLast :: [a] -> [a]
removeLast [] = []
removeLast [x] = []
removeLast (x : xs) = x : removeLast xs -- [x] ++ removeLast xs {Concat}
