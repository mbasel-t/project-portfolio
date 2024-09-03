# 238. Product of Array Except Self (WIP)

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

### Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

### Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

## My solution; beats 99.74% runtime, beats 90.06% memory
The most natural solution for this to run in O(n) time is to first find the product of all items in nums, then, for a given nums[i], set answer[i] equal to the product divided by nums[i].
However, the notoriously annoying but staggeringly common number known as "zero" messes this up entirely because answer[i] where i equals the index of the zero will be evaluated as
0 divided by 0, which returns an error. Furthermore, the solution is also expected to avoid using the division operation, so this solution should not be used. Nonetheless, this philosophy
is what I chose to run with.

Generally, there will be three expected outcomes:

a. There are no zeros in the array; the above solution works
b. There is one zero in the array; the above solution does not work, and the actual solution
c. 
