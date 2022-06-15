package twoPointers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int i, j;
        for (i = 0, j = i + 1; i < nums.length && j < nums.length; i++,j++) {
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            if (j < nums.length && j - i > 1) {
                nums[i + 1] = nums[j];
            }
            if(j == nums.length){
                break;
            }
        }
        return i+1;
    }
    @Test
    public void test1() {
        int[] nums = {1, 1}; // Input array
        int[] expectedNums = {1}; // The expected answer with correct length
        int k = removeDuplicates(nums); // Calls your implementation
        Assertions.assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            Assertions.assertEquals(expectedNums[i], nums[i]);
        }

    }
    @Test
    public void test2() {
        int[] nums = {1, 1, 2}; // Input array
        int[] expectedNums = {1, 2}; // The expected answer with correct length
        int k = removeDuplicates(nums); // Calls your implementation
        Assertions.assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            Assertions.assertEquals(expectedNums[i], nums[i]);
        }

    }
    @Test
    public void test3() {
        int[] nums = {0,0,1,1,1,2,2,3,3,4}; // Input array
        int[] expectedNums = {0,1,2,3,4}; // The expected answer with correct length
        int k = removeDuplicates(nums); // Calls your implementation
        Assertions.assertEquals(expectedNums.length, k);
        for (int i = 0; i < k; i++) {
            Assertions.assertEquals(expectedNums[i], nums[i]);
        }

    }

}
