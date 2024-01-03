package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-01-03
 */
public class Q2125_M_NumberofLaserBeamsInBank {

    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int prod = 0;
        int data = -1;
        for (int i = 0; i < n; i++) {
            int v = getCount(bank[i]);
            if (v == 0) continue;
            if (data == -1) {
                data = v;
                continue;
            }
            prod += v * data;
            data = v;
        }

        return prod;
    }

    private int getCount(String data) {
        int cnt = 0;
        for (int i = 0; i < data.length(); i++) if (data.charAt(i) == '1') cnt++;
        return cnt;
    }
}
