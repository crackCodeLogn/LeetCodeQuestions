package leetcode.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vivek
 * @since 10/12/25
 */
public class Q2273_E_FindResultantArrayAfterRemovingAnagrams {
  public static void main(String[] args) {
    Q2273_E_FindResultantArrayAfterRemovingAnagrams q2273EFindResultantArrayAfterRemovingAnagrams =
        new Q2273_E_FindResultantArrayAfterRemovingAnagrams();

    System.out.println(
        q2273EFindResultantArrayAfterRemovingAnagrams.removeAnagrams(new String[] {"a", "b", "a"}));
    System.out.println(
        q2273EFindResultantArrayAfterRemovingAnagrams.removeAnagrams(
            new String[] {"abba", "baba", "bbaa", "cd", "cd"}));
    System.out.println(
        q2273EFindResultantArrayAfterRemovingAnagrams.removeAnagrams(
            new String[] {"a", "b", "c", "d", "e"}));
  }

  public List<String> removeAnagrams(String[] words) { // 2ms, beats 93
    List<String> input = new ArrayList<>();
      Collections.addAll(input, words);
    for (int i = 0; i < input.size() - 1; i++) {
      if (isAnagram(input.get(i), input.get(i + 1))) {
        input.remove(i + 1);
        i--;
      }
    }
    return input;
  }

  private boolean isAnagram(String a, String b) {
    int[] a1 = new int[26];
    int[] b1 = new int[26];
    for (int i = 0; i < a.length(); i++) a1[a.charAt(i) - 'a']++;
    for (int i = 0; i < b.length(); i++) b1[b.charAt(i) - 'a']++;
    for (int i = 0; i < 26; i++) if (a1[i] != b1[i]) return false;
    return true;
  }
}
