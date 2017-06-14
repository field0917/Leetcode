// You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

// The null node needs to be represented by empty parenthesis pair "()". And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between the string and the original binary tree.

// Example 1:
// Input: Binary tree: [1,2,3,4]
//        1
//      /   \
//     2     3
//    /    
//   4     

// Output: "1(2(4))(3)"

// Explanation: Originallay it needs to be "1(2(4)())(3()())", 
// but you need to omit all the unnecessary empty parenthesis pairs. 
// And it will be "1(2(4))(3)".
// Example 2:
// Input: Binary tree: [1,2,3,null,4]
//        1
//      /   \
//     2     3
//      \  
//       4 

// Output: "1(2()(4))(3)"

// Explanation: Almost the same as the first example, 
// except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }

  // @Override
  // public String toString() {
  //   return String.valueOf(val);
  // }
}

public class Solution {
  // public String tree2str(TreeNode t) {
  //   if (t == null) return "";
  //   StringBuilder sb = preorder(t);
  //   return sb.toString();
  // }

  // private StringBuilder preorder(TreeNode t) {
  //   //if (t == null) return sb;
  //   StringBuilder sb = new StringBuilder();
  //   sb.append(t.val);
  //   if (t.left == null && t.right == null) return sb;
    
  //   if (t.left != null && t.right == null) {
  //     sb.append("(").append(preorder(t.left)).append(")");
  //   } else if (t.left == null && t.right != null) {
  //     sb.append("()").append("(").append(preorder(t.right)).append(")");
  //   } else {
  //     sb.append("(").append(preorder(t.left)).append(")");
  //     sb.append("(").append(preorder(t.right)).append(")");
  //   }
  //   return sb;
  // }

  public String tree2str(TreeNode t) {
    if (t == null) return "";
    String s = String.valueOf(t.val);
    String left = tree2str(t.left);
    String right = tree2str(t.right);

    if (left.equals("") && right.equals("")) return s;
    if (left.equals("")) return s + "()(" + right + ")";
    if (right.equals("")) return s + "(" + left + ")";
    
    return s + "(" + left + ")" + "(" + right + ")";
  }
}