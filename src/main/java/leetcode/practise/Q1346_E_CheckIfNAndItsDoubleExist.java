package leetcode.practise;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2024-11-30
 */
public class Q1346_E_CheckIfNAndItsDoubleExist {

  public static void main(String[] args) {
    Q1346_E_CheckIfNAndItsDoubleExist q1346ECheckIfNAndItsDoubleExist =
        new Q1346_E_CheckIfNAndItsDoubleExist();
    System.out.println(q1346ECheckIfNAndItsDoubleExist.checkIfExist(new int[] {10, 2, 5, 3}));
    System.out.println(q1346ECheckIfNAndItsDoubleExist.checkIfExist(new int[] {3, 1, 7, 11}));
  }

  public boolean checkIfExist(int[] arr) {
    Set<Integer> data = new HashSet<>();
    for (int val : arr) {
      if (val == 0) {
        if (data.contains(val)) return true;
        data.add(val);
        continue;
      }

      data.add(val);
      if (data.contains(val * 2)) return true;
      if (val % 2 == 0 && data.contains(val / 2)) return true;
    }
    return false;
  }
}
