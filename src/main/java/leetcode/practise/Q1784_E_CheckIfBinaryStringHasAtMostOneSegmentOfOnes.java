package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-03-05
 */
public class Q1784_E_CheckIfBinaryStringHasAtMostOneSegmentOfOnes {
  public static void main(String[] args) {
    Q1784_E_CheckIfBinaryStringHasAtMostOneSegmentOfOnes
        q1784ECheckIfBinaryStringHasAtMostOneSegmentOfOnes =
            new Q1784_E_CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
    System.out.println(q1784ECheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("1001"));
    System.out.println(q1784ECheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("110"));
    System.out.println(q1784ECheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("1"));
    System.out.println(q1784ECheckIfBinaryStringHasAtMostOneSegmentOfOnes.checkOnesSegment("10"));
  }

  public boolean checkOnesSegment(String s) { // 0ms, beats 100%
    for (int i = 0; i < s.length() - 1; i++)
      if (s.charAt(i) == '0' && s.charAt(i + 1) == '1') return false;
    return true;
  }
}
