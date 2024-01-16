package leetcode.practise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Vivek
 * @since 2024-01-16
 */
public class Q0380_M_InsertDeleteGetRandomO1 {

    class RandomizedSet {

        private final Map<Integer, Integer> data;
        private final Map<Integer, Integer> reverseData;
        private final Set<Integer> recycle;
        private int cnt = 0;

        public RandomizedSet() {
            data = new HashMap<>();
            reverseData = new HashMap<>();
            recycle = new HashSet<>();
        }

        public boolean insert(int val) {
            if (data.containsKey(val)) return false;

            if (recycle.isEmpty()) {
                cnt++;
                data.put(val, cnt);
                reverseData.put(cnt, val);
            } else {
                int cn = -1;
                for (Integer v : recycle) {
                    cn = v;
                    break;
                }
                recycle.remove(cn);
                data.put(val, cn);
                reverseData.put(cn, val);
            }
            return true;
        }

        public boolean remove(int val) {
            if (!data.containsKey(val)) return false;

            int v = data.remove(val);
            reverseData.remove(v);
            recycle.add(v);
            return true;
        }

        public int getRandom() {
            int rand = -1;
            do {
                rand = (int) (Math.random() * cnt);
            } while (recycle.contains(rand));
            return reverseData.get(rand);
        }
    }
}
