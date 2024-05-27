package leetcode.practise;

public class Q1608_E_SpecialArrayWithXElementsGreaterThanOrEqualX {

    public static void main(String[] args) {
        Q1608_E_SpecialArrayWithXElementsGreaterThanOrEqualX q1608ESpecialArrayWithXElementsGreaterThanOrEqualX = new Q1608_E_SpecialArrayWithXElementsGreaterThanOrEqualX();
        System.out.println(q1608ESpecialArrayWithXElementsGreaterThanOrEqualX.specialArray(new int[]{3, 5}));
        System.out.println(q1608ESpecialArrayWithXElementsGreaterThanOrEqualX.specialArray(new int[]{0, 0}));
        System.out.println(q1608ESpecialArrayWithXElementsGreaterThanOrEqualX.specialArray(new int[]{0, 4, 3, 0, 4}));
    }

    // try later to use the binary search approach

    public int specialArray(int[] nums) { // brute force
        for (int x = 1; x <= nums.length; x++) {
            int cnt = 0;
            boolean flag = true;
            for (int i = 0; i < nums.length; i++)
                if (nums[i] >= x) {
                    cnt++;
                    if (cnt > x) {
                        flag = false;
                        break;
                    }
                }
            if (flag && cnt == x) return x;
        }
        return -1;
    }
}
