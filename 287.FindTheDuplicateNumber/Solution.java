// Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

// Note:
// You must not modify the array (assume the array is read only).
// You must use only constant, O(1) extra space.
// Your runtime complexity should be less than O(n2).
// There is only one duplicate number in the array, but it could be repeated more than once.


public class Solution {
    // Slowest, barely passed
    // public int findDuplicate(int[] nums) {
    //     int res = 0;
    //     for (int i = 0; i < nums.length; i++) {
    //         for (int j = i + 1; j < nums.length; j++) {
    //             if (nums[i] == nums[j]) res = nums[i];
    //         }
    //     }
    //     return res;
    // }
    
    // Binary Search O(nlgn)
    public int findDuplicate(int[] nums) {
        int start = 1, end = nums.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) count++;
            }
            if (count > mid) end = mid;
            else start = mid + 1;
        }
        return start;
    }

    // O(n) like a linkedlist loop

    // eg. nums = {2,6,3,4,7,4,4,1}
    //     index= {0,1,2,3,4,5,6,7}
    // Form a linkedlist: 2->3->4->7->1->6
    //                          ^<-------!
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,2,4};
        Solution s = new Solution();
        System.out.println(s.findDuplicate(nums));
    }
    

}