package leetcode.practise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Vivek
 * @since 2025-01-03
 */
public class Q1930_M_UniqueLength3PalindromicSubsequences {

  public static void main(String[] args) {
    Q1930_M_UniqueLength3PalindromicSubsequences q1930MUniqueLength3PalindromicSubsequences =
        new Q1930_M_UniqueLength3PalindromicSubsequences();
    System.out.println(
        q1930MUniqueLength3PalindromicSubsequences.countPalindromicSubsequence("aabca")); // 3
    System.out.println(
        q1930MUniqueLength3PalindromicSubsequences.countPalindromicSubsequence("adc")); // 0
    System.out.println(
        q1930MUniqueLength3PalindromicSubsequences.countPalindromicSubsequence("bbcbaba")); // 4
    System.out.println(
        q1930MUniqueLength3PalindromicSubsequences.countPalindromicSubsequence("bbcbaaba")); // 5
  }

  public int countPalindromicSubsequence(String s) { // 201ms, beats 53.40%
    int cnt = 0;
    int[][] data = new int[26][2];
    for (int i = 0; i < 26; i++) data[i] = new int[] {-1, -1};

    for (int i = 0; i < s.length(); i++) {
      int ch = s.charAt(i) - 'a';
      if (data[ch][0] == -1) data[ch][0] = i;
      else data[ch][1] = i;
    }

    Set<Character> set = new HashSet<>();
    for (int i = 0; i < 26; i++) {
      set.clear();
      for (int j = data[i][0] + 1; j <= data[i][1] - 1; j++) set.add(s.charAt(j));
      cnt += set.size();
    }

    return cnt;
  }

  public int countPalindromicSubsequence2(String data) { // 210ms, beats 43.45%
    int cnt = 0;
    Map<Character, int[]> map = new HashMap<>();
    for (int i = 0; i < data.length(); i++) {
      char ch = data.charAt(i);
      if (map.containsKey(ch)) {
        map.get(ch)[1] = i;
      } else {
        map.put(ch, new int[] {i, -1});
      }
    }
    Set<Character> set = new HashSet<>();
    for (Character ch : map.keySet()) {
      set.clear();
      int[] arr = map.get(ch);
      int start = arr[0], end = arr[1];
      if (start == end || start + 1 == end) continue;

      for (int i = start + 1; i <= end - 1; i++) set.add(data.charAt(i));
      cnt += set.size();
    }

    return cnt;
  }
}
