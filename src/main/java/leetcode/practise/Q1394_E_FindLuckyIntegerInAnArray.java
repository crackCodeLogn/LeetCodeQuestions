package leetcode.practise;

/**
 * @author Vivek
 * @since 7/5/25
 */
public class Q1394_E_FindLuckyIntegerInAnArray {
  public static void main(String[] args) {
    Q1394_E_FindLuckyIntegerInAnArray q1394EFindLuckyIntegerInAnArray =
        new Q1394_E_FindLuckyIntegerInAnArray();
    System.out.println(q1394EFindLuckyIntegerInAnArray.findLucky(new int[] {2, 2, 3, 4}));
    System.out.println(q1394EFindLuckyIntegerInAnArray.findLucky(new int[] {1, 2, 2, 3, 3, 3}));
    System.out.println(q1394EFindLuckyIntegerInAnArray.findLucky(new int[] {2, 2, 2, 3, 3}));
  }

  public int findLucky(int[] arr) { // 1ms, beats 99.94%
    int[] ref = new int[501];
    for (int j : arr) ref[j]++;
    for (int i = ref.length - 1; i >= 1; i--) if (ref[i] == i) return i;
    return -1;
  }
}
