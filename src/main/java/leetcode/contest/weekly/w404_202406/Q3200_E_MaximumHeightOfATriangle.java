package leetcode.contest.weekly.w404_202406;

/**
 * @author Vivek
 * @since 2024-06-30
 */
public class Q3200_E_MaximumHeightOfATriangle {

    public static void main(String[] args) {
        Q3200_E_MaximumHeightOfATriangle q = new Q3200_E_MaximumHeightOfATriangle();
        System.out.println(q.maxHeightOfTriangle(2, 4));
        System.out.println(q.maxHeightOfTriangle(2, 1));
        System.out.println(q.maxHeightOfTriangle(1, 1));
        System.out.println(q.maxHeightOfTriangle(10, 1));
    }

    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(compute(red, blue), compute(blue, red));
    }

    private int compute(int c1, int c2) {
        int s1 = 0, s2 = 0, level = 0;
        while (s1 <= c1 && s2 <= c2) {
            level++;
            if (level % 2 == 1) s1 += level;
            else s2 += level;
        }
        return level - 1;
    }
}
