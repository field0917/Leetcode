// Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

// Example 1:
// Input: 
//     5
//    / \
//   3   6
//  / \   \
// 2   4   7

// Target = 9

// Output: True
// Example 2:
// Input: 
//     5
//    / \
//   3   6
//  / \   \
// 2   4   7

// Target = 28

// Output: False



// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

// Method 1: can be used in any Tree, not only BST. O(n) time, O(n) space
// class Solution {
//     public boolean findTarget(TreeNode root, int k) {
//         Set<Integer> set = new HashSet<>();
//         return helper(root, set, k);
//     }

//     private boolean helper(TreeNode root, Set<Integer> set, int k) {
//         if (root == null) return false;

//         if (set.contains(k - root.val)) return true;
//         set.add(root.val);

//         return helper(root.left, set, k) || helper(root.right, set, k);
//     }
// }


// Method 2: make use of BST, store the root values increasingly. O(n) time, O(n) space
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();

        inorder(root, list);

        for (int i = 0, j = list.size() - 1; i < j;) {
            if (list.get(i) + list.get(j) == k) return true;
            if (list.get(i) + list.get(j) < k) i++;
            else j--;
        } 
        return false;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);

    }
}