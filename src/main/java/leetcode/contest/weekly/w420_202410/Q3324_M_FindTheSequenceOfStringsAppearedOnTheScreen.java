package leetcode.contest.weekly.w420_202410;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-10-19
 */
public class Q3324_M_FindTheSequenceOfStringsAppearedOnTheScreen {

  public static void main(String[] args) {
    Q3324_M_FindTheSequenceOfStringsAppearedOnTheScreen
        q3324MFindTheSequenceOfStringsAppearedOnTheScreen =
            new Q3324_M_FindTheSequenceOfStringsAppearedOnTheScreen();
    System.out.println(q3324MFindTheSequenceOfStringsAppearedOnTheScreen.stringSequence("abc"));
    System.out.println(q3324MFindTheSequenceOfStringsAppearedOnTheScreen.stringSequence("he"));
  }

  public List<String> stringSequence(String target) {
    List<String> data = new ArrayList<>();
    StringBuilder sb = new StringBuilder("a");
    data.add("a");
    while (true) {
      char ch = sb.charAt(sb.length() - 1);
      if (ch == target.charAt(sb.length() - 1)) {
        if (sb.toString().equals(target)) break;
        sb.append("a");
      } else {
        sb.setCharAt(sb.length() - 1, getNext(ch));
      }
      data.add(sb.toString());
    }

    return data;
  }

  private char getNext(char ch) {
    ch++;
    if (ch == 'z' + 1) ch = 'a';
    return ch;
  }
}
