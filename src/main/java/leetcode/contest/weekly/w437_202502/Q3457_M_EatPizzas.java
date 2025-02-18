package leetcode.contest.weekly.w437_202502;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2025-02-15
 */
public class Q3457_M_EatPizzas {

  public static void main(String[] args) {
    Q3457_M_EatPizzas q3457MEatPizzas = new Q3457_M_EatPizzas();
    System.out.println(
        q3457MEatPizzas.maxWeight(
            new int[] {5, 5, 4, 4, 3, 1, 2, 4, 2, 4, 1, 2, 2, 3, 2, 2, 2, 4, 5, 2})); // 23
    System.out.println(
        q3457MEatPizzas.maxWeight(new int[] {5, 2, 2, 4, 3, 3, 1, 3, 2, 5, 4, 2})); // 14
    System.out.println(q3457MEatPizzas.maxWeight(new int[] {1, 2, 3, 4, 5, 6, 7, 8})); // 14
    System.out.println(q3457MEatPizzas.maxWeight(new int[] {2, 1, 1, 1, 1, 1, 1, 1})); // 3
  }

  public long maxWeight00(int[] pizzas) {
    long weight = 0;
    Arrays.sort(pizzas);
    System.out.println(pizzas.length);
    int n = pizzas.length, left = 0, right = n - 1;
    boolean[] marked = new boolean[n];
    boolean odd = true;
    while (left < right) {
      if (odd) {
        weight += pizzas[right];
        marked[right] = true;
        left += 3;
        right--;
      } else {
        while (right > 0) {
          if (marked[right]) right--;
          else break;
        }
        if (left >= right) break;
        if (pizzas[right] > pizzas[right - 1] && right - 2 > left + 2) {
          weight += pizzas[right - 2];
          marked[right - 2] = true;
          marked[right - 1] = true;
        } else {
          weight += pizzas[right - 1];
          marked[right] = true;
          marked[right - 1] = true;
          right -= 2;
        }
        left += 2;
      }
      odd = !odd;
    }

    return weight;
  }

  public long maxWeight(int[] pizzas) {
    long weight = 0;
    Arrays.sort(pizzas);
    int n = pizzas.length;
    int rights = (int) Math.ceil(n / 8.0);
    int lefts = n / 4 - rights;
    int i = n - 1;
    while (rights-- > 0) weight += pizzas[i--];
    i--;
    while (lefts-- > 0) {
      weight += pizzas[i];
      i -= 2;
    }
    return weight;
  }
}
