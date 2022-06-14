package slidingWindow;

import java.util.Arrays;
import java.util.stream.IntStream;
/*
Given an array of positive numbers and a positive number ‘k,’ find the maximum sum of any contiguous subarray of size ‘k’.
 Example 1:

Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].
Example 2:

Input: [2, 3, 4, 1, 5], k=2
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
 */

public class MaxSumContiguousSubArray {

    public static int maxSum(int[] arr, int k) {
        int sum = arr[0] + arr[1] + arr[2];
        int max = sum;
        int windowsStart = 0;
        for (int i = 0; i + k < arr.length; i++) {
            sum = sum - arr[i] + arr[i + k];
            if (sum > max) {
                max = sum;
                windowsStart = i + 1;
            }
        }
        int[] subArr = IntStream.range(windowsStart, windowsStart + k)
                .map(i -> arr[i])
                .toArray();
        System.out.println(Arrays.toString(subArr));
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        System.out.println("sum=" + String.valueOf(maxSum(arr, 3)));
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int windowSum = 0, maxSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd]; // add the next element
            // slide the window, no need to slide if we've not hit the window size of 'k'
            if (windowEnd >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }

        return maxSum;
    }
}
