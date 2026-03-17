62:257 Assignment 4

Part I Algorithm Analysis
1. Tamarindo Airlines wants to give a first –class upgrade coupon 
to their top log n frequent flyers, based on the number miles accumulated, 
where n is the total number of the airlines’ frequent flyers. 
The algorithm they currently use, which runs in O(n log n) time, 
sorts the flyers by the number of miles flown and then scans 
the sorted list to pick the top log n flyers. Describe an algorithm 
that identifies the top log n flyers in O(n) time.

`Answer: `

2. Develop an algorithm that computes the kth smallest element of 
a set of n distinct integers in
O(n + k log n) time.

`Answer: build a new heap using the given set of n distinct integers, a reversed comparitor (where 1 > 2 etc.), and the bottom up method. Call removeMin() k-1 times, discarding the outputs. Finally call removeMin() one last time, and store the result.`

3. Part II codings.

Complete the rehash method in HashTableMap.java
