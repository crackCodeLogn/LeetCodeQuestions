package leetcode.practise;

import java.util.Arrays;
import java.util.Set;

/**
 * @author Vivek
 * @since 2025-01-01
 */
public class Q2559_M_CountVowelStringsInRanges {

  private static final Set<Character> VOWELS = Set.of('a', 'e', 'i', 'o', 'u');

  public static void main(String[] args) {
    Q2559_M_CountVowelStringsInRanges q2559MCountVowelStringsInRanges =
        new Q2559_M_CountVowelStringsInRanges();
    System.out.println(
        Arrays.toString(
            q2559MCountVowelStringsInRanges.vowelStrings(
                new String[] {"aba", "bcb", "ece", "aa", "e"},
                new int[][] {
                  {0, 2},
                  {1, 4},
                  {1, 1},
                })));
    System.out.println(
        Arrays.toString(
            q2559MCountVowelStringsInRanges.vowelStrings(
                new String[] {"a", "e", "i"},
                new int[][] {
                  {0, 2},
                  {0, 1},
                  {2, 2},
                })));
    System.out.println(
        Arrays.toString(
            q2559MCountVowelStringsInRanges.vowelStrings(
                extractStringArray(
                    "[\"ebnnporwiufimntatuaoadwbxrtrt\",\"xjjqnrjkkbto\",\"tkubqyxihhxikigwlnkikxhsfxmhl\",\"xeezqycyn\","
                        + "\"ewrdylevbatctcydoqjcmixffplhdvcxy\",\"erhrezicc\",\"b\",\"lgildbphjsiechluqedoor\","
                        + "\"vsuvhhkaxvdvipmlpxkawyuektwwyq\",\"xvirozecg\",\"mxzreujgplnza\","
                        + "\"lvwtmnpkswiyoheshvyjjhgzvwayv\",\"ykbonftzsuuv\",\"tpbyufbbqpe\",\"nozcjouwqrxup\",\"o\","
                        + "\"bzvicojsvpvaglmveonqabc\",\"jefoabkhvaikfnjgamzbvisoff\",\"tihdokbjutzwmuukkol\","
                        + "\"rjbqfnmoccwhidzzqekaudnsrhkybggicvmvbgch\"]"),
                extractMatrix(
                    "[[7, 10],[6, 9],[12, 13],[17, 18],[5, 10],[12, 12],[17, 19],[1, 18],[13, 18],[3, 11],[6, 14],[9, 10],[3, 19],[13, 18],[17, 18],[5, 7],[3, 12],[9, 11],[15, 17],[7, 15],[18, 18],[2, 17]]"))));
  }

  private static String[] extractStringArray(String input) {
    if (input.isBlank()) return null;

    input = input.strip();
    int start = 0, end = input.length();
    if (input.charAt(0) == '[') start++;
    if (input.charAt(input.length() - 1) == ']') end--;
    input = input.substring(start, end);

    return Arrays.stream(input.split(","))
        .map(str -> str.strip().replaceAll("\"", ""))
        .toArray(String[]::new);
  }

  private static int[][] extractMatrix(String input) {
    if (input.isBlank()) return null;

    input = input.strip();
    int start = 0, end = input.length();
    if (input.charAt(0) == '[') start++;
    if (input.charAt(input.length() - 1) == ']') end--;
    input = input.substring(start, end);

    String[] parts = input.split("],\\[");
    int[][] matrix = new int[parts.length][2];
    for (int i = 0; i < parts.length; i++) {
      String[] subParts = parts[i].strip().split(",");
      subParts[0] = subParts[0].replaceAll("\\[", "");
      subParts[1] = subParts[1].replaceAll("]", "");
      matrix[i][0] = Integer.parseInt(subParts[0].strip());
      matrix[i][1] = Integer.parseInt(subParts[1].strip());
    }
    return matrix;
  }

  public int[] vowelStrings(String[] words, int[][] queries) { // 6 ms, beats 74.03%
    int[] data = new int[words.length], result = new int[queries.length];
    int[] checks = new int[words.length];
    int index = 0;
    if (isVStr(words[0])) {
      data[0] = 1;
      checks[0] = 1;
    }

    for (int i = 1; i < words.length; i++) {
      data[i] = data[i - 1];
      if (isVStr(words[i])) {
        checks[i] = 1;
        data[i]++;
      }
    }
    for (int[] query : queries)
      result[index++] = data[query[1]] - data[query[0]] + checks[query[0]];
    return result;
  }

  private boolean isVStr(String w) {
    return VOWELS.contains(w.charAt(0)) && VOWELS.contains(w.charAt(w.length() - 1));
  }
}
