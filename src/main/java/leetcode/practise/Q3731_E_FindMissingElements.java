package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Vivek
 * @since 2026-08-03
 */
public class Q3731_E_FindMissingElements {
  public List<Integer> findMissingElements(int[] nums) {
    List<Integer> data = new ArrayList<>();
    Set<Integer> set = new HashSet<>();
    for (Integer v : nums) set.add(v);

    Arrays.sort(nums);
    int n = nums.length;
    for (int i = nums[0]; i <= nums[n - 1]; i++) if (!set.contains(i)) data.add(i);
    return data;
  }

  public static void main(String[] args) {
    Q3731_E_FindMissingElements q3731EFindMissingElements = new Q3731_E_FindMissingElements();
    System.out.println(q3731EFindMissingElements.findMissingElements(new int[] {1, 4, 2, 5}));
    System.out.println(q3731EFindMissingElements.findMissingElements(new int[] {7, 8, 6, 9}));
    System.out.println(q3731EFindMissingElements.findMissingElements(new int[] {5, 1}));
  }
}
