// One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

//      _9_
//     /   \
//    3     2
//   / \   / \
//  4   1  #  6
// / \ / \   / \
// # # # #   # #
// For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

// Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.

// Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

// You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

// Example 1:
// "9,3,4,#,#,1,#,#,2,#,6,#,#"
// Return true

// Example 2:
// "1,#"
// Return false

// Example 3:
// "9,#,#,1"
// Return false

import java.util.*;
public class Solution {

	// Use stack
  public boolean isValidSerialization(String preorder) {
    Deque<String> stack = new LinkedList<>();

    String[] nodes = preorder.split(",");

    for (String node : nodes) {
    	
    	while (node.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
    		stack.pop();

    		if (stack.isEmpty()) return false;

    		stack.pop();
    	}
    	stack.push(node);
    }
    return stack.size() == 1 && stack.peek().equals("#");
  }

  // Use diff = outdegree - indegree
  // all non-null node provides 2 outdegree and 1 indegree (2 children and 1 parent), except root
  // all null node provides 0 outdegree and 1 indegree (0 child and 1 parent).

  public boolean isValidSerialization(String preorder) {
  	String[] nodes = preorder.split(",");
  	int diff = 1;

  	for (String node : nodes) {
  		if (--diff < 0) return false;
  		if (!node.equals("#")) diff += 2;
  	}
  	return diff == 0;
  }
}