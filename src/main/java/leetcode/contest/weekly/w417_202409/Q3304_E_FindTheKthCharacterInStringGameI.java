package leetcode.contest.weekly.w417_202409;

/**
 * @author Vivek
 * @since 2024-09-28
 */
public class Q3304_E_FindTheKthCharacterInStringGameI {

  public static void main(String[] args) {
    Q3304_E_FindTheKthCharacterInStringGameI q3304EFindTheKthCharacterInStringGameI =
        new Q3304_E_FindTheKthCharacterInStringGameI();
    System.out.println(q3304EFindTheKthCharacterInStringGameI.kthCharacter(5));
    System.out.println(q3304EFindTheKthCharacterInStringGameI.kthCharacter(10));
  }

  public char kthCharacter(int k) {
    StringBuilder data = new StringBuilder("a");

    while (data.length() < k) {
      StringBuilder d2 = new StringBuilder();
      for (int i = 0; i < data.length(); i++) {
        char ch = data.charAt(i);
        ch = ch == 'z' ? 'a' : ++ch;
        d2.append(ch);
      }
      data.append(d2);
      // System.out.println(data);
    }
    return data.charAt(k - 1);
  }
}
