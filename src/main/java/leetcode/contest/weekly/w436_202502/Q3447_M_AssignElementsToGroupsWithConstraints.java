package leetcode.contest.weekly.w436_202502;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2025-02-08
 */
public class Q3447_M_AssignElementsToGroupsWithConstraints {

  private static final Map<Integer, List<Integer>> factorsMap = new HashMap<>(); // MLE
  private static final Map<Integer, Integer> memory = new HashMap<>();

  private static List<Integer> getFactors(int n) {
    List<Integer> factors = new ArrayList<>(n / 2);
    factors.add(n);
    for (int i = 2; i * i <= n; i++)
      if (n % i == 0) {
        factors.add(i);
        if (i != n / i) factors.add(n / i);
      }
    factors.add(1);
    return factors;
  }

  public static void main(String[] args) {
    Q3447_M_AssignElementsToGroupsWithConstraints q3447MAssignElementsToGroupsWithConstraints = new Q3447_M_AssignElementsToGroupsWithConstraints();
    System.out.println("==");
    System.out.println(
        Arrays.toString(q3447MAssignElementsToGroupsWithConstraints.assignElements(new int[] {8, 4, 3, 2, 4}, new int[] {4, 2})));
    System.out.println(
        Arrays.toString(q3447MAssignElementsToGroupsWithConstraints.assignElements(new int[] {2, 3, 5, 7}, new int[] {5, 3, 3})));
    System.out.println(
        Arrays.toString(q3447MAssignElementsToGroupsWithConstraints.assignElements(new int[] {10, 21, 30, 41}, new int[] {2, 1})));
  }

  public int[] assignElements(int[] groups, int[] elements) {
    factorsMap.clear();
    memory.clear();
    int gn = groups.length, en = elements.length;
    int[] data = new int[gn];

    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < en; i++) map.putIfAbsent(elements[i], i);
    for (int i = 0; i < gn; i++) data[i] = compute(groups[i], map);
    return data;
  }

  private int compute(int group, Map<Integer, Integer> map) { // goes through
    // List<Integer> factors = factorsMap.computeIfAbsent(group, k -> getFactors(group));
    /*List<Integer> factors = getFactors(group);
    int runIndex = Integer.MAX_VALUE;
    for (Integer factor : factors)
      if (map.containsKey(factor)) runIndex = Math.min(map.get(factor), runIndex);
    return runIndex == Integer.MAX_VALUE ? -1 : runIndex;*/
    if (memory.containsKey(group)) return memory.get(group);

    int runIndex = Integer.MAX_VALUE;
    if (map.containsKey(group)) runIndex = map.get(group);
    if (map.containsKey(1)) runIndex = Math.min(map.get(1), runIndex);
    for (int i = 2; i * i <= group; i++) {
      if (group % i == 0) {
        if (map.containsKey(i)) runIndex = Math.min(map.get(i), runIndex);
        if (i != group / i && map.containsKey(group / i))
          runIndex = Math.min(map.get(group / i), runIndex);
      }
    }
    int val = runIndex == Integer.MAX_VALUE ? -1 : runIndex;
    memory.put(group, val);
    return val;
  }

  private int compute2(int group, Map<Integer, Integer> map) { // TLE
    List<Integer> factors = getFactors(group);
    int runIndex = Integer.MAX_VALUE;
    for (Integer factor : factors) {
      if (map.containsKey(factor)) {
        runIndex = Math.min(map.get(factor), runIndex);
      }
    }
    return runIndex == Integer.MAX_VALUE ? -1 : runIndex;
  }
}
