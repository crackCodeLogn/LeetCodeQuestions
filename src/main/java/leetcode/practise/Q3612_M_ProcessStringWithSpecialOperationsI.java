package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-06-15
 */
public class Q3612_M_ProcessStringWithSpecialOperationsI {

  public static void main(String[] args) {
    Q3612_M_ProcessStringWithSpecialOperationsI q3612MProcessStringWithSpecialOperationsI =
        new Q3612_M_ProcessStringWithSpecialOperationsI();
    System.out.println(q3612MProcessStringWithSpecialOperationsI.processStr("a#b%*"));
    System.out.println(q3612MProcessStringWithSpecialOperationsI.processStr("z*#"));
  }

  public String processStr(String s) { // 3ms, beats 100%
    StringBuilder data = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (ch == '*') {
        if (!data.isEmpty()) data.deleteCharAt(data.length() - 1);
      } else if (ch == '#') data.append(data);
      else if (ch == '%') data.reverse();
      else data.append(ch);
    }

    return data.toString();
  }
}
