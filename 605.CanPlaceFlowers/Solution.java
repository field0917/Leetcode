// Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

// Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

// Example 1:
// Input: flowerbed = [1,0,0,0,1], n = 1
// Output: True
// Example 2:
// Input: flowerbed = [1,0,0,0,1], n = 2
// Output: False
// Note:
// The input array won't violate no-adjacent-flowers rule.
// The input array size is in the range of [1, 20000].
// n is a non-negative integer which won't exceed the input array size.


public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        if (flowerbed == null || flowerbed.length == 0) return false;
        int len = flowerbed.length;
        // for (int i = 0; i < len; i++) {            
        //     if (flowerbed[i] == 0) {
        //         if (i == 0) {
        //             if (i + 1 < len) { // len >= 2
        //                 if (flowerbed[i + 1] == 0) {
        //                     n--;
        //                     i++;
        //                 } else { 
        //                     i += 2;
        //                 }
        //             } else {// len == 1
        //                 n--;
        //             }
        //         } else if (i == len - 1) {
        //             if (flowerbed[i - 1] == 0) {
        //                 n--;
        //             }
        //         } else {
        //             if (flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
        //                 n--;
        //                 i++;
        //             }
        //         }
                
        //     } else {
        //         i++;
        //     }
        // }
       
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == len - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        
        return n <= 0;
    }

    public static void main(String[] args) {
        int[] flowerbed = {0, 1, 0, 0, 1, 0, 1};
        int n = 1;
        Solution s = new Solution();
        System.out.println(s.canPlaceFlowers(flowerbed, n));
    }
}