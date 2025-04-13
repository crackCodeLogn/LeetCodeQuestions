package leetcode.practise;

/**
 * @author Vivek
 * @since 2025-04-12
 */
public class Q1922_M_CountGoodNumbers {
  private static final long MOD = 1_000_000_007;

  public static void main(String[] args) {
    Q1922_M_CountGoodNumbers q1922MCountGoodNumbers = new Q1922_M_CountGoodNumbers();
    System.out.println(q1922MCountGoodNumbers.countGoodNumbers(1));
    System.out.println(q1922MCountGoodNumbers.countGoodNumbers(4));
    System.out.println(q1922MCountGoodNumbers.countGoodNumbers(50));
  }

  public int countGoodNumbers(long n) {
    long p1 = n / 2, p2 = 2 * (n / 2);
    if (isOdd(n)) p1++;
    long l1 = fastExponentiation(5, p1, MOD);
    long l2 = fastExponentiation(2, p2, MOD);
    return (int) ((l1 * l2) % MOD);
  }

  private long fastExponentiation(long base, long power, long mod) {
    long val = 1;
    base %= mod;
    if (base == 0) return 0;
    while (power > 0) {
      if (isOdd(power)) val = (val * base) % mod;
      power = power >> 1;
      base = (base * base) % mod;
    }
    return val % MOD;
  }

  private boolean isOdd(long n) {
    return (n & 1) == 1;
  }
}
