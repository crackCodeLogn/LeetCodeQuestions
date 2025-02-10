package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-02-09
 */
public class Q3174_E_ClearDigits {

  public static void main(String[] args) {
    Q3174_E_ClearDigits q3174EClearDigits = new Q3174_E_ClearDigits();
    System.out.println(q3174EClearDigits.clearDigits("abc"));
    System.out.println(q3174EClearDigits.clearDigits("cb34"));
    System.out.println(q3174EClearDigits.clearDigits(""));
    System.out.println(q3174EClearDigits.clearDigits("1234"));
  }

  public String clearDigits(String s) { // 1ms, beats 100%
    StringBuilder data = new StringBuilder(s);
    while (true) {
      int n = data.length();
      boolean flag = true;
      for (int i = 0; i < n; i++) {
        char ch = data.charAt(i);
        if (ch >= '0' && ch <= '9') {
          flag = false;
          data.deleteCharAt(i);
          if (i > 0) data.deleteCharAt(i - 1);
          break;
        }
      }
      if (flag) break;
    }
    return data.toString();
  }
}
