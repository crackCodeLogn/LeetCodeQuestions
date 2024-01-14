package leetcode.contest.weekly.w380_202401;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-01-14
 */
public class Q100165_M_FindBeautifulIndicesInGivenArray1 {

    public static void main(String[] args) {
        Q100165_M_FindBeautifulIndicesInGivenArray1 q100165MFindBeautifulIndicesInGivenArray1 = new Q100165_M_FindBeautifulIndicesInGivenArray1();
        System.out.println(q100165MFindBeautifulIndicesInGivenArray1.beautifulIndices("isawsquirrelnearmysquirrelhouseohmy", "my", "squirrel", 25));
        System.out.println(q100165MFindBeautifulIndicesInGivenArray1.beautifulIndices("abcd", "a", "a", 4));
        System.out.println(q100165MFindBeautifulIndicesInGivenArray1.beautifulIndices("ocmm", "m", "oc", 3)); //2,3
        System.out.println(q100165MFindBeautifulIndicesInGivenArray1.beautifulIndices("jqcdc", "c", "d", 2)); //2,4
        System.out.println(q100165MFindBeautifulIndicesInGivenArray1.beautifulIndices("frtzggff", "g", "f", 1)); //5
    }

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        List<Integer> seriesA = compute(s, a);
        List<Integer> seriesB = compute(s, b);
        List<Integer> data = new ArrayList<>();

        int p1 = 0, p2 = 0;
        while (p1 < seriesA.size() && p2 < seriesB.size()) {
            if (Math.abs(seriesA.get(p1) - seriesB.get(p2)) <= k) {
                data.add(seriesA.get(p1));
                p1++;
            } else {
                if (seriesA.get(p1) < seriesB.get(p2)) p1++;
                else p2++;
            }
        }
        return data;
    }

    private List<Integer> compute(String s, String v) {
        List<Integer> data = new ArrayList<>();
        int pointer = 0;
        while (true) {
            pointer = s.indexOf(v, pointer);
            if (pointer == -1) return data;
            data.add(pointer);
            pointer++;
        }
    }
}
