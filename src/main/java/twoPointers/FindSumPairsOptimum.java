package twoPointers;

import java.util.HashMap;
import java.util.Map;

public class FindSumPairsOptimum {
    int[] nums1, nums2;
    Map<Integer, Integer> nums2Frequency = new HashMap<>();

    public FindSumPairsOptimum(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        for (int i = 0; i < nums2.length; i++) {
            nums2Frequency.put(nums2[i], nums2Frequency.getOrDefault(nums2[i], 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldNum2 = nums2[index];
        nums2Frequency.put(oldNum2, nums2Frequency.get(oldNum2) - 1);
        nums2[index] += val;
        int newNum2 = nums2[index];
        nums2Frequency.put(newNum2, nums2Frequency.getOrDefault(newNum2,0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int num1 : nums1) {
            int diff = tot - num1;
            if (nums2Frequency.containsKey(diff)) {
                count += nums2Frequency.get(diff);
            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] num1 = {1, 1, 2, 2, 2, 3};
        int[] num2 = {1, 4, 5, 2, 5, 4};
        FindSumPairsOptimum obj = new FindSumPairsOptimum(num1, num2);
        System.out.println(obj.count(7));//8
        obj.add(3, 2);
        System.out.println("---------------------");//
        System.out.println(obj.count(8));//2
        System.out.println("---------------------");//
        System.out.println(obj.count(4));//1
        obj.add(0, 1);
        obj.add(1, 1);
        System.out.println("---------------------");//
        System.out.println(obj.count(7));//11
    }
}