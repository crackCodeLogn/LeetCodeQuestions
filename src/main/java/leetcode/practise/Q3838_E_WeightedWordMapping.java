package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-06-12
 */
public class Q3838_E_WeightedWordMapping {

  public static void main(String[] args) {
    Q3838_E_WeightedWordMapping q3838EWeightedWordMapping = new Q3838_E_WeightedWordMapping();
    System.out.println(
        q3838EWeightedWordMapping.mapWordWeights(
            new String[] {"abcd", "def", "xyz"},
            new int[] {
              5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2
            }));
    System.out.println(
        q3838EWeightedWordMapping.mapWordWeights(
            new String[] {"a", "b", "c"},
            new int[] {
              1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1
            }));
  }

  public String mapWordWeights(String[] words, int[] weights) {
    StringBuilder data = new StringBuilder();
    for (String word : words) {
      int weight = 0;
      for (int i = 0; i < word.length(); i++) weight += weights[word.charAt(i) - 'a'];
      weight %= 26;
      data.append((char) ('z' - weight));
    }
    return data.toString();
  }
}
