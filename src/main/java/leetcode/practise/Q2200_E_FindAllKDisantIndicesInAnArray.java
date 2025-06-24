package leetcode.practise;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Vivek
 * @since 2025-06-23
 */
public class Q2200_E_FindAllKDisantIndicesInAnArray {
  public static void main(String[] args) {
    Q2200_E_FindAllKDisantIndicesInAnArray q2200EFindAllKDisantIndicesInAnArray =
        new Q2200_E_FindAllKDisantIndicesInAnArray();
    System.out.println(
        q2200EFindAllKDisantIndicesInAnArray.findKDistantIndices(
            new int[] {3, 4, 9, 1, 3, 9, 5}, 9, 1));
    System.out.println(
        q2200EFindAllKDisantIndicesInAnArray.findKDistantIndices(new int[] {2, 2, 2, 2, 2}, 2, 2));
  }

  public List<Integer> findKDistantIndices(int[] nums, int key, int k) { // 6ms, beats 73.55%
    boolean[] added = new boolean[nums.length];
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == key) {
        int start = Math.max(0, i - k);
        int end = Math.min(nums.length - 1, i + k);
        for (int j = start; j <= end; j++) added[j] = true;
      }
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) if (added[i]) result.add(i);
    return result;
  }

  public List<Integer> findKDistantIndices2(int[] nums, int key, int k) { // 90ms, beats 22.59%
    Set<Integer> data = new HashSet<>();
    List<Integer> seeds = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) if (nums[i] == key) seeds.add(i);
    for (int seed : seeds) {
      int start = Math.max(0, seed - k);
      int end = Math.min(nums.length - 1, seed + k);
      for (int j = start; j <= end; j++) data.add(j);
    }
    return data.stream().sorted().collect(Collectors.toList());
  }
}
