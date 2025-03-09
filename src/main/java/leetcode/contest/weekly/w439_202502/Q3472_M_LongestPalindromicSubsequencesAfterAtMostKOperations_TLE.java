package leetcode.contest.weekly.w439_202502;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-03-01
 */
public class Q3472_M_LongestPalindromicSubsequencesAfterAtMostKOperations_TLE {

  private static final List<Character> chars = new ArrayList<>(26 * 3);
  private static final int[][] dp = new int[26][26];
  private int max;
  private int k;

  public static void main(String[] args) {
    Q3472_M_LongestPalindromicSubsequencesAfterAtMostKOperations_TLE
        q3472MLongestPalindromicSubsequencesAfterAtMostKOperationsTLE =
            new Q3472_M_LongestPalindromicSubsequencesAfterAtMostKOperations_TLE();
    System.out.println(
        q3472MLongestPalindromicSubsequencesAfterAtMostKOperationsTLE.longestPalindromicSubsequence(
            "hoioozhegpwaqebwlndo", 16));
    System.out.println(
        q3472MLongestPalindromicSubsequencesAfterAtMostKOperationsTLE.longestPalindromicSubsequence(
            "mndpedekzrh", 18)); // 11
    System.out.println(
        q3472MLongestPalindromicSubsequencesAfterAtMostKOperationsTLE.longestPalindromicSubsequence(
            "wehzr", 3)); // 3
    System.out.println(
        q3472MLongestPalindromicSubsequencesAfterAtMostKOperationsTLE.longestPalindromicSubsequence(
            "brhy", 8)); // 3
    System.out.println(
        q3472MLongestPalindromicSubsequencesAfterAtMostKOperationsTLE.longestPalindromicSubsequence(
            "abced", 2)); // 3
    System.out.println(
        q3472MLongestPalindromicSubsequencesAfterAtMostKOperationsTLE.longestPalindromicSubsequence(
            "aaazzz", 4)); // 6
  }

  public int longestPalindromicSubsequence(String s, int k) {
    if (chars.isEmpty()) {
      int n = 3;
      while (n-- > 0) for (char ch = 'a'; ch <= 'z'; ch++) chars.add(ch);
      for (int i = 0; i < 26; i++) for (int j = 0; j < 26; j++) dp[i][j] = -1;
    }
    max = 1;
    this.k = k;
    // permute(s, "");
    List<Character> list = new ArrayList<>();
    for (char ch : s.toCharArray()) list.add(ch);
    extractPowerSets(list);

    return max;
  }

  private void extractPowerSets(List<Character> data) {
    int upper = 1 << data.size();
    for (int i = -1; ++i < upper; ) {
      List<Character> powerSet = new LinkedList<>();
      for (int j = 0; j < data.size(); j++) if ((i & (1 << j)) > 0) powerSet.add(data.get(j));
      if (powerSet.size() > max) {
        StringBuilder d = new StringBuilder();
        for (char ch : powerSet) d.append(ch);
        int v = compute(d.toString(), k);
        max = Math.max(max, v);
      }
    }
  }

  /*public String print(String s , int i){
    int j = 0;
    String sub = "";
    while(i>0){
      if((i & 1) == 1) sub += s.charAt(j);
      j++;
      i = i>>1;
    }
    return sub;
  }

  public List<String> permute(String s){
    List<String> res = new ArrayList<>();
    for(int i = 0 ; i < (1<<s.length()) ; i++){
      res.add(print(s,i));
    }
    return res;
  }*/

  private void permute(String s, String a) {
    if (s.isEmpty()) {
      if (a.length() > max) {
        int v = compute(a, k);
        max = Math.max(max, v);
      }
      return;
    }
    permute(s.substring(1), a + s.charAt(0));
    permute(s.substring(1), a);
  }

  private int compute(String data, int k) {
    int i, j;
    for (i = 0, j = data.length() - 1; i < j && k >= 0; i++, j--) {
      int distance = getDistance(data.charAt(i), data.charAt(j));
      if (distance > k) return -1;
      k -= distance;
    }
    if (i >= j) return data.length();
    return -1;
  }

  private int getDistance(char c1, char c2) {
    if (dp[c1 - 'a'][c2 - 'a'] > 0) return dp[c1 - 'a'][c2 - 'a'];
    int index = 26 + (c1 - 'a'); // 'a' 2nd
    int d1 = 0, d2 = 0;
    for (int i = index; chars.get(i) != c2; i++, d1++)
      ;
    for (int i = index; chars.get(i) != c2; i--, d2++)
      ;
    int v = Math.min(d1, d2);
    dp[c1 - 'a'][c2 - 'a'] = v;
    return v;
  }
}
