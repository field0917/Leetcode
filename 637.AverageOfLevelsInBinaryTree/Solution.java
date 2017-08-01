// Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

// Example 1:
// Input:
//     3
//    / \
//   9  20
//     /  \
//    15   7
// Output: [3, 14.5, 11]
// Explanation:
// The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
// Note:
// The range of node's value is in the range of 32-bit signed integer.


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    // DFS
    // public List<Double> averageOfLevels(TreeNode root) {
    //     List<Double> sums = new ArrayList<>();
    //     List<Integer> counts = new ArrayList<>();

    //     helper(root, 0, sums, counts);
    //     List<Double> res = new ArrayList<>();

    //     for (int i = 0; i < sums.size(); i++) {
    //         res.add((double)(sums.get(i) / counts.get(i)));
    //     }
    //     return res;
    // }

    // private void helper(TreeNode root, int level, List<Double> sums, List<Integer> counts) {
    //     if (root == null) return;

    //     if (sums.size() <= level) {
    //         sums.add(0.0);
    //         counts.add(0);
    //     }

    //     // Calculate sum of each level    
    //     sums.set(level, sums.get(level) + root.val);
    //     //sums.remove(level + 1);

    //     // Calculate count of nodes of each level        
    //     counts.set(level, counts.get(level) + 1);
    //     //counts.remove(level + 1);
    

    //     helper(root.left, level + 1, sums, counts);
    //     helper(root.right, level + 1, sums, counts);
    // }

    
    // BFS
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        TreeNode node = root;
        queue.offer(node);

        while (!queue.isEmpty()) {
            int n = queue.size();
            double sum = 0.0;
            for (int i = 0; i < n; i++) {
                node = queue.poll();
                sum += node.val;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(sum / n);

        }
        return res;
    }
}