package leetcode.contest.weekly.w405_202407;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-07-06
 */
public class Q3211_M_GenerateBinaryStringsWithoutAdjacentZeros {

    public static void main(String[] args) {
        Q3211_M_GenerateBinaryStringsWithoutAdjacentZeros q3211MGenerateBinaryStringsWithoutAdjacentZeros = new Q3211_M_GenerateBinaryStringsWithoutAdjacentZeros();
        System.out.println(q3211MGenerateBinaryStringsWithoutAdjacentZeros.validStrings(3));
        System.out.println(q3211MGenerateBinaryStringsWithoutAdjacentZeros.validStrings(1));
        System.out.println(q3211MGenerateBinaryStringsWithoutAdjacentZeros.validStrings(4));
    }

    public List<String> validStrings(int n) {
        List<String> data = new ArrayList<>();
        compute(0, new char[n], data, -1, n);
        return data;
    }

    private void compute(int i, char[] data, List<String> result, int prev, int limit) {
        if (i - prev > 2) return;
        if (i == limit) {
            result.add(new String(data));
            return;
        }

        data[i] = '0';
        compute(i + 1, data, result, prev, limit);
        data[i] = '1';
        compute(i + 1, data, result, i, limit);
    }
}
