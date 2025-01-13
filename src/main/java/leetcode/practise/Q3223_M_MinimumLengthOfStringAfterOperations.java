package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-01-12
 */
public class Q3223_M_MinimumLengthOfStringAfterOperations {

  public static void main(String[] args) {
    Q3223_M_MinimumLengthOfStringAfterOperations q3223_m_minimumLengthOfStringAfterOperations =
        new Q3223_M_MinimumLengthOfStringAfterOperations();
    System.out.println(
        q3223_m_minimumLengthOfStringAfterOperations.minimumLength(
            "ucvbutgkohgbcobqeyqwppbxqoynxeuuzouyvmydfhrprdbuzwqebwuiejoxsxdhbmuaiscalnteocghnlisxxawxgcjloevrdcj")); // 38
    System.out.println(q3223_m_minimumLengthOfStringAfterOperations.minimumLength("abaacbcbb"));
    System.out.println(q3223_m_minimumLengthOfStringAfterOperations.minimumLength("aa"));
  }

  public int minimumLength(String s) {
    int[] count = new int[26];
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) count[s.charAt(i) - 'a']++;
    for (int i = 0; i < 26; i++) {
      while (count[i] >= 3) count[i] -= 2;
      cnt += count[i];
    }
    return cnt;
  }
}
