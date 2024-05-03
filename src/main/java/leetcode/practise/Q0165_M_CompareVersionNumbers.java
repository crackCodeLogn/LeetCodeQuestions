package leetcode.practise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q0165_M_CompareVersionNumbers {

    public static void main(String[] args) {
        Q0165_M_CompareVersionNumbers q0165MCompareVersionNumbers = new Q0165_M_CompareVersionNumbers();
        System.out.println(q0165MCompareVersionNumbers.compareVersion("1.01", "1.001")); // 0
        System.out.println(q0165MCompareVersionNumbers.compareVersion("1.0", "1.0.0")); // 0
        System.out.println(q0165MCompareVersionNumbers.compareVersion("0.1", "1.1")); // -1
        System.out.println(q0165MCompareVersionNumbers.compareVersion("1.0.0.0", "1.0.0.0.0.0.0.0.0.000000000.1")); // -1
        System.out.println(q0165MCompareVersionNumbers.compareVersion("0.1", "0.0.1")); // 1
    }

    public int compareVersion(String version1, String version2) { //1ms
        String[] parts1 = version1.split("\\.");
        String[] parts2 = version2.split("\\.");
        int v = compare(parts1[0], parts2[0]);
        if (v != 0) return v;

        int p1 = 1, p2 = 1;
        while (p1 < parts1.length && p2 < parts2.length) {
            v = compare(parts1[p1], parts2[p2]);
            if (v != 0) return v;
            p1++;
            p2++;
        }
        if (p1 < parts1.length) {
            while (p1 < parts1.length && Integer.parseInt(parts1[p1]) == 0) p1++;
            if (p1 < parts1.length) return 1;
        }
        if (p2 < parts2.length) {
            while (p2 < parts2.length && Integer.parseInt(parts2[p2]) == 0) p2++;
            if (p2 < parts2.length) return -1;
        }
        return 0;
    }

    public int compareVersion2(String version1, String version2) { //loose approach - 4ms
        List<Integer> parts1 = Arrays.stream(version1.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> parts2 = Arrays.stream(version2.split("\\.")).map(Integer::parseInt).collect(Collectors.toList());
        int v = compare(parts1.get(0), parts2.get(0));
        if (v != 0) return v;

        int p1 = 1, p2 = 1;
        while (p1 < parts1.size() && p2 < parts2.size()) {
            v = compare(parts1.get(p1), parts2.get(p2));
            if (v != 0) return v;
            p1++;
            p2++;
        }
        if (p1 < parts1.size()) {
            while (p1 < parts1.size() && parts1.get(p1) == 0) p1++;
            if (p1 < parts1.size()) return 1;
        }
        if (p2 < parts2.size()) {
            while (p2 < parts2.size() && parts2.get(p2) == 0) p2++;
            if (p2 < parts2.size()) return -1;
        }
        return 0;
    }

    private int compare(String a, String b) {
        return Integer.compare(Integer.parseInt(a), Integer.parseInt(b));
    }

    private int compare(int a, int b) {
        return Integer.compare(a, b);
    }
}
