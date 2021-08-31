main :: IO ()
main = do
    print "3+20"
    print (add 3 20)
    print "14-3"
    print (subtraction 14 3)
    print "12*1.5"
    print (prod 12 1.5)
    print "22/7"
    print (divide 22 7)

-- Exercise 1 | Addition, subtraction, product and division

-- Def operations
add :: Num a => a -> a -> a
add x y = x+y

subtraction :: Num a => a -> a -> a
subtraction x y = x-y

prod :: Num a => a -> a -> a
prod x y = x*y

divide :: Fractional a => a -> a -> a
divide x y = x / y
