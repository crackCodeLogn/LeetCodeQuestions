package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-10-07
 */
public class Q1963_M_MinimumNumberOfSwapsToMakeTheStringBalanced {

  public static void main(String[] args) {
    Q1963_M_MinimumNumberOfSwapsToMakeTheStringBalanced
        q1963MMinimumNumberOfSwapsToMakeTheStringBalanced =
            new Q1963_M_MinimumNumberOfSwapsToMakeTheStringBalanced();
    System.out.println(q1963MMinimumNumberOfSwapsToMakeTheStringBalanced.minSwaps("][]["));
    System.out.println(q1963MMinimumNumberOfSwapsToMakeTheStringBalanced.minSwaps("]]][[["));
    System.out.println(q1963MMinimumNumberOfSwapsToMakeTheStringBalanced.minSwaps("[]"));
  }

  public int minSwaps(String s) {
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '[') cnt++;
      else if (cnt > 0) cnt--;
    }
    return (int) Math.ceil(cnt / 2.0);
  }
}
