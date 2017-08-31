// Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

// The root is the maximum number in the array.
// The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
// The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
// Construct the maximum tree by the given array and output the root node of this tree.

// Example 1:
// Input: [3,2,1,6,0,5]
// Output: return the tree root node representing the following tree:

//       6
//     /   \
//    3     5
//     \    / 
//      2  0   
//        \
//         1
// Note:
// The size of the given array will be in the range [1,1000].


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// Wrong answer
// class Solution {
//     public TreeNode constructMaximumBinaryTree(int[] nums) {
//         if (nums == null || nums.length == 0) return null;

//         int len = nums.length;
//         int max = Integer.MIN_VALUE, maxIdx = -1;

//         for (int i = 0; i < len - 1; i++) {
//             if (nums[i] > max) {
//                 max = nums[i];
//                 maxIdx = i;
//             }
//         }

//         TreeNode root = new TreeNode(max);

//         int[] numsLeft = new int[maxIdx];
//         for (int i = 0; i < maxIdx; i++) {
//             numsLeft[i] = nums[i];
//         }

//         int[] numsRight = new int[len - maxIdx - 1];
//         for (int i = 0; i < len - maxIdx - 1; i++) {
//             numsRight[i] = nums[maxIdx + i + 1];
//         }

//         root.left = constructMaximumBinaryTree(numsLeft);
//         root.right = constructMaximumBinaryTree(numsRight);

//         return root;

//     }
// }

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int start, int end) {
        if (start > end) return null;

        int max = nums[start];
        int mid = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                mid = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
}