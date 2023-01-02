package leetcode.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Vivek
 * @since 24/10/22
 * WA
 */
public class Q1239_M_MaximumLengthOfConcatenatedStringWithUniqueCharacters {

    public static void main(String[] args) {
        Q1239_M_MaximumLengthOfConcatenatedStringWithUniqueCharacters obj = new Q1239_M_MaximumLengthOfConcatenatedStringWithUniqueCharacters();
        String[] data = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p"};
        System.out.println(obj.maxLength(Arrays.asList(data))); //wa - output should be 16 and not 2.
    }

    private List<String> getReduced(List<String> data) {
        List<String> result = new ArrayList<>();
        for (String val : data) if (noOverlap(val, "")) result.add(val);
        return result;
    }

    public int maxLength(List<String> arr) {
        arr = getReduced(arr);
        if (arr.size() == 1) return arr.get(0).length();

        int maxLength = 0;
        String[][] data = new String[arr.size() + 1][arr.size() + 1];
        for (int j = 0; j < arr.size(); j++) {
            data[0][j] = arr.get(j);
        }
        for (int i = 0; i < arr.size(); i++) {
            data[i][0] = arr.get(i);
        }
        for (int i = 1; i < arr.size(); i++) {
            data[i][i] = arr.get(i - 1);
            for (int j = i + 1; j < arr.size(); j++) {
                data[i][j] = data[i - 1][j].length() > data[i][j - 1].length() ? data[i - 1][j] : data[i][j - 1];
                if (noOverlap(data[i][j - 1], data[i - 1][j])) {
                    String intermed = data[i][j - 1] + data[i - 1][j];
                    if (intermed.length() > data[i][j].length()) data[i][j] = intermed;
                    System.out.print(data[i][j] + " ");
                }
            }
            System.out.println();
        }
        return data[arr.size()][arr.size()].length();
        /*for (int i = 0; i < arr.size(); i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                if (noOverlap(arr.get(i), arr.get(j)))
                    maxLength = Math.max(maxLength, arr.get(i).length() + arr.get(j).length());
            }
        }*/
        //return maxLength;
    }

    private boolean noOverlap(String s1, String s2) {
        int[] data = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            data[ch - 'a']++;
            if (data[ch - 'a'] > 1) return false;
        }
        for (int i = 0; i < s2.length(); i++) {
            char ch = s2.charAt(i);
            if (data[ch - 'a'] > 0) return false;
        }
        return true;
    }
}
