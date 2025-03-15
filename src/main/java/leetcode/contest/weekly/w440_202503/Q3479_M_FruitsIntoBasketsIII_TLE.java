package leetcode.contest.weekly.w440_202503;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2025-03-08
 */
public class Q3479_M_FruitsIntoBasketsIII_TLE {

  public static void main(String[] args) {
    Q3479_M_FruitsIntoBasketsIII_TLE q3479MFruitsIntoBasketsIIITLE =
        new Q3479_M_FruitsIntoBasketsIII_TLE();
    System.out.println(
        q3479MFruitsIntoBasketsIIITLE.numOfUnplacedFruits(
            new int[] {4, 2, 5}, new int[] {3, 5, 4}));
    System.out.println(
        q3479MFruitsIntoBasketsIIITLE.numOfUnplacedFruits(
            new int[] {3, 6, 1}, new int[] {6, 4, 7}));
  }

  public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
    int cnt = 0, cut = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    for (int basket : baskets) pq.offer(basket);
    for (int fruit : fruits) {
      boolean flag = false;
      List<Integer> list = new ArrayList<>();
      while (!pq.isEmpty()) {
        Integer poll = pq.poll();
        if (fruit <= poll) {
          flag = true;
          break;
        }
        list.add(poll);
      }
      if (!flag) cnt++;
      pq.addAll(list);
    }
    return cnt;
  }
}
