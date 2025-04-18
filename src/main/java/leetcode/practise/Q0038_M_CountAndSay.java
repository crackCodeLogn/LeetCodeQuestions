package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-04-17
 */
public class Q0038_M_CountAndSay {
  public static void main(String[] args) {
    Q0038_M_CountAndSay q0038MCountAndSay = new Q0038_M_CountAndSay();
    System.out.println(q0038MCountAndSay.countAndSay(5));
    System.out.println(q0038MCountAndSay.countAndSay(4));
    System.out.println(q0038MCountAndSay.countAndSay(1));
  }

  public String countAndSay(int n) { // 1ms, beats 99.58%
    if (n == 1) return "1";
    String val = countAndSay(n - 1);
    return rle(val);
  }

  private String rle(String data) {
    StringBuilder sb = new StringBuilder();
    char ch = data.charAt(0);
    int count = 1;
    for (int i = 1; i < data.length(); i++) {
      if (ch == data.charAt(i)) count++;
      else {
        sb.append(count).append(ch);
        count = 1;
      }
      ch = data.charAt(i);
    }
    sb.append(count).append(ch);
    return sb.toString();
  }
}
