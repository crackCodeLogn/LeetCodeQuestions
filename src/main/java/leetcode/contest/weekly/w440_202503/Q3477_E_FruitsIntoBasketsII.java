package leetcode.contest.weekly.w440_202503;

/**
 * @author Vivek
 * @since 2025-03-08
 */
public class Q3477_E_FruitsIntoBasketsII {

  public static void main(String[] args) {
    Q3477_E_FruitsIntoBasketsII q3477EFruitsIntoBasketsII = new Q3477_E_FruitsIntoBasketsII();
    System.out.println(
        q3477EFruitsIntoBasketsII.numOfUnplacedFruits(new int[] {4, 2, 5}, new int[] {3, 5, 4}));
    System.out.println(
        q3477EFruitsIntoBasketsII.numOfUnplacedFruits(new int[] {3, 6, 1}, new int[] {6, 4, 7}));
  }

  public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
    int n = fruits.length;
    int cnt = 0;
    for (int i = 0; i < n; i++) {
      boolean placed = false;
      for (int j = 0; j < baskets.length; j++)
        if (baskets[j] != -1 && fruits[i] <= baskets[j]) {
          baskets[j] = -1;
          placed = true;
          break;
        }

      if (!placed) cnt++;
    }
    return cnt;
  }
}
