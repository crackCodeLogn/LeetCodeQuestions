package leetcode.practise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-11-05
 */
public class Q3011_M_FindIfArrayCanBeSorted {
  public static void main(String[] args) {
    Q3011_M_FindIfArrayCanBeSorted q3011MFindIfArrayCanBeSorted =
        new Q3011_M_FindIfArrayCanBeSorted();
    System.out.println(q3011MFindIfArrayCanBeSorted.canSortArray(new int[] {8, 4, 2, 30, 15}));
    System.out.println(q3011MFindIfArrayCanBeSorted.canSortArray(new int[] {1, 2, 3, 4, 5}));
    System.out.println(q3011MFindIfArrayCanBeSorted.canSortArray(new int[] {3, 16, 8, 4, 2}));
  }

  public boolean canSortArray(int[] nums) { // 9ms
    int n = nums.length;
    int[] nums2 = Arrays.copyOf(nums, n);
    Arrays.sort(nums2);
    if (same(nums2, nums)) return true;

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++) map.put(nums[i], getSetBits(nums[i]));
    boolean[] visited = new boolean[n];

    for (int i = 0; i < n; i++) {
      int targetIndex = getTargetIndex(nums2, visited, nums[i]);
      int targetSetOnes = map.get(nums[i]);
      for (int j = i + 1; j <= targetIndex; j++)
        if (map.get(nums[j]) != targetSetOnes) return false;
    }
    return true;
  }

  private int getTargetIndex(int[] nums, boolean[] visited, int target) {
    for (int i = 0; i < nums.length; i++) {
      if (!visited[i] && nums[i] == target) {
        visited[i] = true;
        return i;
      }
    }
    return -1;
  }

  private boolean same(int[] a, int[] b) {
    for (int i = 0; i < a.length; i++) if (a[i] != b[i]) return false;
    return true;
  }

  private int getSetBits(int data) {
    int cnt = 0;
    while (data > 0) {
      if ((data & 1) == 1) cnt++;
      data >>= 1;
    }
    return cnt;
  }
}
