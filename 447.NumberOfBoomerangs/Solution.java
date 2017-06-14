// Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

// Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

// Example:
// Input:
// [[0,0],[1,0],[2,0]]

// Output:
// 2

// Explanation:
// The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]

public class Solution {
  public int numberOfBoomerangs(int[][] points) {
  	if (points.length == 0) return 0;

  	int num = 0;
  	
		for (int i = 0; i < points.length; i++) {
      Map<Double, Integer> map = new HashMap<>();
			for (int j = 0; j < points.length; j++) {
				if (j == i) continue;
				double distance = getDistance(points[i], points[j]);
				if (map.containsKey(distance)) {
					map.put(distance, map.get(distance) + 1);
				} else {
					map.put(distance, 1);
				}
			}
			// iterate map
      for (int n : map.values()) {
        if (n != 1)
          num += factorial(n) / factorial(n - 2); // same as n * (n - 1), no need to use factorial
      }
		}
    return num;
  }

  private double getDistance(int[] point1, int[] point2) {
  	double distance = Math.sqrt(Math.pow(Math.abs(point1[0] - point2[0]), 2) + Math.pow(Math.abs(point1[1] - point2[1]), 2));
  	return distance;
  }
  // To avoid using double, no need to use squre root
  // private int getDistance(int[] point1, int[] point2) {
  //   int distance = Math.pow((point1[0] - point2[0]), 2) + Math.pow((point1[1] - point2[1]), 2);
  //   return distance;
  // }

  private int factorial(int x) {
  	if (x == 0) return 1;
  	int res = 1;
  	for (int i = 1; i <= x; i++) {
  		res *= i;
  	}
  	return res;
  }
}