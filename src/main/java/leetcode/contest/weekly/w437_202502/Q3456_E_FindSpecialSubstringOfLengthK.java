package leetcode.contest.weekly.w437_202502;

/**
 * @author Vivek
 * @since 2025-02-15
 */
public class Q3456_E_FindSpecialSubstringOfLengthK {

  public static void main(String[] args) {
    Q3456_E_FindSpecialSubstringOfLengthK q3456EFindSpecialSubstringOfLengthK =
        new Q3456_E_FindSpecialSubstringOfLengthK();
    System.out.println(q3456EFindSpecialSubstringOfLengthK.hasSpecialSubstring("ii", 1));
    System.out.println(q3456EFindSpecialSubstringOfLengthK.hasSpecialSubstring("jkjhfgg", 2));
    System.out.println(q3456EFindSpecialSubstringOfLengthK.hasSpecialSubstring("h", 1));
    System.out.println(q3456EFindSpecialSubstringOfLengthK.hasSpecialSubstring("aaabaaa", 3));
    System.out.println(q3456EFindSpecialSubstringOfLengthK.hasSpecialSubstring("abc", 2));
  }

  public boolean hasSpecialSubstring(String s, int k) {

    int n = s.length();
    for (int i = 0; i <= n - k; i++) {
      char target = s.charAt(i);
      boolean flag = true;
      int j = i + 1;
      for (; j < n && j < i + k; j++) {
        if (s.charAt(j) != target) {
          flag = false;
          break;
        }
      }
      if (flag && (i == 0 || s.charAt(i - 1) != target) && (j == n || s.charAt(j) != target))
        return true;
    }
    return false;
  }
}
