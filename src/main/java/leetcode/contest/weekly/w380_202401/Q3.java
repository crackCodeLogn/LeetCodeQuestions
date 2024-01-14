package leetcode.contest.weekly.w380_202401;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Vivek
 * @since 2024-01-14
 */
public class Q3 {
    private static final Map<Long, Long> data = new HashMap<>();

    /*public long findMaximumNumber(long k, int x) {
        long num = 1, sum = 0;
        while (true) {
            String v1 = getBinary(num);
            int index = v1.length() % x;
            if (index >= v1.length()) {
                num++;
                continue;
            }
            long v2 = Long.parseLong(v1.substring(index));
            long price = getPrice(v2, x);
//            if (data.containsKey(v2))
        }

        return num;
    }

    private long getPrice(long v2, int x) {
        if (data.containsKey(v2)) return data.get(v2);
//        if ((v2 >> ))
    }*/

    private String getBinary(long v) {
        return Long.toBinaryString(v);
    }
}
