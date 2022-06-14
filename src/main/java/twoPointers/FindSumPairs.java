package twoPointers;

public class FindSumPairs {
    int[] nums1, nums2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
    }

    public void add(int index, int val) {
        nums2[index] += val;
    }

    public int count(int tot) {
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] + nums2[j] == tot) {
                    System.out.println("[i,j] = [" + i + "," + j + "]");
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 1, 2, 2, 2, 3};
        int[] num2 = {1, 4, 5, 2, 5, 4};
        FindSumPairs obj = new FindSumPairs(num1, num2);
        System.out.println(obj.count(7));//8
        obj.add(3, 2);
        System.out.println("---------------------");//
        System.out.println(obj.count(8));//2
        System.out.println("---------------------");//
        System.out.println(obj.count(4));//1
    }
}