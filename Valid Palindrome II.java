/*
Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

Example 1:
Input: "aba"
Output: True
Example 2:
Input: "abca"
Output: True
Explanation: You could delete the character 'c'.
*/

class Solution {
     public boolean isPalindrome(String s, int i, int j) {
        for (int k = i; k <= i + (j - i) / 2; k++) {
            if (s.charAt(k) != s.charAt(j - k + i))
                return false;
        }
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int m = s.length();
        for (int i = 0; i < m / 2; i++) {
            if (s.charAt(i) != s.charAt(m - 1 - i)) {
                int j = m - 1 - i;
                return (isPalindrome(s, i+1, j) ||
                        isPalindrome(s, i, j-1));
            }
        }
        return true;
    }
}