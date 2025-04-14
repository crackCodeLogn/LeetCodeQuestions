package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-04-13
 */
public class Q1534_E_CountGoodTriplets {

  public static void main(String[] args) {
    Q1534_E_CountGoodTriplets q1534ECountGoodTriplets = new Q1534_E_CountGoodTriplets();
    System.out.println(
        q1534ECountGoodTriplets.countGoodTriplets(new int[] {3, 0, 1, 1, 9, 7}, 7, 2, 3));
    System.out.println(
        q1534ECountGoodTriplets.countGoodTriplets(new int[] {1, 1, 2, 2, 3}, 0, 0, 1));
  }

  public int countGoodTriplets(int[] arr, int a, int b, int c) {
    int cnt = 0, n = arr.length;
    for (int i = 0; i < n; i++)
      for (int j = i + 1; j < n; j++)
        for (int k = j + 1; k < n; k++)
          if (calc(arr[i], arr[j], a) && calc(arr[j], arr[k], b) && calc(arr[k], arr[i], c)) cnt++;
    return cnt;
  }

  private boolean calc(int v1, int v2, int v3) {
    return Math.abs(v1 - v2) <= v3;
  }
}
