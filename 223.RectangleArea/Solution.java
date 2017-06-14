// Find the total area covered by two rectilinear rectangles in a 2D plane.

// Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

// Rectangle Area
// Assume that the total area is never beyond the maximum possible value of int.

public class Solution {
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int area1 = (C - A) * (D - B);
    int area2 = (G - E) * (H - F);
    int area = 0;
    if (A > G || E > C || F > D || B > H) return area1 + area2;

    int leftX = 0, leftY = 0, rightX = 0, rightY = 0;
    leftX = A > E ? A : E;
    leftY = B > F ? B : F;
    rightX = C < G ? C : G;
    rightY = D < H ? D : H;

    int sameArea = (rightX - leftX) * (rightY - leftY);
    area = area1 + area2 - sameArea;

    return area;
  }

  // 2nd time by myself
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    int area1 = (C - A) * (D - B);
    int area2 = (G - E) * (H - F);
    int sameArea = 0;

    if (G < A || E > C || F > D || B > H) return area1 + area2;

    sameArea = Math.abs(Math.max(A, E) - Math.min(C, G)) * Math.abs(Math.max(B, F) - Math.min(D, H));

    return area1 + area2 - sameArea;  
  }
}