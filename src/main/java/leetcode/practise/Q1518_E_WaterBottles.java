package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-07-07
 */
public class Q1518_E_WaterBottles {

    public static void main(String[] args) {
        Q1518_E_WaterBottles q1518EWaterBottles = new Q1518_E_WaterBottles();
        System.out.println(q1518EWaterBottles.numWaterBottles(9, 3)); // 13
        System.out.println(q1518EWaterBottles.numWaterBottles(15, 4)); // 19
    }

    public int numWaterBottles(int numBottles, int numExchange) {
        int max = 0, filled = numBottles;
        while (numBottles >= numExchange) {
            max += filled;
            filled = numBottles / numExchange;
            numBottles = filled + numBottles % numExchange;
        }
        return max + filled;
    }
}
