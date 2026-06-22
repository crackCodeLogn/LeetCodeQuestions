package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-06-21
 */
public class Q1189_E_MaximumNumberOfBalloons {

  public static void main(String[] args) {
    Q1189_E_MaximumNumberOfBalloons q1189EMaximumNumberOfBalloons =
        new Q1189_E_MaximumNumberOfBalloons();
    System.out.println(q1189EMaximumNumberOfBalloons.maxNumberOfBalloons("nlaebolko"));
    System.out.println(q1189EMaximumNumberOfBalloons.maxNumberOfBalloons("loonbalxballpoon"));
    System.out.println(q1189EMaximumNumberOfBalloons.maxNumberOfBalloons("leetcode"));
  }

  public int maxNumberOfBalloons(String text) { // 3ms, beats 70.35%
    int[] cnt = new int[128];
    for (int i = 0; i < text.length(); i++) cnt[text.charAt(i)]++;
    // b - 1, a - 1, l - 2, o - 2, n - 1
    int max = cnt['b'];
    max = Math.min(max, cnt['a']);
    max = Math.min(max, cnt['n']);
    max = Math.min(max, cnt['l'] / 2);
    max = Math.min(max, cnt['o'] / 2);
    return max;
  }
}
