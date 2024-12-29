package leetcode.contest.weekly.w430_202412;

/**
 * @author Vivek
 * @since 2024-12-28
 */
public class Q3403_M_FindTheLexicographicallyLargestStringFromTheBoxI {

  public static void main(String[] args) {
    Q3403_M_FindTheLexicographicallyLargestStringFromTheBoxI
        q3403MFindTheLexicographicallyLargestStringFromTheBoxI =
            new Q3403_M_FindTheLexicographicallyLargestStringFromTheBoxI();
    System.out.println(
        q3403MFindTheLexicographicallyLargestStringFromTheBoxI.answerString("dbca", 2));
    System.out.println(
        q3403MFindTheLexicographicallyLargestStringFromTheBoxI.answerString("gggg", 4));

    System.out.println(
        q3403MFindTheLexicographicallyLargestStringFromTheBoxI.answerString("gh", 1));
    System.out.println(
        q3403MFindTheLexicographicallyLargestStringFromTheBoxI.answerString("zbyabcde", 3));
    System.out.println(
        q3403MFindTheLexicographicallyLargestStringFromTheBoxI.answerString("aann", 2));
  }

  public String answerString(String word, int k) {
    if (k == 1) return word;

    StringBuilder data = new StringBuilder();
    String comp = "";
    int n = word.length(), i, cutLen;
    for (i = n - 1; i >= k - 1; i--) {
      data.insert(0, word.charAt(i));
      if (comp.isBlank()) {
        comp = data.toString();
      } else if (data.charAt(0) >= comp.charAt(0) && data.toString().compareTo(comp) > 0) {
        comp = data.toString();
      }
    }
    for (cutLen = 1; i >= 0; i--, cutLen++) {
      data.insert(0, word.charAt(i));
      if (data.charAt(0) >= comp.charAt(0) && data.toString().compareTo(comp) > 0) {
        comp = data.substring(0, data.length() - cutLen);
      }
    }
    return comp;
  }
}
