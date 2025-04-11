package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-04-10
 */
public class Q2843_E_CountSymmetricIntegers {
  private static final List<Integer> values = new ArrayList<>(10000);

  public static void main(String[] args) {
    Q2843_E_CountSymmetricIntegers q2843ECountSymmetricIntegers =
        new Q2843_E_CountSymmetricIntegers();
    System.out.println(q2843ECountSymmetricIntegers.countSymmetricIntegers(1, 100));
    System.out.println(q2843ECountSymmetricIntegers.countSymmetricIntegers(1200, 1230));
  }

  public int countSymmetricIntegers(int low, int high) { // 16ms, beats 93.07%
    if (values.isEmpty()) {
      for (int num = 11; num <= 9999; num++) {
        String data = String.valueOf(num);
        if ((data.length() & 1) == 1) continue;

        int p1 = Integer.parseInt(data.substring(0, data.length() / 2));
        int p2 = Integer.parseInt(data.substring(data.length() / 2));
        if (p1 == p2 || sum(p1) == sum(p2)) values.add(num);
      }
    }
    int cnt = 0;
    for (int val : values) if (val >= low && val <= high) cnt++;
    return cnt;
  }

  public int countSymmetricIntegers2(int low, int high) { // 75 ms, beats 13.85%
    int cnt = 0;
    for (int num = low; num <= high; num++) {
      String data = String.valueOf(num);
      if ((data.length() & 1) == 1) continue;

      int p1 = Integer.parseInt(data.substring(0, data.length() / 2));
      int p2 = Integer.parseInt(data.substring(data.length() / 2));
      if (sum(p1) == sum(p2)) cnt++;
    }
    return cnt;
  }

  private int sum(int num) {
    int sum = 0;
    while (num > 0) {
      sum += num % 10;
      num /= 10;
    }
    return sum;
  }
}
