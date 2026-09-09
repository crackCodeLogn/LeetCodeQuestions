package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-09-09
 */
public class Q3871_M_CountCommasInRangeII {
  double sum = 0;

  public long countCommas(long n) { // 1ms, beats 99.36%
    // if (n == (long) Math.pow(10, 15)) return 3998998998999005L;

    sum = 0;
    // int base = (int) Math.log10(n);
    for (int i = 3, v = 1; i < 18; i += 3, v++) {
      compute(i, i + 3, n, v);
    }

    return (long) sum;
  }

  private void compute(int lb, int ub, long n, int v) {
    if (n >= Math.pow(10, ub)) {
      sum += (Math.pow(10, ub) - Math.pow(10, lb)) * v;
      return;
    } else if (n < Math.pow(10, lb)) {
      return;
    }
    sum += (n - Math.pow(10, lb) + 1) * v;
  }

  public static void main(String[] args) {
    Q3871_M_CountCommasInRangeII q3871MCountCommasInRangeII = new Q3871_M_CountCommasInRangeII();
    System.out.println(q3871MCountCommasInRangeII.countCommas(1000000L));
    System.out.println(q3871MCountCommasInRangeII.countCommas(100000000000000L));
    System.out.println(q3871MCountCommasInRangeII.countCommas(1000000000000000L));
    System.out.println(q3871MCountCommasInRangeII.countCommas(10000000));
    System.out.println(q3871MCountCommasInRangeII.countCommas(1002));
    System.out.println(q3871MCountCommasInRangeII.countCommas(998));
  }
}
