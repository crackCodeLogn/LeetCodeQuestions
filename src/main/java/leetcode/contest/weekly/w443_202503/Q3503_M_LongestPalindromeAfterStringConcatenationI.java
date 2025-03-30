package leetcode.contest.weekly.w443_202503;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Vivek
 * @since 2025-03-29
 */
public class Q3503_M_LongestPalindromeAfterStringConcatenationI {

  public static void main(String[] args) {
    Q3503_M_LongestPalindromeAfterStringConcatenationI
        q3503MLongestPalindromeAfterStringConcatenationI =
            new Q3503_M_LongestPalindromeAfterStringConcatenationI();
    System.out.println(
        q3503MLongestPalindromeAfterStringConcatenationI.longestPalindrome("a", "t"));
    System.out.println(
        q3503MLongestPalindromeAfterStringConcatenationI.longestPalindrome("a", "a"));
    System.out.println(
        q3503MLongestPalindromeAfterStringConcatenationI.longestPalindrome("abc", "def"));
    System.out.println(
        q3503MLongestPalindromeAfterStringConcatenationI.longestPalindrome("b", "aaaa"));
    System.out.println(
        q3503MLongestPalindromeAfterStringConcatenationI.longestPalindrome("abcde", "ecdba"));
  }

  public int longestPalindrome(String s, String t) {
    Set<String> c1 = new HashSet<>();
    Set<String> c2 = new HashSet<>();
    Set<String> seen = new HashSet<>();
    int maxLen = 1;
    for (int i = 0; i < s.length(); i++)
      for (int j = i + 1; j <= s.length(); j++) {
        String sub = s.substring(i, j);
        c1.add(sub);
        if (isPalindrome(sub) && sub.length() > maxLen) maxLen = sub.length();
        seen.add(sub);
      }
    for (int i = 0; i < t.length(); i++)
      for (int j = i + 1; j <= t.length(); j++) {
        String sub = t.substring(i, j);
        c2.add(sub);
        if (isPalindrome(sub) && sub.length() > maxLen) maxLen = sub.length();
        seen.add(sub);
      }

    for (String s1 : c1) {
      for (String s2 : c2) {
        String comb = s1 + s2;
        if (!seen.contains(comb) && comb.length() > maxLen && isPalindrome(comb))
          maxLen = comb.length();
      }
    }
    return maxLen;
  }

  private boolean isPalindrome(String s) {
    for (int i = 0; i < s.length() / 2; i++)
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
    return true;
  }
}
