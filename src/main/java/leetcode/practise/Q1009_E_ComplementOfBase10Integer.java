package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-03-10
 */
public class Q1009_E_ComplementOfBase10Integer {

  public static void main(String[] args) {
    Q1009_E_ComplementOfBase10Integer q1009EComplementOfBase10Integer =
        new Q1009_E_ComplementOfBase10Integer();
    System.out.println(q1009EComplementOfBase10Integer.bitwiseComplement(5));
    System.out.println(q1009EComplementOfBase10Integer.bitwiseComplement(7));
    System.out.println(q1009EComplementOfBase10Integer.bitwiseComplement(10));
    System.out.println(q1009EComplementOfBase10Integer.bitwiseComplement(0));
    System.out.println(q1009EComplementOfBase10Integer.bitwiseComplement(1));
  }

  public int bitwiseComplement(int n) { // 0ms, beats 100%
    if (n == 0) return 1;
    int cnt = 0, data = 0;
    while (n > 0) {
      int dig = (n & 1) == 1 ? 0 : 1;
      if (dig == 1) data = (1 << cnt) + data;
      n >>= 1;
      cnt++;
    }
    return data;
  }
}
