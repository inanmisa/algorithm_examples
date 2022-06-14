package slidingWindow;

import java.util.HashMap;
import java.util.Map;

/*
Fruits into Baskets (medium)


Problem Statement
You are visiting a farm to collect fruits. The farm has a single row of fruit trees. You will be given two baskets, and your goal is to pick as many fruits as possible to be placed in the given baskets.

You will be given an array of characters where each character represents a fruit tree. The farm has following restrictions:

Each basket can have only one type of fruit. There is no limit to how many fruit a basket can hold.
You can start with any tree, but you can’t skip a tree once you have started.
You will pick exactly one fruit from every tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
Write a function to return the maximum number of fruits in both baskets.


Example 1:
Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

Example 2:
Input: Fruit = ['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket. This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']

 */
public class FruitsInTheBasket {
    public static int find(char[] arr) {
        int maxNumber = Integer.MIN_VALUE;
        int windowStart=arr.length-1;
        Map<Character, Integer> map = new HashMap<>();
        for (int windowEnd = arr.length-1; windowEnd >= 0; windowEnd--) {
            Character currentChar = arr[windowEnd];
            map.putIfAbsent(currentChar, 0);
            map.compute(currentChar, (key, value) -> value + 1);
            while (map.size() > 2) {
               map.computeIfPresent(arr[windowStart],(key,value)->value-1);
               if(map.get(arr[windowStart])==0){
                   map.remove(arr[windowStart]);
               }
               windowStart--;
            }
            maxNumber = Math.max(maxNumber, windowStart-windowEnd+1);
        }
        return maxNumber;
    }

    public static void main(String[] args) {
        char[] arr = {'A', 'B', 'C', 'B', 'B', 'C'};
        System.out.println(find(arr));
    }
}
