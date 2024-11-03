package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-11-02
 */
public class Q0796_E_RotateString {

  public static void main(String[] args) {
    Q0796_E_RotateString q0796ERotateString = new Q0796_E_RotateString();
    System.out.println(q0796ERotateString.rotateString("abcde", "cdeab"));
    System.out.println(q0796ERotateString.rotateString("abcde", "abced"));
    System.out.println(q0796ERotateString.rotateString("aa", "a"));
  }

  public boolean rotateString(String s, String goal) {
    if (s.length() != goal.length()) return false;
    s += s;
    return s.contains(goal);
  }
}
