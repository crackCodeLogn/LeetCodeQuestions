package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2025-02-05
 */
public class Q1726_M_TupleWithSameProduct {

  public static void main(String[] args) {
    Q1726_M_TupleWithSameProduct q1726MTupleWithSameProduct = new Q1726_M_TupleWithSameProduct();
    System.out.println(q1726MTupleWithSameProduct.tupleSameProduct(new int[] {2, 3, 4, 6}));
    System.out.println(q1726MTupleWithSameProduct.tupleSameProduct(new int[] {1, 2, 4, 5, 10}));
  }

  public int tupleSameProduct(int[] nums) { // 175 ms, beats 88.46%
    int cnt = 0, n = nums.length;
    Map<Integer, Integer> countMap = new HashMap<>();
    for (int i = 0; i < n; i++)
      for (int j = i + 1; j < n; j++) {
        int p = nums[i] * nums[j];
        countMap.put(p, countMap.getOrDefault(p, 0) + 1);
      }
    for (int values : countMap.values()) cnt += 2 * values * (values - 1);
    return cnt * 2;
  }
}
