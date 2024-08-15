package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-08-15
 */
public class Q0860_E_LemonadeChange {
    public static void main(String[] args) {
        Q0860_E_LemonadeChange q0860ELemonadeChange = new Q0860_E_LemonadeChange();
        System.out.println(q0860ELemonadeChange.lemonadeChange(new int[]{5, 5, 5, 10, 20})); // true
        System.out.println(q0860ELemonadeChange.lemonadeChange(new int[]{5, 5, 10, 10, 20})); // false
    }

    public boolean lemonadeChange(int[] bills) { // 2ms
        int[] money = new int[21];
        for (int i = 0; i < bills.length; i++) if (!compute(money, bills[i] - 5)) return false;
        return true;
    }

    private boolean compute(int[] money, int bill) {
        if (bill == 0) {
            money[5]++;
            return true;
        }
        // only worry abt returning for 5 or 15.
        if (bill == 5 && money[5] > 0) {
            money[5]--;
            money[10]++;
        } else if (bill == 15 && (money[5] >= 3 || (money[10] > 0 && money[5] >= 1))) {
            if (money[10] > 0) {
                money[5]--;
                money[10]--;
            } else {
                money[5] -= 3;
            }
            money[20]++; // though we don't care abt this
        } else return false;
        return true;
    }
}
