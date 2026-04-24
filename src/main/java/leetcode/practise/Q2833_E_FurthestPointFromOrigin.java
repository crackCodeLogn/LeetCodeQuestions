package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-04-23
 */
public class Q2833_E_FurthestPointFromOrigin {
  public static void main(String[] args) {
    Q2833_E_FurthestPointFromOrigin q2833EFurthestPointFromOrigin =
        new Q2833_E_FurthestPointFromOrigin();
    System.out.println(q2833EFurthestPointFromOrigin.furthestDistanceFromOrigin("L_RL__R"));
    System.out.println(q2833EFurthestPointFromOrigin.furthestDistanceFromOrigin("_R__LL_"));
    System.out.println(q2833EFurthestPointFromOrigin.furthestDistanceFromOrigin("_______"));
  }

  public int furthestDistanceFromOrigin(String moves) { // 1ms, beats 100%
    return Math.max(calc(moves, 'L'), calc(moves, 'R'));
  }

  private int calc(String move, char insert) {
    int curr = 0;
    for (int i = 0; i < move.length(); i++) {
      char ch = move.charAt(i);
      if (ch == '_') ch = insert;
      curr += ch == 'L' ? -1 : 1;
    }
    return Math.abs(curr);
  }
}
