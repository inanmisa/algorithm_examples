package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement

Given a string, find the length of the longest substring in it with no more than K distinct characters.

You can assume that K is less than or equal to the length of the given string.

Example 1:

Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".
Example 2:

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".
Example 3:

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".
 */
public class LongestSubstringKDistinctChar {
    public static int find(String s, int k){
        int windowStart=0;
        int longest=Integer.MIN_VALUE;
        HashMap<String,Integer> map= new HashMap<>();
        for(int windowEnd=0;windowEnd<s.length();windowEnd++){
            String curentChar=s.substring(windowEnd,windowEnd+1);
            map.computeIfAbsent(curentChar,key->0);
            map.compute(curentChar,(key,value)->value+1);
            while(map.size()>=k+1){
                longest= Math.max(windowEnd-windowStart,longest);
                String str=s.substring(windowStart,windowStart+1);
                map.compute(str,(key,value)->value-1);
                if(map.get(str)==0){
                      map.remove(str);
                }
                windowStart++;
            }

        }
        return longest;
    }
    public static void main(String[] args) {
        System.out.println(find("araaci",2));
    }
    public static int findLength(String str, int k) {
        if (str == null || str.length() == 0 || str.length() < k)
            throw new IllegalArgumentException();

        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        // in the following loop we'll try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            charFrequencyMap.put(rightChar, charFrequencyMap.getOrDefault(rightChar, 0) + 1);
            // shrink the sliding window, until we are left with 'k' distinct characters in
            // the frequency map
            while (charFrequencyMap.size() > k) {
                char leftChar = str.charAt(windowStart);
                charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar) - 1);
                if (charFrequencyMap.get(leftChar) == 0) {
                    charFrequencyMap.remove(leftChar);
                }
                windowStart++; // shrink the window
            }
            // remember the maximum length so far
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }
}
