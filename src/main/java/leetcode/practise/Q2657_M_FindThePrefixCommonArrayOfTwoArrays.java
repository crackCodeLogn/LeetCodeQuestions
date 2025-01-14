package leetcode.practise;

import java.util.*;

/**
 * @author Vivek
 * @since 2025-01-13
 */
public class Q2657_M_FindThePrefixCommonArrayOfTwoArrays {

  public static void main(String[] args) {
    Q2657_M_FindThePrefixCommonArrayOfTwoArrays q2657MFindThePrefixCommonArrayOfTwoArrays =
        new Q2657_M_FindThePrefixCommonArrayOfTwoArrays();
    System.out.println(
        Arrays.toString(
            q2657MFindThePrefixCommonArrayOfTwoArrays.findThePrefixCommonArray(
                new int[] {1, 3, 2, 4}, new int[] {3, 1, 2, 4})));
    System.out.println(
        Arrays.toString(
            q2657MFindThePrefixCommonArrayOfTwoArrays.findThePrefixCommonArray(
                new int[] {2, 3, 1}, new int[] {3, 1, 2})));
  }

  public int[] findThePrefixCommonArray(int[] A, int[] B) { // 2ms, beats 95.83%
    int n = A.length, cnt = 0;
    int[] data = new int[n];
    int[] store = new int[51];
    for (int i = 0; i < n; i++) {
      if (store[A[i]] > 0) cnt++;
      else store[A[i]]++;
      if (store[B[i]] > 0) cnt++;
      else store[B[i]]++;
      data[i] = cnt;
    }
    return data;
  }

  public int[] findThePrefixCommonArray2(int[] A, int[] B) { // 4ms, beats 72.92%
    int n = A.length, cnt = 0;
    int[] data = new int[n];
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (set.contains(A[i])) cnt++;
      else set.add(A[i]);
      if (set.contains(B[i])) cnt++;
      else set.add(B[i]);
      data[i] = cnt;
    }
    return data;
  }
}
