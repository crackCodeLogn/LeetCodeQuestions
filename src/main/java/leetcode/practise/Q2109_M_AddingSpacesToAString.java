package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-12-02
 */
public class Q2109_M_AddingSpacesToAString {
  public static void main(String[] args) {
    Q2109_M_AddingSpacesToAString q2109MAddingSpacesToAString = new Q2109_M_AddingSpacesToAString();
    System.out.println(
        q2109MAddingSpacesToAString.addSpaces("LeetcodeHelpsMeLearn", new int[] {8, 13, 15}));
    System.out.println(
        q2109MAddingSpacesToAString.addSpaces("icodeinpython", new int[] {1, 5, 7, 9}));
    System.out.println(
        q2109MAddingSpacesToAString.addSpaces("spacing", new int[] {0, 1, 2, 3, 4, 5, 6}));
  }

  public String addSpaces(String s, int[] spaces) {
    StringBuilder data = new StringBuilder();
    int ptr = spaces.length - 1;
    for (int i = s.length() - 1; i >= 0; i--) {
      data.append(s.charAt(i));
      if (ptr >=0 && spaces[ptr] == i) {
        data.append(" ");
        ptr--;
      }
    }

    return data.reverse().toString();
  }
}
