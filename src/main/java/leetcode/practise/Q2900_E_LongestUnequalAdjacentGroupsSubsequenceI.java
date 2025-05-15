package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-05-14
 */
public class Q2900_E_LongestUnequalAdjacentGroupsSubsequenceI {

  public static void main(String[] args) {
    Q2900_E_LongestUnequalAdjacentGroupsSubsequenceI
        q2900ELongestUnequalAdjacentGroupsSubsequenceI =
            new Q2900_E_LongestUnequalAdjacentGroupsSubsequenceI();

    System.out.println(
        q2900ELongestUnequalAdjacentGroupsSubsequenceI.getLongestSubsequence(
            new String[] {"a", "b", "c", "d"}, new int[] {1, 0, 1, 1}));
    System.out.println(
        q2900ELongestUnequalAdjacentGroupsSubsequenceI.getLongestSubsequence(
            new String[] {"c"}, new int[] {0}));
    System.out.println(
        q2900ELongestUnequalAdjacentGroupsSubsequenceI.getLongestSubsequence(
            new String[] {"c", "d"}, new int[] {0, 0}));
    System.out.println(
        q2900ELongestUnequalAdjacentGroupsSubsequenceI.getLongestSubsequence(
            new String[] {"d"}, new int[] {1}));
    System.out.println(
        q2900ELongestUnequalAdjacentGroupsSubsequenceI.getLongestSubsequence(
            new String[] {"e", "a", "b"}, new int[] {0, 0, 1}));
    System.out.println(
        q2900ELongestUnequalAdjacentGroupsSubsequenceI.getLongestSubsequence(
            new String[] {"e", "a", "b"}, new int[] {1, 0, 1}));
  }

  public List<String> getLongestSubsequence(String[] words, int[] groups) { // 1ms, beats 96.15%
    List<Integer> list = new ArrayList<>(groups.length);
    int prev = groups[0];
    list.add(0);
    for (int i = 1; i < groups.length; i++) {
      if (groups[i] != prev) list.add(i);
      prev = groups[i];
    }
    List<String> res = new ArrayList<>();
    for (int ind : list) res.add(words[ind]);
    return res;
  }

  public List<String> getLongestSubsequence2(String[] words, int[] groups) { // 2ms, beats 9.92%
    List<List<Integer>> list = new ArrayList<>();
    list.add(new ArrayList<>());
    list.add(new ArrayList<>());
    for (int i = 0; i < words.length; i++) {
      if (groups[i] == 0) list.get(0).add(i);
      else list.get(1).add(i);
    }

    List<Integer> l0 = list.get(0);
    List<Integer> l1 = list.get(1);
    List<Integer> sublist1 = calc(l0, l1, true);
    List<Integer> sublist2 = calc(l0, l1, false);

    List<String> res = new ArrayList<>(Math.max(sublist1.size(), sublist2.size()));
    if (sublist1.size() >= sublist2.size()) for (int ind : sublist1) res.add(words[ind]);
    else for (int ind : sublist2) res.add(words[ind]);
    return res;
  }

  private List<Integer> calc(List<Integer> l0, List<Integer> l1, boolean flag) {
    int i = 0, j = 0, prev = -1;
    List<Integer> sublist = new ArrayList<>();
    while (i < l0.size() && j < l1.size()) {
      if (flag) { // select from l0
        while (i < l0.size() && l0.get(i) < prev) i++;
        if (i >= l0.size()) break;
        sublist.add(l0.get(i));
        prev = l0.get(i);
      } else {
        while (j < l1.size() && l1.get(j) < prev) j++;
        if (j >= l1.size()) break;
        sublist.add(l1.get(j));
        prev = l1.get(j);
      }
      flag = !flag;
    }
    if (flag) {
      if (i < l0.size()) sublist.add(l0.get(l0.size() - 1));
    } else {
      if (j < l1.size()) sublist.add(l1.get(l1.size() - 1));
    }
    return sublist;
  }
}
