package leetcode.practise;

import java.util.HashSet;
import java.util.Set;

public class Q2154_E_KeepMultiplyingFoundValuesByTwo {
  public static void main(String[] args) {
    Q2154_E_KeepMultiplyingFoundValuesByTwo q2154EKeepMultiplyingFoundValuesByTwo =
        new Q2154_E_KeepMultiplyingFoundValuesByTwo();
    System.out.println(
        q2154EKeepMultiplyingFoundValuesByTwo.findFinalValue(new int[] {5, 3, 6, 1, 12}, 3));
    System.out.println(
        q2154EKeepMultiplyingFoundValuesByTwo.findFinalValue(new int[] {2, 7, 9}, 4));
  }

  public int findFinalValue(int[] nums, int original) { // 4ms, beats 27.82%
    Set<Integer> set = new HashSet<>();
    for (int num : nums) set.add(num);
    int data = original;
    while (set.contains(data)) data <<= 1;
    return data;
  }
}
