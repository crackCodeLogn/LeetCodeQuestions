package leetcode.practise;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-02-02
 */
public class Q1291_M_SequentialDigits {

    private static final List<Integer> data = new ArrayList<>(40);

    public static void main(String[] args) {
        Q1291_M_SequentialDigits q1291MSequentialDigits = new Q1291_M_SequentialDigits();
        System.out.println(q1291MSequentialDigits.sequentialDigits(100, 300)); // 123, 234
        System.out.println(q1291MSequentialDigits.sequentialDigits(1000, 13000)); // 1234,2345,3456,4567,5678,6789,12345
    }

    public List<Integer> sequentialDigits(int low, int high) {
        if (data.isEmpty()) populate();

        List<Integer> res = new ArrayList<>();
        for (int i = getLow(low); i <= getHigh(high); i++) res.add(data.get(i));
        return res;
    }

    private int getLow(int low) {
        int i = 0;
        if (low > data.get(data.size() - 1)) return Integer.MAX_VALUE;
        while (data.get(i) < low) i++;
        return i;
    }

    private int getHigh(int high) {
        int i = data.size() - 1;
        if (high <= data.get(0)) return Integer.MIN_VALUE;
        while (data.get(i) > high) i--;
        return i;
    }

    private void populate() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                StringBuilder num = new StringBuilder();
                num.append(j);
                for (int k = j + 1; num.length() < i && k <= 9; k++) num.append(k);
                if (num.length() != i) continue;

                try {
                    int v = Integer.parseInt(num.toString());
                    data.add(v);
                } catch (Exception e) {
                    System.out.println(e);
                    return;
                }
            }
        }
    }

}
