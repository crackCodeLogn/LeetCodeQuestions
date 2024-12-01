package leetcode.contest.weekly.w426_202411;

/**
 * @author Vivek
 * @since 2024-11-30
 */
public class Q3370_E_SmallestNumberWithAllSetBits {

  public static void main(String[] args) {
    Q3370_E_SmallestNumberWithAllSetBits q3370ESmallestNumberWithAllSetBits =
        new Q3370_E_SmallestNumberWithAllSetBits();
    System.out.println(q3370ESmallestNumberWithAllSetBits.smallestNumber(5));
    System.out.println(q3370ESmallestNumberWithAllSetBits.smallestNumber(10));
    System.out.println(q3370ESmallestNumberWithAllSetBits.smallestNumber(3));
  }

  public int smallestNumber(int n) {
    int x = (int) (Math.log(n) / Math.log(2));
    return (int) (Math.pow(2, x + 1) - 1);
  }
}
