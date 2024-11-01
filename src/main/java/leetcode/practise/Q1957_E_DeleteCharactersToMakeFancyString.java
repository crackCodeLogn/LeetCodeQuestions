package leetcode.practise;


/**
 * @author Vivek
 * @since 2024-10-31
 */
public class Q1957_E_DeleteCharactersToMakeFancyString {
  public static void main(String[] args) {
    Q1957_E_DeleteCharactersToMakeFancyString q1957EDeleteCharactersToMakeFancyString =
        new Q1957_E_DeleteCharactersToMakeFancyString();
    System.out.println(q1957EDeleteCharactersToMakeFancyString.makeFancyString("leeetcode"));
    System.out.println(q1957EDeleteCharactersToMakeFancyString.makeFancyString("aaabaaaa"));
    System.out.println(q1957EDeleteCharactersToMakeFancyString.makeFancyString("aab"));
  }

  public String makeFancyString(String s) {
    StringBuilder data = new StringBuilder();
    int cnt = 1;
    data.append(s.charAt(0));
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) cnt++;
      else cnt = 1;
      if (cnt < 3) data.append(s.charAt(i));
    }
    return data.toString();
  }
}
