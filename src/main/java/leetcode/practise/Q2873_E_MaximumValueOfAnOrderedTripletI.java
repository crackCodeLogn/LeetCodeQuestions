package leetcode.practise;

public class Q2873_E_MaximumValueOfAnOrderedTripletI {

  public static void main(String[] args) {
    Q2873_E_MaximumValueOfAnOrderedTripletI q2873EMaximumValueOfAnOrderedTripletI =
        new Q2873_E_MaximumValueOfAnOrderedTripletI();
    System.out.println(
        q2873EMaximumValueOfAnOrderedTripletI.maximumTripletValue(new int[] {12, 6, 1, 2, 7}));
    System.out.println(
        q2873EMaximumValueOfAnOrderedTripletI.maximumTripletValue(new int[] {1, 10, 3, 4, 19}));
    System.out.println(
        q2873EMaximumValueOfAnOrderedTripletI.maximumTripletValue(new int[] {1, 2, 3}));
  }

  public long maximumTripletValue(int[] nums) { // 3ms, beats 53.95%
    long data = 0;

    for (int i = 0; i < nums.length; i++) {
      long v1 = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        long v2 = nums[j];
        for (int k = j + 1; k < nums.length; k++) {
          long v3 = nums[k];
          data = Math.max(data, (v1 - v2) * v3);
        }
      }
    }
    return data;
  }

  public long maximumTripletValue2(int[] numsI) { // 3ms, beats 53.95%
    long data = 0;
    long[] nums = new long[numsI.length];
    for (int i = 0; i < numsI.length; i++) nums[i] = numsI[i];

    for (int i = 0; i < nums.length; i++)
      for (int j = i + 1; j < nums.length; j++)
        for (int k = j + 1; k < nums.length; k++)
          data = Math.max(data, (nums[i] - nums[j]) * nums[k]);
    return data;
  }
}
