package leetcode.contest.weekly.w435_202502;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Vivek
 * @since 2025-02-01
 */
public class Q3443_M_MaximumManhattanDistanceAfterKChanges_WA {

  private static final int[] X_4W = {0, 1, 0, -1}; // S, E, N, W
  private static final int[] Y_4W = {1, 0, -1, 0}; // S, E, N, W
  int max;

  public static void main(String[] args) {
    Q3443_M_MaximumManhattanDistanceAfterKChanges_WA q3443MMaximumManhattanDistanceAfterKChangesWA =
        new Q3443_M_MaximumManhattanDistanceAfterKChanges_WA();
    System.out.println(q3443MMaximumManhattanDistanceAfterKChangesWA.maxDistance("NWSE", 1)); // 3
    System.out.println(q3443MMaximumManhattanDistanceAfterKChangesWA.maxDistance("WEWE", 1)); // 3
    System.out.println(q3443MMaximumManhattanDistanceAfterKChangesWA.maxDistance("NSWWEW", 3)); // 6
    System.out.println(q3443MMaximumManhattanDistanceAfterKChangesWA.maxDistance("EWWE", 0)); // 1
    System.out.println(q3443MMaximumManhattanDistanceAfterKChangesWA.maxDistance("SNWSE", 3)); // 5
  }

  private Set<Character> remnant(char ch) {
    Set<Character> set = new HashSet<>();
    set.add('N');
    set.add('S');
    set.add('E');
    set.add('W');
    set.remove(ch);
    return set;
  } /*

    private int compute(char[] data, int index, int i, int j, int k) {
      if (index >= data.length) return 0;

      char ch = data[index];
      int v1;
      if (ch == 'N') j--;
      else if (ch == 'S') j++;
      else if (ch == 'E') i++;
      else i--;
      max = Math.max(max, Math.abs(i) + Math.abs(j));

      if (k > 0) {

      }
    }*/

  private char anti(char ch) {
    if (ch == 'N') return 'S';
    if (ch == 'S') return 'N';
    if (ch == 'E') return 'W';
    return 'E';
  }

  private Pair orthg(char ch) {
    if (ch == 'N' || ch == 'S') return new Pair('W', 'E');
    return new Pair('N', 'S');
  }

  public int maxDistance(String s, int k) {
    if (k == s.length()) return s.length();

    max = 0;
    int[] counts = new int[4];
    Map<Character, Integer> map = new HashMap<>();
    map.put('N', 0);
    map.put('W', 1);
    map.put('E', 2);
    map.put('S', 3);

    int n = s.length();
    for (int i = 0; i < n; i++) counts[map.get(s.charAt(i))]++;
    char[] data = s.toCharArray();
    int x = 0, y = 0;
    char ch = data[0];
    if (ch == 'N') y--;
    else if (ch == 'S') y++;
    else if (ch == 'E') x++;
    else x--;
    max = Math.max(max, Math.abs(x) + Math.abs(y));
    Set<Character> visited = new HashSet<>();
    visited.add(ch);

    for (int i = 1; i < n; i++) {
      ch = data[i];
      char anti = anti(ch);
      if (visited.contains(anti) && k > 0) {
        Pair orthg = orthg(anti);
        if (counts[map.get(orthg.ch1)] >= counts[map.get(orthg.ch2)]) {
          data[i] = orthg.ch1;
          counts[map.get(orthg.ch1)]++;
        } else {
          data[i] = orthg.ch2;
          counts[map.get(orthg.ch2)]++;
        }
        k--;
      }
      ch = data[i];
      visited.add(ch);
      if (ch == 'N') y--;
      else if (ch == 'S') y++;
      else if (ch == 'E') x++;
      else x--;
      max = Math.max(max, Math.abs(x) + Math.abs(y));
    }
    return max;
  }

  /*int x = 0, y = 0, max = 0;
  for (int i = 0; i < data.length; i++) {
    char ch = data[i];
    if (ch == 'N') y--;
    else if (ch == 'S') y++;
    else if (ch == 'E') x++;
    else x--;
    max = Math.max(max, Math.abs(x) + Math.abs(y));
  }*/

  /*
    int max = 0;
    while (k-- > 0) {
      boolean change = false;
      if (counts[map.get('N')] >= counts[map.get('S')] && counts[map.get('S')] > 0) {
        counts[map.get('N')]++;
        counts[map.get('S')]--;
        change = true;
      } else if (counts[map.get('S')] >= counts[map.get('N')] && counts[map.get('N')] > 0) {
        counts[map.get('S')]++;
        counts[map.get('W')]--;
        change = true;
      } else if (counts[map.get('W')] >= counts[map.get('E')] && counts[map.get('E')] > 0) {
        counts[map.get('W')]++;
        counts[map.get('E')]--;
        change = true;
      } else if (counts[map.get('E')] >= counts[map.get('W')] && counts[map.get('W')] > 0) {
        counts[map.get('E')]++;
        counts[map.get('W')]--;
        change = true;
      }
      if (!change) break;
    }
    int i = 0, j = 0;
    if (counts[map.get('N')] > 0) {
      j += counts[map.get('N')];
      max = Math.max(max, j);
    }
    if (counts[map.get('W')] > 0) {
      i -= counts[map.get('W')];
      max = Math.max(max, Math.abs(i) + Math.abs(j));
    }
    if (counts[map.get('E')] > 0) {
      i += counts[map.get('E')];
      max = Math.max(max, Math.abs(i) + Math.abs(j));
    }
    if (counts[map.get('S')] > 0) {
      j -= counts[map.get('S')];
      max = Math.max(max, Math.abs(i) + Math.abs(j));
    }
    return max;
  }*/

  record Pair(char ch1, char ch2) {}
}
