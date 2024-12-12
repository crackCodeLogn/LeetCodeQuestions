package leetcode.practise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Vivek
 * @since 2024-12-11
 */
public class Q2558_E_TakeGiftsFromTheRichestPile {

  public static void main(String[] args) {
    Q2558_E_TakeGiftsFromTheRichestPile q2558ETakeGiftsFromTheRichestPile =
        new Q2558_E_TakeGiftsFromTheRichestPile();
    System.out.println(
        q2558ETakeGiftsFromTheRichestPile.pickGifts(new int[] {25, 64, 9, 4, 100}, 4));
    System.out.println(q2558ETakeGiftsFromTheRichestPile.pickGifts(new int[] {1, 1, 1, 1}, 4));
  }

  public long pickGifts(int[] gifts, int k) { // 6 ms
    long cnt = 0;
    PriorityQueue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
    for (int g : gifts) queue.add((long) g);

    while (k-- > 0 && !queue.isEmpty()) {
      long v = queue.poll();
      long sq = (long) Math.sqrt(v);
      queue.add(sq);
    }
    while (!queue.isEmpty()) cnt += queue.poll();

    return cnt;
  }

  public long pickGifts2(int[] gifts, int k) { // 26 ms
    long cnt = 0;
    int n = gifts.length;
    while (k-- > 0) {
      Arrays.sort(gifts);
      int v = gifts[n - 1];
      gifts[n - 1] = (int) Math.sqrt(v);
    }
    for (int i = 0; i < n; i++) cnt += gifts[i];
    return cnt;
  }
}
