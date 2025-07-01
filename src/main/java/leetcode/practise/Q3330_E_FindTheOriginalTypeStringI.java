package leetcode.practise;

/**
 * @author Vivek
 * @since 6/30/25
 */
public class Q3330_E_FindTheOriginalTypeStringI {
  public static void main(String[] args) {
    Q3330_E_FindTheOriginalTypeStringI q3330EFindTheOriginalTypeStringI =
        new Q3330_E_FindTheOriginalTypeStringI();
    System.out.println(q3330EFindTheOriginalTypeStringI.possibleStringCount("abbcccc"));
    System.out.println(q3330EFindTheOriginalTypeStringI.possibleStringCount("abcd"));
    System.out.println(q3330EFindTheOriginalTypeStringI.possibleStringCount("aaaa"));
  }

  public int possibleStringCount(String word) { // 1ms, beats 87.19%
    int cnt = 1, curr = 1;
    char prev = word.charAt(0);
    for (int i = 1; i < word.length(); i++) {
      if (word.charAt(i) != prev) {
        cnt += curr - 1;
        curr = 1;
      } else curr++;
      prev = word.charAt(i);
    }
    cnt += curr - 1;
    return cnt;
  }
}
