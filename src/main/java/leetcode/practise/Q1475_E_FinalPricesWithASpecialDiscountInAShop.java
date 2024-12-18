package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2024-12-17
 */
public class Q1475_E_FinalPricesWithASpecialDiscountInAShop {
  public static void main(String[] args) {
    Q1475_E_FinalPricesWithASpecialDiscountInAShop q1475EFinalPricesWithASpecialDiscountInAShop =
        new Q1475_E_FinalPricesWithASpecialDiscountInAShop();
    System.out.println(
        Arrays.toString(
            q1475EFinalPricesWithASpecialDiscountInAShop.finalPrices(new int[] {8, 4, 6, 2, 3})));
    System.out.println(
        Arrays.toString(
            q1475EFinalPricesWithASpecialDiscountInAShop.finalPrices(new int[] {1, 2, 3, 4, 5})));
    System.out.println(
        Arrays.toString(
            q1475EFinalPricesWithASpecialDiscountInAShop.finalPrices(new int[] {10, 1, 1, 6})));
  }

  public int[] finalPrices(int[] prices) {
    int n = prices.length;
    int[] data = Arrays.copyOf(prices, n);

    for (int i = n - 2; i >= 0; i--) {
      for (int j = i + 1; j < n; j++) {
        if (prices[j] <= prices[i]) {
          data[i] = prices[i] - prices[j];
          break;
        }
      }
    }

    return data;
  }
}
