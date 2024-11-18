package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-11-17
 */
public class Q1652_E_DefuseTheBomb {

  public static void main(String[] args) {
    Q1652_E_DefuseTheBomb q1652EDefuseTheBomb = new Q1652_E_DefuseTheBomb();
    System.out.println(Arrays.toString(q1652EDefuseTheBomb.decrypt(new int[] {5, 7, 1, 4}, 3)));
    System.out.println(Arrays.toString(q1652EDefuseTheBomb.decrypt(new int[] {1, 2, 3, 4}, 0)));
    System.out.println(Arrays.toString(q1652EDefuseTheBomb.decrypt(new int[] {2, 4, 9, 3}, -2)));
  }

  public int[] decrypt(int[] code, int k) {
    if (k == 0) return new int[code.length];

    int n = code.length;
    int[] res = new int[n];
    for (int i = 0; i < n; i++) res[i] = process(code, i, k);
    return res;
  }

  private int process(int[] data, int i, int k) {
    int direction = k > 0 ? 1 : -1;
    int res = 0;
    for (int j = i + direction, k2 = Math.abs(k); k2-- > 0; j += direction) {
      int sane = j;
      if (j >= data.length) sane %= data.length;
      else if (j < 0) sane += data.length;
      res += data[sane];
    }
    return res;
  }
}
