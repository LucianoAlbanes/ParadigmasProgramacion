main :: IO ()
main = do
    print "10!"
    print (factorial 10)

-- Exercise 7 | Calc factorial of a number

factorial :: Integer -> Integer
factorial 1 = 1 
factorial x = factorial (x-1) * x


factorialLazy :: Integer -> Integer
factorialLazy x = product [1 .. x]