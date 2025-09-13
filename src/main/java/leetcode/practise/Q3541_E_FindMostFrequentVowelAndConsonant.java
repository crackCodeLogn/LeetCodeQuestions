package leetcode.practise;

/**
 * @author Vivek
 * @since 9/12/25
 */
public class Q3541_E_FindMostFrequentVowelAndConsonant {
  public static void main(String[] args) {
    Q3541_E_FindMostFrequentVowelAndConsonant q3541EFindMostFrequentVowelAndConsonant =
        new Q3541_E_FindMostFrequentVowelAndConsonant();
    System.out.println(q3541EFindMostFrequentVowelAndConsonant.maxFreqSum("successes"));
    System.out.println(q3541EFindMostFrequentVowelAndConsonant.maxFreqSum("aeiaeia"));
  }

  public int maxFreqSum(String s) { // 1ms, beats 100%
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i++) freq[s.charAt(i) - 'a']++;
    int con = 0, vow = 0;
    vow = Math.max(vow, freq[0]);
    vow = Math.max(vow, freq['e' - 'a']);
    vow = Math.max(vow, freq['i' - 'a']);
    vow = Math.max(vow, freq['o' - 'a']);
    vow = Math.max(vow, freq['u' - 'a']);
    for (char ch = 'b'; ch <= 'z'; ch++) {
      if (isVowel(ch)) continue;
      con = Math.max(con, freq[ch - 'a']);
    }
    return con + vow;
  }

  private boolean isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E'
        || ch == 'I' || ch == 'O' || ch == 'U';
  }
}
