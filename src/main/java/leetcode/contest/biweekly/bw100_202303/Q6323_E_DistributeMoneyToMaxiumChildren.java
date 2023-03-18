package leetcode.contest.biweekly.bw100_202303;

import java.util.Arrays;

/**
 * @author Vivek
 * @since 2023-03-18
 */
public class Q6323_E_DistributeMoneyToMaxiumChildren {

    public static void main(String[] args) {
        Q6323_E_DistributeMoneyToMaxiumChildren q6323EDistributeMoneyToMaxiumChildren = new Q6323_E_DistributeMoneyToMaxiumChildren();
        System.out.println(q6323EDistributeMoneyToMaxiumChildren.distMoney(15, 8));

    }

    public int distMoney(int money, int children) {
        int cnt = 0;
        if (money < children) return -1;
        int div = money / 8;
        int mod = money % 8;

        money -= children;
        if (money < 0) return 0;

        int[] data = new int[children];
        Arrays.fill(data, 1);
        for (int i = 0; i < children; i++) {
            if (money >= 7) {
                data[i] += 7;
                money -= 7;
            } else {
                data[i] += money;
                money = 0;
                break;
            }
        }
        int c8 = 0, c4 = 0;
        for (int i = 0; i < children; i++) {
            if (data[i] == 8) c8++;
            else if (data[i] == 4) c4++;
        }
        int c = children - c8 - c4;
        if (money > 0) {
            if (c8 == children) return c8 - 1;
            return c8;
        } else {
            if (c4 > 0) {
                //rebal
                if (c == 0) c8--;
                return Math.max(c8, 0);
            } else return c8;
        }
    }
}
