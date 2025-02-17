package leetcode.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Vivek
 * @since 2025-02-16
 */
public class Q1079_M_LetterTilePossibilities {

  private static final int[] factorials = new int[8];

  private static <T> List<List<T>> extractPowerSets(List<T> data) {
    int upper = 1 << data.size();
    List<List<T>> powerSets = new ArrayList<>(upper);
    for (int i = -1; ++i < upper; ) {
      List<T> powerSet = new LinkedList<>();
      for (int j = 0; j < data.size(); j++) if ((i & (1 << j)) > 0) powerSet.add(data.get(j));
      powerSets.add(powerSet);
    }
    return powerSets;
  }

  public static void main(String[] args) {
    Q1079_M_LetterTilePossibilities q1079MLetterTilePossibilities =
        new Q1079_M_LetterTilePossibilities();
    System.out.println(q1079MLetterTilePossibilities.numTilePossibilities("ACAB"));
    System.out.println(q1079MLetterTilePossibilities.numTilePossibilities("AAB"));
    System.out.println(q1079MLetterTilePossibilities.numTilePossibilities("AAABBC"));
    System.out.println(q1079MLetterTilePossibilities.numTilePossibilities("V"));
  }

  public int numTilePossibilities(String tiles) { // 8ms, beats 57.55%
    if (factorials[7] == 0) computeFactorials();
    List<Character> chars = new ArrayList<>(tiles.length());
    for (char ch : tiles.toCharArray()) chars.add(ch);

    Set<List<Character>> set = new HashSet<>();
    List<List<Character>> tilePossibilities = extractPowerSets(chars);
    for (List<Character> data : tilePossibilities) {
      if (data.isEmpty()) continue;
      Collections.sort(data);
      set.add(data);
    }

    int cnt = 0;
    for (List<Character> data : set) {
      Map<Character, Integer> counts = new HashMap<>();
      for (Character ch : data) counts.put(ch, counts.getOrDefault(ch, 0) + 1);
      int val = factorials[data.size()];
      for (Integer count : counts.values()) val /= factorials[count];
      cnt += val;
    }
    return cnt;
  }

  private void computeFactorials() {
    factorials[0] = 1;
    for (int i = 1; i <= 7; i++) factorials[i] = factorials[i - 1] * i;
  }
}
