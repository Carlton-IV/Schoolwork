1. 
a) all items are their squares mod 10
    1 -> 1, 2 -> 4, 3 -> 9, 4 -> 6, 5 -> 5, 6 -> 6, 7 -> 9, 8 -> 4, 9 -> 1, 10 -> 0
    **1,4,9,6,5,6,9,4,1,0     four numbers repeat**
    **square numbers always repeat this pattern shown, thus excluding numbers 2, 3, 7, and 8**
b) all items are their cubes
    1 -> 1, 2 -> 8, 3 -> 7, 4 -> 4, 5 -> 5, 6 -> 6, 7 -> 3, 8 -> 2, 9 -> 9, 10 -> 0
    **1,8,7,4,5,6,3,2,9,0     zero numbers repeat**
    **cubed numbers always repeat this pattern shown, so it will infinitly distribute evenly over 10 slots**
c) ~~all items are their squares times 10, mod 10, which returns zero~~ not valid
d) ~~all items would be double themselves, making every entry even~~ not valid

[B will distribute the keys most uniformly]

2. `Consider a hash table with 100 slots. Collisions are resolved by chaining. Assume simple uniform hashing, what is the probability that the first 3 slots are unfilled after the 3 insertions?`
97/100 x 97/100 x 97/100 = [912673/1000000]0398
0398

