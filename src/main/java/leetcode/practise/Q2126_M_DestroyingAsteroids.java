package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2026-05-30
 */
public class Q2126_M_DestroyingAsteroids {

  public static void main(String[] args) {
    Q2126_M_DestroyingAsteroids q2126MDestroyingAsteroids = new Q2126_M_DestroyingAsteroids();
    System.out.println(
        q2126MDestroyingAsteroids.asteroidsDestroyed(10, new int[] {3, 9, 19, 5, 21}));
    System.out.println(q2126MDestroyingAsteroids.asteroidsDestroyed(5, new int[] {4, 9, 23, 4}));
  }

  public boolean asteroidsDestroyed(int mass, int[] asteroids) { // 26 ms, beats 81.52%
    long planet = mass;
    Arrays.sort(asteroids);
    for (int asteroid : asteroids) {
      if (planet >= asteroid) planet += asteroid;
      else return false;
    }
    return true;
  }
}
