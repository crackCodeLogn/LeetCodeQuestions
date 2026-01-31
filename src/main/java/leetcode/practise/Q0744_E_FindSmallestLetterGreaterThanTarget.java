package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-01-31
 */
public class Q0744_E_FindSmallestLetterGreaterThanTarget {
  public static void main(String[] args) {
    Q0744_E_FindSmallestLetterGreaterThanTarget q0744EFindSmallestLetterGreaterThanTarget =
        new Q0744_E_FindSmallestLetterGreaterThanTarget();
    System.out.println(
        q0744EFindSmallestLetterGreaterThanTarget.nextGreatestLetter(
            new char[] {'c', 'f', 'j'}, 'a'));
    System.out.println(
        q0744EFindSmallestLetterGreaterThanTarget.nextGreatestLetter(
            new char[] {'c', 'f', 'j'}, 'c'));
    System.out.println(
        q0744EFindSmallestLetterGreaterThanTarget.nextGreatestLetter(
            new char[] {'x', 'x', 'y', 'y'}, 'z'));
  }

  public char nextGreatestLetter(char[] letters, char target) {
    for (int i = 0; i < letters.length; i++) if (letters[i] > target) return letters[i];
    return letters[0];
  }
}
