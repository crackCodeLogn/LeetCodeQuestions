package leetcode.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-05-03
 */
public class Q1128_E_NumberOfEquivalentDominoPairs {

  public static void main(String[] args) {
    Q1128_E_NumberOfEquivalentDominoPairs q1128ENumberOfEquivalentDominoPairs =
        new Q1128_E_NumberOfEquivalentDominoPairs();
    System.out.println(
        q1128ENumberOfEquivalentDominoPairs.numEquivDominoPairs(
            new int[][] {
              {1, 2},
              {2, 1},
              {3, 4},
              {6, 5},
            }));
    System.out.println(
        q1128ENumberOfEquivalentDominoPairs.numEquivDominoPairs(
            new int[][] {
              {1, 2},
              {2, 1},
              {1, 1},
              {1, 2},
              {2, 2}
            }));
  }

  // need to find a simpler solution than this, as its an easy problem
  public int numEquivDominoPairs(int[][] dominoes) { // 16ms, beats 37.40%
    int cnt = 0;
    List<Node> nodes = new ArrayList<>(dominoes.length);
    for (int[] domino : dominoes) {
      if (domino[0] < domino[1]) nodes.add(new Node(domino[0], domino[1]));
      else nodes.add(new Node(domino[1], domino[0]));
    }
    Collections.sort(nodes);
    Node prev = nodes.get(0);
    int run = 1;
    for (int i = 1; i < nodes.size(); i++) {
      Node node = nodes.get(i);
      if (node.a == prev.a && node.b == prev.b) run++;
      else {
        cnt += nc2(run);
        run = 1;
      }
      prev = node;
    }

    return cnt + nc2(run);
  }

  private int nc2(int n) {
    return n * (n - 1) / 2;
  }

  public int numEquivDominoPairs2(int[][] dominoes) { // tle
    int cnt = 0;
    for (int i = 0; i < dominoes.length; i++) {
      for (int j = i + 1; j < dominoes.length; j++) {
        if ((dominoes[i][0] == dominoes[j][0] && dominoes[i][1] == dominoes[j][1])
            || (dominoes[i][0] == dominoes[j][1] && dominoes[i][1] == dominoes[j][0])) cnt++;
      }
    }
    return cnt;
  }

  private record Node(int a, int b) implements Comparable<Node> {
    @Override
    public int compareTo(Node o) {
      if (this.a != o.a) return this.a - o.a;
      return this.b - o.b;
    }
  }
}
