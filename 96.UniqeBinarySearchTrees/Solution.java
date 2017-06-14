// Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

// For example,
// Given n = 3, there are a total of 5 unique BST's.

//    1         3     3      2      1
//     \       /     /      / \      \
//      3     2     1      1   3      2
//     /     /       \                 \
//    2     1         2                 3


// G[n]: the number of unique trees for a sequence of 1--n
// F[i,n]: the number of unique trees when i is the root(1 <= i <= n), and range is 1--n
// G[n] = F[1,n] + F[2,n] + ... + F[n,n]
// F[i,n] = G[i-1] * G[n-i];
// G[n] = G[0]G[n-1] + G[1]G[n-2] + ... + G[i]G[n-i-1] + ... + G[n-1]G[0]
public class Solution {
  public int numTrees(int n) {
    int[] G = new int[n + 1];
    G[0] = 1;
    G[1] = 1;

    for (int i = 2; i <= n; i++) {
    	for (int j = 0; j < i; j++) {
    		G[i] += G[j] * G[i - j - 1];
    	}
    }
    return G[n];
  }
}