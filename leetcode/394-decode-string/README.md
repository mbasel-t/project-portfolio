# 394. Decode String

Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.

Example 1:
> Input: s = "3[a]2[bc]"

> Output: "aaabcbc"

Example 2:
> Input: s = "3[a2[c]]"

> Output: "accaccacc"

Example 3:
> Input: s = "2[abc]3[cd]ef"

> Output: "abcabccdcdcdef"
 
Constraints:
* 1 <= s.length <= 30
* s consists of lowercase English letters, digits, and square brackets '[]'.
* s is guaranteed to be a valid input.
* All the integers in s are in the range [1, 300].

## My solution
The biggest two difficulties for this problem were, a) the existence of non-encoded strings (e.g. the 'b' in "2[a]b"), and b) doubly-encoded strings (e.g. the "2[b]" in "2[2[b]]"). In order to solve this, I convert the input String into an array of chars and split the problem into two parts.

### Method evaluateCommand (WIP)
The method evaluateCommand processes commands exclusively. It 

### Method evaluateString
The method evaluateString processes arrays of characters to find encoded strings within them, then sends them to evaluateCommand for it to process and return. In this way, evaluateString can take any array of characters and return a version of it with all commands inside processed.
