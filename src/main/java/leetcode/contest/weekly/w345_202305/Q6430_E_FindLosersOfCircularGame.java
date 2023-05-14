package leetcode.contest.weekly.w345_202305;

import java.util.HashSet;
import java.util.Set;

public class Q6430_E_FindLosersOfCircularGame {

    public int[] circularGameLosers(int n, int k) {
        boolean[] touched = new boolean[n];
        int i = 0, j = 1;
        Set<Integer> unt = new HashSet<>();
        for (i = 0; i < n; i++) unt.add(i);
        i = 0;
        while (!touched[i]) {
            touched[i] = true;
            unt.remove(i);
            i = (i + k * j) % n;
            j++;
        }
        int[] data = new int[unt.size()];
        j = 0;
        for (Integer d : unt) data[j++] = d + 1;
        return data;
    }
}
