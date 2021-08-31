main :: IO ()
main = do
    print "fib at pos 10"
    print (fibonacci 10)

-- Exercise 8 | Calc fibonacci of a number

-- Naive.
fibonacciNaive :: Int -> Integer
fibonacciNaive 0 = 0
fibonacciNaive 1 = 1
fibonacciNaive x = fibonacciNaive(x-2) + fibonacciNaive(x-1)

-- Dynamic programming.
fibonacciSequence :: [Integer]
fibonacciSequence = go 0 1
    where go a b = a : go b (a+b)

fibonacci :: Int -> Integer
fibonacci x = fibonacciSequence !! x
