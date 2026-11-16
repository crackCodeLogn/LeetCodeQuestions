package leetcode.practise;

public class Q2243_E_CalculateDigitSumOfAString {

  public String digitSum(String s, int k) { // 1ms, beats 98.69%
    StringBuilder val = new StringBuilder(s);
    while (val.length() > k) {
      StringBuilder tmp = new StringBuilder();
      int i = 0;
      for (; i + k < val.length(); i += k) tmp.append(getSum(val.substring(i, i + k)));
      if (i < val.length()) tmp.append(getSum(val.substring(i)));
      val = tmp;
    }
    return val.toString();
  }

  private int getSum(String str) {
    int sum = 0;
    for (int i = 0; i < str.length(); i++) sum += str.charAt(i) - '0';
    return sum;
  }

  public static void main(String[] args) {
    Q2243_E_CalculateDigitSumOfAString q2243ECalculateDigitSumOfAString =
        new Q2243_E_CalculateDigitSumOfAString();
    System.out.println(q2243ECalculateDigitSumOfAString.digitSum("11111222223", 3));
    System.out.println(q2243ECalculateDigitSumOfAString.digitSum("00000000", 3));
  }
}
