package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-11-01
 */
public class Q2490_E_CircularSentence {
  public static void main(String[] args) {
    Q2490_E_CircularSentence q2490ECircularSentence = new Q2490_E_CircularSentence();
    System.out.println(
        q2490ECircularSentence.isCircularSentence("leetcode exercises sound delightful"));
    System.out.println(q2490ECircularSentence.isCircularSentence("eetcode"));
    System.out.println(q2490ECircularSentence.isCircularSentence("Leetcode is cool"));
  }

  public boolean isCircularSentence(String sentence) {
    String[] words = sentence.split(" ");
    for (int i = 0; i < words.length; i++) {
      int next = (i + 1) % words.length;
      if (words[i].charAt(words[i].length() - 1) != words[next].charAt(0)) return false;
    }
    return true;
  }
}
