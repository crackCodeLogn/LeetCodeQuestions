package leetcode.practise;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2025-06-21
 */
public class Q2138_E_DivideAStringIntoGroupsOfSizeK {

  public static void main(String[] args) {
    Q2138_E_DivideAStringIntoGroupsOfSizeK q2138EDivideAStringIntoGroupsOfSizeK =
        new Q2138_E_DivideAStringIntoGroupsOfSizeK();
    System.out.println(
        Arrays.toString(q2138EDivideAStringIntoGroupsOfSizeK.divideString("abcdefghi", 3, 'x')));
    System.out.println(
        Arrays.toString(q2138EDivideAStringIntoGroupsOfSizeK.divideString("abcdefghij", 3, 'x')));
  }

  public String[] divideString(String s, int k, char fill) { // 1ms, beats 93.67%
    StringBuilder[] data = new StringBuilder[(int) Math.ceil(s.length() * 1.0 / k)];
    for (int i = 0; i < data.length; i++) data[i] = new StringBuilder();
    int current = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (data[current].length() == k) current++;
      data[current].append(ch);
    }
    if (data[current].length() != k) while (data[current].length() != k) data[current].append(fill);
    String[] res = new String[data.length];
    for (int i = 0; i < data.length; i++) res[i] = data[i].toString();
    return res;
  }

  public String[] divideString2(String s, int k, char fill) { // 7ms, beats 18.37%
    String[] data = new String[(int) Math.ceil(s.length() * 1.0 / k)];
    Arrays.fill(data, "");
    int current = 0;
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      if (data[current].length() == k) current++;
      data[current] += ch;
    }
    if (data[current].length() != k) while (data[current].length() != k) data[current] += fill;
    return data;
  }
}
