package leetcode.contest.weekly.w420_202410;

/**
 * @author Vivek
 * @since 2024-10-19
 */
public class Q3325_M_CountSubstringsWithKFrequencyCharactersI {

  public static void main(String[] args) {
    Q3325_M_CountSubstringsWithKFrequencyCharactersI
        q3325MCountSubstringsWithKFrequencyCharactersI =
            new Q3325_M_CountSubstringsWithKFrequencyCharactersI();
    System.out.println(
        q3325MCountSubstringsWithKFrequencyCharactersI.numberOfSubstrings("abacb", 2)); // 4
    System.out.println(
        q3325MCountSubstringsWithKFrequencyCharactersI.numberOfSubstrings("abcde", 1)); // 15
  }

  public int numberOfSubstrings(String s, int k) {
    int cnt = 0;
    for (int i = 0; i < s.length(); i++) {
      int[] ctr = new int[26];
      for (int j = i; j < s.length(); j++) {
        ctr[s.charAt(j) - 'a']++;
        if (getCount(ctr, k)) {
          cnt += s.length() - j;
          break;
        }
      }
    }

    return cnt;
  }

  private boolean getCount(int[] ctr, int k) {
    for (int i = 0; i < ctr.length; i++) if (ctr[i] >= k) return true;
    return false;
  }
}
