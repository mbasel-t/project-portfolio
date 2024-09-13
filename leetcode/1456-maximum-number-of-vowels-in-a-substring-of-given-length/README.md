# 1459. Maximum Number of Vowels In a Substring of Given Length

Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.

Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

 

Example 1:
> Input: s = "abciiidef", k = 3

> Output: 3

> Explanation: The substring "iii" contains 3 vowel letters.

Example 2:

> Input: s = "aeiou", k = 2

> Output: 2

> Explanation: Any substring of length 2 contains 2 vowels.

Example 3:

> Input: s = "leetcode", k = 3

> Output: 2

> Explanation: "lee", "eet" and "ode" contain 2 vowels.
 

Constraints:
* 1 <= s.length <= 105
* s consists of lowercase English letters.
* 1 <= k <= s.length

## My solution
First, the String is converted to an array of characters. A sliding window solution is implemented, iterating from the back of the array
to the front. The window is first set up by checking the last K characters, then is slid down, keeping track of when a vowel enters or
leaves the window. When a vowel enters the window, the current number of vowels in the window is compared to the highest number seen, and,
if it is greater, the result is updated. If a substring of length K is found that contains solely vowels, the loop is cut prematurely and
returned. Furthermore, if the window is at a point where it is close to finishing and there is no way the remaining characters could produce
a number of vowels within the window greater than the highest number seen, the loop cuts prematurely, as well.

Because the input "s" consists solely of lowercase letters, it is not necessary to convert its items to lower case or check for lower case
vowels.
