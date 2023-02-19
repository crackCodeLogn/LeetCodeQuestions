package leetcode.contest.weekly.w332_202302;

/**
 * @author Vivek
 * @since 2023-02-12
 */
public class Q2562_E_Find_the_Array_Concatenation_Value {

    public static void main(String[] args) {
        Q2562_E_Find_the_Array_Concatenation_Value q2562EFindtheArrayConcatenationValue = new Q2562_E_Find_the_Array_Concatenation_Value();
        System.out.println(q2562EFindtheArrayConcatenationValue.findTheArrayConcVal(new int[]{
                7, 52, 2, 4
        }));
        System.out.println(q2562EFindtheArrayConcatenationValue.findTheArrayConcVal(new int[]{
                5, 14, 13, 8, 12
        }));
    }

    public long findTheArrayConcVal(int[] nums) {
        int lb = 0, ub = nums.length - 1;
        long sum = 0;
        while (lb <= ub) {
            if (lb == ub) {
                sum += nums[lb];
                break;
            } else {
                String s1 = nums[lb++] + "" + nums[ub--];
                sum += Long.parseLong(s1);
            }
        }
        return sum;
    }
}
