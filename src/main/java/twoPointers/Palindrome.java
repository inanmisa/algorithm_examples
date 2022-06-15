package twoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
/*
Valid Palindrome

A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.



Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.


Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */
public class Palindrome {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "");
        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;
        boolean result = true;
        while (i < j) {
            if (arr[i] != arr[j]) {
                result = false;
                break;
            }
            i++;
            j--;
        }
        return result;
    }

    @Test
    public void test() {
        String str = "A man, a plan, a canal: Panama";
        Assertions.assertEquals(isPalindrome(str), true);
    }
}
