package leetcode.practise;

public class Q1513_M_NumberOfSubstringsWithOnly1s {

  private static final int MOD = (int) (Math.pow(10, 9) + 7);

  public static void main(String[] args) {
    Q1513_M_NumberOfSubstringsWithOnly1s q1513MNumberOfSubstringsWithOnly1s =
        new Q1513_M_NumberOfSubstringsWithOnly1s();
    System.out.println(q1513MNumberOfSubstringsWithOnly1s.numSub("0110111"));
    System.out.println(q1513MNumberOfSubstringsWithOnly1s.numSub("101"));
    System.out.println(q1513MNumberOfSubstringsWithOnly1s.numSub("111111"));
  }

  public int numSub(String s) { // 7 ms, beats 11.52%
    int x = 0;
    long data = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '1') {
        x++;
      } else {
        data += compute(x);
        x = 0;
      }
    }
    data += compute(x);
    return (int) (data % MOD);
  }

  private long compute(int v) {
    long n = v;
    return n * (n + 1) / 2;
  }
}
