package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2025-02-13
 */
public class Q1352_M_ProductOfTheLastKNumbers {

  class ProductOfNumbers { // 18ms, beats 23.31%
    private long runningProduct = 0;
    private int lastZero = -1;
    private final List<Long> products = new ArrayList<>(100_000);

    public ProductOfNumbers() {
      //      products.add(-1L);
    }

    public void add(int num) {
      runningProduct = runningProduct == 0 ? num : runningProduct * num;
      products.add(runningProduct);
      if (num == 0) lastZero = products.size();
      //      System.out.println(products);
    }

    public int getProduct(int k) {
      //      System.out.println("K: " + k);
      if (lastZero == -1) {
        if (products.size() == k) return (int) runningProduct;
        return (int) (runningProduct / products.get(products.size() - k - 1));
      }
      if (products.size() - k + 1 <= lastZero) return 0;

      if (k == products.size() - lastZero) return (int) runningProduct;
      return (int) (runningProduct / products.get(products.size() - k - 1));
    }
  }
}
