package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 9/26/25
 */
public class Q0812_E_LargestTriangleArea {

  public static void main(String[] args) {
    Q0812_E_LargestTriangleArea q0812ELargestTriangleArea = new Q0812_E_LargestTriangleArea();
    System.out.println(
        q0812ELargestTriangleArea.largestTriangleArea(
            new int[][] {
              {0, 0},
              {0, 1},
              {1, 0},
              {0, 2},
              {2, 0}
            }));
    System.out.println(
        q0812ELargestTriangleArea.largestTriangleArea(
            new int[][] {
              {0, 0},
              {1, 0},
              {0, 1}
            }));
  }

  public double largestTriangleArea(int[][] points) { // 22ms, beats 7.06%
    double maxArea = 0.0;

    for (int i = 0; i < points.length; i++) {
      for (int j = i + 1; j < points.length; j++) {
        for (int k = j + 1; k < points.length; k++) {
          double[] sides = {
            getEuclideanDistance(points[i], points[j]),
            getEuclideanDistance(points[i], points[k]),
            getEuclideanDistance(points[j], points[k])
          };
          Arrays.sort(sides);
          if (sides[0] + sides[1] > sides[2]) {
            maxArea = Math.max(maxArea, calcAreaSquared(sides[0], sides[1], sides[2]));
          }
        }
      }
    }

    return Math.sqrt(maxArea);
  }

  private double getEuclideanDistance(int[] point1, int[] point2) {
    return Math.sqrt(Math.pow(point2[0] - point1[0], 2) + Math.pow(point2[1] - point1[1], 2));
  }

  private double calcAreaSquared(double a, double b, double c) {
    double s = (a + b + c) / 2.0;
    return s * (s - a) * (s - b) * (s - c);
  }
}
