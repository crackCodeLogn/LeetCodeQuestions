package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-12-01
 */
public class Q1455_E_CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
  public static void main(String[] args) {
    Q1455_E_CheckIfAWordOccursAsAPrefixOfAnyWordInASentence
        q1455ECheckIfAWordOccursAsAPrefixOfAnyWordInASentence =
            new Q1455_E_CheckIfAWordOccursAsAPrefixOfAnyWordInASentence();
    System.out.println(
        q1455ECheckIfAWordOccursAsAPrefixOfAnyWordInASentence.isPrefixOfWord(
            "i love eating burger", "burg"));
    System.out.println(
        q1455ECheckIfAWordOccursAsAPrefixOfAnyWordInASentence.isPrefixOfWord(
            "this problem is an easy problem", "pro"));
    System.out.println(
        q1455ECheckIfAWordOccursAsAPrefixOfAnyWordInASentence.isPrefixOfWord("i am tired", "you"));
  }

  public int isPrefixOfWord(String sentence, String searchWord) {
    String[] parts = sentence.split(" ");
    int index = 1;
    for (String part : parts) {
      if (part.startsWith(searchWord)) return index;
      index++;
    }
    return -1;
  }
}
