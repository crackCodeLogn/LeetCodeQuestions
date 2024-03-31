package leetcode.contest.weekly.w391_202403;

/**
 * @author Vivek
 * @since 2024-03-31
 */
public class Q3100_M_WaterBottlesII {

    public static void main(String[] args) {
        Q3100_M_WaterBottlesII q3100MWaterBottlesII = new Q3100_M_WaterBottlesII();
        System.out.println(q3100MWaterBottlesII.maxBottlesDrunk(13, 6)); // 15
        System.out.println(q3100MWaterBottlesII.maxBottlesDrunk(10, 3)); // 13
    }

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int sum = 0;
        int full = numBottles, empty = 0;
        while (true) {
            if (empty >= numExchange) {
                empty -= numExchange;
                numExchange++;
                full++;
            } else {
                empty += full;
                sum += full;
                full = 0;
            }
            if (full == 0 && empty < numExchange) break;
        }

        return sum;
    }

}
