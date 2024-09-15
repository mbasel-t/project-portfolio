## 151. Reverse Words in a String [medium]

Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

Example 1:
> Input: s = "the sky is blue"

> Output: "blue is sky the"

Example 2:
> Input: s = "  hello world  "

> Output: "world hello"

> Explanation: Your reversed string should not contain leading or trailing spaces.

Example 3:
> Input: s = "a good   example"

> Output: "example good a"

> Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

## My solution
* Runtime beats 92.93%
* Memory beats 57.82%

For this problem, in order to run as quickly as possible, I chose to split the input "s" by spaces into an array of Strings "words". I also
create a new StringBuilder "result" which will store the problem solution. Using the fence post method, I begin by appending solutions to
the StringBuilder from the back of "words" to the front until the StringBuilder's length is higher than 0, then I continue traversing "words"
in the same manner, but append a space in front of the String when I append one, and I only append Strings of a length above 0 so that only one space is between each word. After the traversal is complete, "result" is converted into a String and returned.
