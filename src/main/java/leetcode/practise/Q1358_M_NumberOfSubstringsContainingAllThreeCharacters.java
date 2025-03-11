package leetcode.practise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Vivek
 * @since 2025-03-10
 */
public class Q1358_M_NumberOfSubstringsContainingAllThreeCharacters {

  public static void main(String[] args) {
    Q1358_M_NumberOfSubstringsContainingAllThreeCharacters
        q1358MNumberOfSubstringsContainingAllThreeCharacters =
            new Q1358_M_NumberOfSubstringsContainingAllThreeCharacters();
    System.out.println(
        q1358MNumberOfSubstringsContainingAllThreeCharacters.numberOfSubstrings("abcabc"));
    System.out.println(
        q1358MNumberOfSubstringsContainingAllThreeCharacters.numberOfSubstrings("abcbac"));
    System.out.println(
        q1358MNumberOfSubstringsContainingAllThreeCharacters.numberOfSubstrings("aaabc"));
    System.out.println(
        q1358MNumberOfSubstringsContainingAllThreeCharacters.numberOfSubstrings("abc"));
  }

  public int numberOfSubstrings(String s) { // 267 ms, beats 5.61%
    int cnt = 0;
    Map<Character, TreeSet<Integer>> map = new HashMap<>();
    map.put('a', new TreeSet<>());
    map.put('b', new TreeSet<>());
    map.put('c', new TreeSet<>());
    for (int i = 0; i < s.length(); i++) map.get(s.charAt(i)).add(i);
    outer:
    for (int i = 0; i < s.length(); i++) {
      Set<Character> set = getSet();
      set.remove(s.charAt(i));
      int next = i + 1;
      int val = Integer.MAX_VALUE;
      char rem = '\0';
      for (Character c : set) {
        Integer ni = map.get(c).ceiling(next);
        if (ni == null) break outer;
        if (ni < val) {
          rem = c;
          val = ni;
        }
      }
      set.remove(rem);
      val++;
      for (Character c : set) { // just 1
        Integer ni = map.get(c).ceiling(val);
        if (ni == null) break outer;
        cnt += s.length() - ni;
      }
    }

    return cnt;
  }

  private Set<Character> getSet() {
    Set<Character> set = new HashSet<>();
    set.add('a');
    set.add('b');
    set.add('c');
    return set;
  }
}
