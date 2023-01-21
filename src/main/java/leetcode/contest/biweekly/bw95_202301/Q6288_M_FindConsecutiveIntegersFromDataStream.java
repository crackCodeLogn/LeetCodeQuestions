package leetcode.contest.biweekly.bw95_202301;

/**
 * @author Vivek
 * @since 2023-01-02
 */
public class Q6288_M_FindConsecutiveIntegersFromDataStream {

    class DataStream {

        private final int base;
        private final int range;
        private int cnt;

        public DataStream(int value, int k) {
            this.base = value;
            this.range = k;
            this.cnt = 0;
        }

        public boolean consec(int num) {
            if (num == base) {
                if (cnt < range) cnt++;
            } else {
                cnt = 0;
            }
            return cnt == range;
        }
    }
}