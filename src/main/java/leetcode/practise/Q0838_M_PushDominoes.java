package leetcode.practise;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-05-01
 */
public class Q0838_M_PushDominoes {
  private static final char EMPTY_CHAR = '\0';
  private String dominoes;

  public static void main(String[] args) {
    Q0838_M_PushDominoes q0838MPushDominoes = new Q0838_M_PushDominoes();
    System.out.println(q0838MPushDominoes.pushDominoes("..LR.."));
    System.out.println(q0838MPushDominoes.pushDominoes("...."));
    System.out.println(q0838MPushDominoes.pushDominoes("RR.L"));
    System.out.println(q0838MPushDominoes.pushDominoes(".L.R...LR..L.."));
  }

  public String pushDominoes(String dominoes) { // 21ms, beats 57.36%
    this.dominoes = dominoes;
    int prev = -1;
    List<Node> nodes = new ArrayList<>();
    int i;
    for (i = 0; i < dominoes.length(); i++)
      if (dominoes.charAt(i) != '.') {
        nodes.add(new Node(prev, i, getChar(prev), getChar(i)));
        prev = i;
      }
    nodes.add(new Node(prev, i, getChar(prev), getChar(i)));
    if (nodes.size() == 1 && nodes.get(0).left == EMPTY_CHAR && nodes.get(0).right == EMPTY_CHAR)
      return dominoes;
    StringBuilder result = new StringBuilder(dominoes);

    for (Node node : nodes) {
      if (node.left == EMPTY_CHAR) {
        if (node.right == 'R') continue;
        for (int j = node.end() - 1; j >= 0; j--) result.setCharAt(j, 'L');
      } else if (node.right == EMPTY_CHAR) {
        if (node.left == 'L') continue;
        for (int j = node.start + 1; j < dominoes.length(); j++) result.setCharAt(j, 'R');
      } else {
        char l = node.left, r = node.right;
        if (l == 'L' && r == 'L')
          for (int j = node.start + 1; j < node.end; j++) result.setCharAt(j, 'L');
        else if (l == 'R' && r == 'R')
          for (int j = node.start + 1; j < node.end; j++) result.setCharAt(j, 'R');
        else if (l == 'R' && r == 'L') {
          for (int li = node.start, ri = node.end; li < ri; li++, ri--) {
            result.setCharAt(li, l);
            result.setCharAt(ri, r);
          }
        }
      }
    }

    return result.toString();
  }

  private char getChar(int i) {
    if (i == -1 || i == dominoes.length()) return EMPTY_CHAR;
    return dominoes.charAt(i);
  }

  private record Node(int start, int end, char left, char right) {}
}
