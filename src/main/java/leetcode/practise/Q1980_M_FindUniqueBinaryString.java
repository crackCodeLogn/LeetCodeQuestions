package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-02-19
 */
public class Q1980_M_FindUniqueBinaryString {
  private static final int LIMIT = (int) (Math.pow(2, 16) + 1);

  public static void main(String[] args) {
    Q1980_M_FindUniqueBinaryString q1980MFindUniqueBinaryString =
        new Q1980_M_FindUniqueBinaryString();
    System.out.println(
        q1980MFindUniqueBinaryString.findDifferentBinaryString(new String[] {"01", "10"}));
    System.out.println(
        q1980MFindUniqueBinaryString.findDifferentBinaryString(new String[] {"00", "01"}));
    System.out.println(
        q1980MFindUniqueBinaryString.findDifferentBinaryString(new String[] {"111", "011", "001"}));
  }

  public String findDifferentBinaryString(String[] nums) { // 3ms, beats 36.03%
    boolean[] data = new boolean[LIMIT];
    for (String num : nums) data[Integer.parseInt(num, 2)] = true;
    for (int i = 0; i < LIMIT; i++) {
      if (!data[i]) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
        while (sb.length() != nums.length) sb.insert(0, "0");
        return sb.toString();
      }
    }
    return "";
  }
}
