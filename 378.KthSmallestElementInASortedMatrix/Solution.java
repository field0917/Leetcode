// Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.

// Note that it is the kth smallest element in the sorted order, not the kth distinct element.

// Example:

// matrix = [
//    [ 1,  5,  9],
//    [10, 11, 13],
//    [12, 13, 15]
// ],
// k = 8,

// return 13.
// Note: 
// You may assume k is always valid, 1 ≤ k ≤ n2.

import java.util.*;

public class Solution {
    //Wrong answer
    public int kthSmallest(int[][] matrix, int k) {
        //PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                minHeap.offer(matrix[i][j]);
            }
        }
        return minHeap.peek();
    }

    // public int kthSmallest(int[][] matrix, int k) {
    //     int n = matrix.length; 
    //     PriorityQueue<Tuple> minHeap = new PriorityQueue<>();

    //     for (int j = 0; j < n; j++) {
    //         minHeap.offer(new Tuple(0, j, matrix[0][j]));
    //     }

    //     for (int i = 0; i < k - 1; i++) {
    //         Tuple t = minHeap.poll();
    //         if (t.x == n - 1) continue;
    //         minHeap.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
    //     }
    //     return minHeap.poll().val;
    // }

    // class Tuple implements Comparable<Tuple> {
    //     int x, y, val;
    //     public Tuple (int x, int y, int val) {
    //         this.x = x;
    //         this.y = y;
    //         this.val = val;
    //     }

    //     @Override
    //     public int compareTo (Tuple t) {
    //         return this.val - t.val;
    //     }
    // }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9},{12,13,15},{10,11,14}};
        Solution s = new Solution();
        System.out.println(s.kthSmallest(matrix, 8));
    }
}