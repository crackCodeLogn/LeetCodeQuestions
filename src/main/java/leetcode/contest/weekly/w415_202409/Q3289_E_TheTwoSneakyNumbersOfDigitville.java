package leetcode.contest.weekly.w415_202409;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2024-09-14
 */
public class Q3289_E_TheTwoSneakyNumbersOfDigitville {
  public int[] getSneakyNumbers(int[] nums) {
    Set<Integer> set = new HashSet<>();
    int[] data = new int[2];
    int i = 0;
    for (int num : nums) {
      if (!set.contains(num)) set.add(num);
      else data[i++] = num;
    }
    return data;
  }
}
