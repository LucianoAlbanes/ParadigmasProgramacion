main :: IO ()
main = do
    print "--Sara's Parents:"
    print (motherOf (Just "sara"))
    print (fatherOf (Just "sara"))
    print "--Sara's brother is cristian?:"
    print (brother (Just "cristian") (Just "sara"))
    print "--Sara's children are [child4M, child5W, child6M]?:"
    print (children (Just "child4M") (Just "sara"))
    print (children (Just "child5W") (Just "sara"))
    print (children (Just "child6M") (Just "sara"))

    print "--child1M's Parents:"
    print (motherOf (Just "child1M"))
    print (fatherOf (Just "child1M"))
    print "--child1M's siblings are [child2W, child3M]?:"
    print (sibling (Just "child1M") (Just "child2W"))
    print (sibling (Just "child1M") (Just "child3M"))
    print "--child1M's sister are [child2W, child3M]?:"
    print (sister (Just "child2W") (Just "child1M"))
    print (sister (Just "child3M") (Just "child1M"))
    print "--child1M's cousins are [child4M, child5W, child6M]?:"
    print (cousin (Just "child1M") (Just "child4M"))
    print (cousin (Just "child1M") (Just "child5W"))
    print (cousin (Just "child1M") (Just "child6M"))
    print "--child1M's cousinsMale is child5W?:"
    print (cousinMale (Just "child5W") (Just "child1M"))
    print "--child1M's cousinsWoman is child5W?:"
    print (cousinWoman (Just "child5W") (Just "child1M"))


-- Exercise 9 and 10 | Family tree and relationships

{-
                       ~~ README ~~~
    -- All the names of the queries must be written with Just.
    Example: `cousin (Just "child4M") (Just "child1M")`         // True.


    -- HARDCODED FAMILY TREE (as in java and prolog)
-}


-- ~~~~ Define relationships ~~~~ --

motherOf :: Maybe [Char] -> Maybe [Char]
-- Family root
motherOf x
    | x == Just "cristian" = Just "alice"
    | x == Just "sara" = Just "alice"

-- Family 0
    | x == Just "child1M" = Just "danna"
    | x == Just "child2W" = Just "danna"
    | x == Just "child3M" = Just "danna"

-- Family 1
    | x == Just "child4M" = Just "sara"
    | x == Just "child5W" = Just "sara"
    | x == Just "child6M" = Just "sara"

-- Family 3
    | x == Just "child9M" = Just "anne"
    | x == Just "child10W" = Just "anne"
    | x == Just "child11M" = Just "anne"

    | otherwise = Nothing


fatherOf :: Maybe [Char] -> Maybe [Char]
-- Family Root
fatherOf x
    | x == Just "cristian" = Just "bob"
    | x == Just "sara" = Just "bob"

-- Family 0
    | x == Just "child1M" = Just "cristian"
    | x == Just "child2W" = Just "cristian"
    | x == Just "child3M" = Just "cristian"

-- Family 1
    | x == Just "child4M" = Just "donald"
    | x == Just "child5W" = Just "donald"
    | x == Just "child6M" = Just "donald"

-- Family 2
    | x == Just "child7M" = Just "george"
    | x == Just "child8W" = Just "george"
    | x == Just "child7M" = Just "andrew"
    | x == Just "child8W" = Just "andrew"

    | otherwise = Nothing


-- Gender definitions
isWoman :: Maybe [Char] -> Bool
isWoman x
    | x == Just "alice" = True
    | x == Just "sara" = True
    | x == Just "danna" = True
    | x == Just "anne" = True
    | x == Just "child2W" = True
    | x == Just "child5W" = True
    | x == Just "child8W" = True
    | x == Just "child10W" = True
    | otherwise = False


isMale :: Maybe [Char] -> Bool
isMale x
    | x == Just "bob" = True
    | x == Just "cristian" = True
    | x == Just "donald" = True
    | x == Just "andrew" = True
    | x == Just "george" = True
    | x == Just "child1M" = True
    | x == Just "child4M" = True
    | x == Just "child7M" = True
    | x == Just "child9M" = True
    | x == Just "child3M" = True
    | x == Just "child6M" = True
    | x == Just "child11M" = True
    | otherwise = False



-- ~~~~ Queries ~~~~ --

-- Child, Parent.
-- is c child of p? 

children :: Maybe [Char] -> Maybe [Char] -> Bool
children c p
    | p == fatherOf c = True
    | p == motherOf c = True
    | otherwise = False


-- sibling1 sibling2 
-- Are s1 sibling of s2? (Share a parent)
sibling :: Maybe [Char] -> Maybe [Char] -> Bool
sibling s1 s2
    | s1 == s2 = False
    | f1 /= Nothing && f1 == f2 = True
    | m1 /= Nothing && m1 == m2 = True
    | otherwise = False
    where
        f1 = fatherOf s1
        f2 = fatherOf s2
        m1 = motherOf s1
        m2 = motherOf s2

-- cousin1 cousin2
-- Checks if c1 is a cousin of c2.
cousin :: Maybe [Char] -> Maybe [Char] -> Bool
cousin c1 c2
    | sibling f1 f2 = True
    | sibling f1 m2 = True
    | sibling m1 f2 = True
    | sibling m1 m2 = True
    | otherwise = False
    where
        f1 = fatherOf c1
        f2 = fatherOf c2
        m1 = motherOf c1
        m2 = motherOf c2


-- Gender specific functions

-- is b a brother of p?
brother :: Maybe [Char] -> Maybe [Char] -> Bool
brother b p 
    | isMale b && sibling b p = True 
    | otherwise = False

-- is s a sister of p?
sister :: Maybe [Char] -> Maybe [Char] -> Bool
sister s p 
    | isWoman s && sibling s p = True 
    | otherwise = False

-- is c a male cousin of p?
cousinMale :: Maybe [Char] -> Maybe [Char] -> Bool
cousinMale c p
    | isMale c && cousin c p = True 
    | otherwise = False

-- is c a woman cousin of p?
cousinWoman :: Maybe [Char] -> Maybe [Char] -> Bool
cousinWoman c p
    | isWoman c && cousin c p = True 
    | otherwise = False
