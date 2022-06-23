package twoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
/*
Two Sum II - Input Array Is Sorted
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.



Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].


Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.
 */

public class TwoSumSortedArray {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0, j = i + 1; i < numbers.length; i++) {
            if (i + 2 < numbers.length && numbers[i] == numbers[i + 2]) {
                i += 2;
                continue;
            }
            while (j < numbers.length) {
                if (numbers[i] + numbers[j] == target && i != j) {
                    int index1 = Math.min(i, j) + 1;
                    int index2 = Math.max(i, j) + 1;
                    return new int[]{index1, index2};
                }
                j++;
            }
            j = i + 1;

        }

        return null;
    }

    @Test
    public void test1() {
        int[] arr = {2, 3, 4};
        int[] expected = {1, 3};
        int target = 6;
        Assertions.assertArrayEquals(expected, twoSum(arr, target));
    }

    @Test
    public void test2() {
        int[] arr = {2, 7, 11, 15};
        int[] expected = {1, 2};
        int target = 9;
        Assertions.assertArrayEquals(expected, twoSum(arr, target));
    }

    @Test
    public void test3() {
        int[] arr = {-1, 0};
        int[] expected = {1, 2};
        int target = -1;
        Assertions.assertArrayEquals(expected, twoSum(arr, target));
    }
}
