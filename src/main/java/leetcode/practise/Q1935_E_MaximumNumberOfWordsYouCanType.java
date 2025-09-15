package leetcode.practise;

/**
 * @author Vivek
 * @since 9/14/25
 */
public class Q1935_E_MaximumNumberOfWordsYouCanType {

  public static void main(String[] args) {
    Q1935_E_MaximumNumberOfWordsYouCanType q1935EMaximumNumberOfWordsYouCanType =
        new Q1935_E_MaximumNumberOfWordsYouCanType();
    System.out.println(q1935EMaximumNumberOfWordsYouCanType.canBeTypedWords("hello world", "ad"));
    System.out.println(q1935EMaximumNumberOfWordsYouCanType.canBeTypedWords("leet code", "lt"));
    System.out.println(q1935EMaximumNumberOfWordsYouCanType.canBeTypedWords("leet code", "e"));
  }

  public int canBeTypedWords(String text, String brokenLetters) { // 4ms, beats 27.38%
    int cnt = 0;
    boolean[] broken = new boolean[26];
    for (int i = 0; i < brokenLetters.length(); i++) broken[brokenLetters.charAt(i) - 'a'] = true;
    for (String word : text.split(" ")) {
      boolean[] local = new boolean[26];
      for (int i = 0; i < word.length(); i++) local[word.charAt(i) - 'a'] = true;

      boolean possible = true;
      for (int i = 0; i < 26; i++)
        if (broken[i] && local[i]) {
          possible = false;
          break;
        }

      if (possible) cnt++;
    }
    return cnt;
  }
}
