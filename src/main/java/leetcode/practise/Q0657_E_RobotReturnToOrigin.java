package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-04-06
 */
public class Q0657_E_RobotReturnToOrigin {
  public static void main(String[] args) {
    Q0657_E_RobotReturnToOrigin q0657ERobotReturnToOrigin = new Q0657_E_RobotReturnToOrigin();
    System.out.println(q0657ERobotReturnToOrigin.judgeCircle("UD"));
    System.out.println(q0657ERobotReturnToOrigin.judgeCircle("LL"));
  }

  public boolean judgeCircle(String moves) { // 6ms, beats 49.49%
    int x = 0, y = 0;
    for (int i = 0; i < moves.length(); i++) {
      char ch = moves.charAt(i);
      if (ch == 'R') x++;
      else if (ch == 'L') x--;
      else if (ch == 'U') y--;
      else y++;
    }
    return x == 0 && y == 0;
  }
}
