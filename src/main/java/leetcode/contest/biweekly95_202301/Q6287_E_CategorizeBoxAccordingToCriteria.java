package leetcode.contest.biweekly95_202301;

/**
 * @author Vivek
 * @since 2023-01-02
 */
public class Q6287_E_CategorizeBoxAccordingToCriteria {

    private static final long CONST_10_4 = (long) Math.pow(10, 4);
    private static final long CONST_10_9 = (long) Math.pow(10, 9);

    public static void main(String[] args) {
        Q6287_E_CategorizeBoxAccordingToCriteria q6287Categorize = new Q6287_E_CategorizeBoxAccordingToCriteria();
        System.out.println(q6287Categorize.categorizeBox(1000, 35, 700, 300));
    }

    public String categorizeBox(int length, int width, int height, int mass) {
        String result = "";

        long l = length, w = width, h = height, m = mass;
        boolean isB = false, isH = false;
        long v = l * w * h;
        if (v >= CONST_10_9 || l >= CONST_10_4 || w >= CONST_10_4 || h >= CONST_10_4) isB = true;
        if (m >= 100) isH = true;
        if (isB && isH) return "Both";
        if (!isB && !isH) return "Neither";
        if (isB) return "Bulky";
        return "Heavy";
    }
}
