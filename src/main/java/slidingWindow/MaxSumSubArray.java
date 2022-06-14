package slidingWindow;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaxSumSubArray {

    public static int maxSum(int[] arr, int k) {
        int[] maxIndex = new int[k];
        for (int i = 0; i < k; i++) {
            maxIndex[i] = -1;
            for (int j = 0; j < arr.length; j++) {
                boolean skip = false;
                for (int m = i; m >= 0; m--) {
                    if (maxIndex[m] == j) {
                        skip = true;
                    }
                }
                if (skip) {
                    continue;
                }
                if (maxIndex[i] == -1 || arr[j] > arr[maxIndex[i]]) {
                    maxIndex[i] = j;
                }
            }
        }
        int sum = 0;
        System.out.printf("[");
        for (int i = 0; i < k; i++) {
            if(i==k-1){
                System.out.println(arr[maxIndex[i]]+"]");
            }else{
                System.out.printf(arr[maxIndex[i]]+",");
            }
            sum += arr[maxIndex[i]];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        System.out.println("sum=" + String.valueOf(maxSum(arr, 3)));
    }
}
