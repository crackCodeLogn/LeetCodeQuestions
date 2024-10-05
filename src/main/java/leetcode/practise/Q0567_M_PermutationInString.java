package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-10-04
 */
public class Q0567_M_PermutationInString {

  public static void main(String[] args) {
    Q0567_M_PermutationInString q0567MPermutationInString = new Q0567_M_PermutationInString();
    System.out.println(q0567MPermutationInString.checkInclusion("ab", "eidbaooo"));
    System.out.println(q0567MPermutationInString.checkInclusion("ab", "eidboaoo"));
    System.out.println(q0567MPermutationInString.checkInclusion("adc", "dcda")); // true
  }

  public boolean checkInclusion(String s1, String s2) {
    int[] counter = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      char ch = s1.charAt(i);
      counter[ch - 'a']++;
    }
    int len = s1.length(), localLen = 0;

    int[] local = new int[26];
    for (int i = 0; i < s2.length(); i++) {
      char ch = s2.charAt(i);
      if (counter[ch - 'a'] == 0) {
        local = new int[26];
        localLen = 0;
        continue;
      }
      local[ch - 'a']++;
      localLen++;
      if (localLen > len) {
        local[s2.charAt(i - len) - 'a']--;
        localLen--;
      }
      if (localLen == len && isSame(local, counter)) return true;
    }
    return false;
  }

  private boolean isSame(int[] arr1, int[] arr2) {
    for (int i = 0; i < arr1.length; i++) if (arr1[i] != arr2[i]) return false;
    return true;
  }
}
