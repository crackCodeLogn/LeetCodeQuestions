package leetcode.practise;

public class Q2169_E_CountOperationsToObtainZero {

  public static void main(String[] args) {
    Q2169_E_CountOperationsToObtainZero q2169ECountOperationsToObtainZero =
        new Q2169_E_CountOperationsToObtainZero();
    System.out.println(q2169ECountOperationsToObtainZero.countOperations(2, 3));
    System.out.println(q2169ECountOperationsToObtainZero.countOperations(10, 10));
  }

  public int countOperations(int num1, int num2) { // 1ms, beats 90.35%
    int ops = 0;
    while (num1 > 0 && num2 > 0) {
      if (num1 >= num2) num1 -= num2;
      else num2 -= num1;
      ops++;
    }
    return ops;
  }
}
