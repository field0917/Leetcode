// Given m arrays, and each array is sorted in ascending order. Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers a and b to be their absolute difference |a-b|. Your task is to find the maximum distance.

// Example 1:
// Input: 
// [[1,2,3],
//  [4,5],
//  [1,2,3]]
// Output: 4
// Explanation: 
// One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
// Note:
// Each given array will have at least 1 number. There will be at least two non-empty arrays.
// The total number of the integers in all the m arrays will be in the range of [2, 10000].
// The integers in the m arrays will be in the range of [-10000, 10000].


public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int len = arrays.size();
        int maxDist = Integer.MIN_VALUE;
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i = 1; i < len; i++) {
            int n = arrays.get(i).size();       
            maxDist = Math.max(maxDist, Math.abs(min - arrays.get(i).get(n - 1)));
            maxDist = Math.max(maxDist, Math.abs(max - arrays.get(i).get(0)));
            min = Math.min(min, arrays.get(i).get(0));
            max = Math.max(max, arrays.get(i).get(n - 1));
        }
        return maxDist;
        
    }
}