package leetcode.contest.weekly.w396_202405;

import java.util.HashMap;
import java.util.Map;

public class Q3137_M_MinimumNumberOfOperationsToMakeWordKPeriodic {

    private static <K> void augmentCount(Map<K, Integer> mapper, K key) {
        Integer val = mapper.get(key);
        if (val == null) val = 1;
        else val++;
        mapper.put(key, val);
    }

    public static void main(String[] args) {
        Q3137_M_MinimumNumberOfOperationsToMakeWordKPeriodic q3137MMinimumNumberOfOperationsToMakeWordKPeriodic = new Q3137_M_MinimumNumberOfOperationsToMakeWordKPeriodic();
        System.out.println(q3137MMinimumNumberOfOperationsToMakeWordKPeriodic.minimumOperationsToMakeKPeriodic("leetcodeleet", 4));
        System.out.println(q3137MMinimumNumberOfOperationsToMakeWordKPeriodic.minimumOperationsToMakeKPeriodic("leetcoleet", 2));
    }

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0, max = -1;
        for (int i = 0; i < word.length(); ) {
            String s = word.substring(i, i + k);
            i += k;
            augmentCount(map, s);
            cnt++;
            max = Math.max(max, map.get(s));
        }
        return cnt - max;
    }
}
