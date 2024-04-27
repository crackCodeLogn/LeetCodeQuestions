package leetcode.practise;

import java.util.HashMap;
import java.util.Map;

public class Q0514_H_FreedomTrail {

    public int findRotateSteps(String ring, String key) {
        return dfs(ring, key, 0, new HashMap<>()) + key.length();
    }

    private int dfs(final String ring, final String key, int index, Map<String, Integer> mem) {
        if (index == key.length()) return 0;

        String hashKey = ring + index;
        if (mem.containsKey(hashKey)) return mem.get(hashKey);

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < ring.length(); ++i)
            if (ring.charAt(i) == key.charAt(index)) {
                int minRotates = Math.min(i, ring.length() - i);
                String newRing = ring.substring(i) + ring.substring(0, i);
                int remainingRotates = dfs(newRing, key, index + 1, mem);
                ans = Math.min(ans, minRotates + remainingRotates);
            }

        mem.put(hashKey, ans);
        return ans;
    }

    public static void main(String[] args) {
        Q0514_H_FreedomTrail q0514HFreedomTrail = new Q0514_H_FreedomTrail();
        System.out.println(q0514HFreedomTrail.findRotateSteps("godding", "gd")); // 4
        System.out.println(q0514HFreedomTrail.findRotateSteps("godding", "godding")); // 13
    }
}
