package leetcode.contest.weekly.w422_202411;

/**
 * @author Vivek
 * @since 2024-11-02
 */
public class Q3340_E_CheckBalancedString {

  public static void main(String[] args) {
    Q3340_E_CheckBalancedString q3340ECheckBalancedString = new Q3340_E_CheckBalancedString();
    System.out.println(q3340ECheckBalancedString.isBalanced("1234"));
    System.out.println(q3340ECheckBalancedString.isBalanced("24123"));
  }

  public boolean isBalanced(String num) {
    int s1 = 0, s2 = 0;
    for (int i = 0; i < num.length(); i++) {
      if (i % 2 == 0) s1 += num.charAt(i) - '0';
      else s2 += num.charAt(i) - '0';
    }
    return s1 == s2;
  }
}
