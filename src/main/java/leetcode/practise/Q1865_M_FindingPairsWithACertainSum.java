package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 7/5/25
 */
public class Q1865_M_FindingPairsWithACertainSum {

  public static void main(String[] args) {
    FindSumPairs findSumPairs =
        new FindSumPairs(new int[] {1, 1, 2, 2, 2, 3}, new int[] {1, 4, 5, 2, 5, 4});
    System.out.println(findSumPairs.count(7));
    findSumPairs.add(3, 2);
    System.out.println(findSumPairs.count(8));
    System.out.println(findSumPairs.count(4));
    findSumPairs.add(0, 1);
    findSumPairs.add(1, 1);
    System.out.println(findSumPairs.count(7));
  }

  static class FindSumPairs { // 152ms, beats 63.16%
    private final int[] nums2;
    private final Map<Integer, Integer> map1 = new HashMap<>();
    private final Map<Integer, Integer> map2 = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
      this.nums2 = nums2;

      for (int i = 0; i < nums1.length; i++) augmentCount(map1, nums1[i]);
      for (int i = 0; i < nums2.length; i++) augmentCount(map2, nums2[i]);
    }

    private static <K> void augmentCount(Map<K, Integer> mapper, K key) {
      mapper.put(key, mapper.getOrDefault(key, 0) + 1);
    }

    private static <K> void decreaseCount(Map<K, Integer> mapper, K key) {
      Integer val = mapper.get(key);
      if (val == 1) mapper.remove(key);
      else mapper.put(key, val - 1);
    }

    public void add(int index, int val) {
      decreaseCount(map2, nums2[index]);
      nums2[index] += val;
      augmentCount(map2, nums2[index]);
    }

    public int count(int tot) {
      int cnt = 0;
      for (Integer key : map1.keySet()) {
        if (map2.containsKey(tot - key)) cnt += map1.get(key) * map2.get(tot - key);
      }
      return cnt;
    }
  }
}
