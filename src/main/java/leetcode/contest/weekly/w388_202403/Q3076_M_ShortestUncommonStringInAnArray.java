package leetcode.contest.weekly.w388_202403;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Vivek
 * @since 2024-03-10
 */
public class Q3076_M_ShortestUncommonStringInAnArray {

    public static void main(String[] args) {
        Q3076_M_ShortestUncommonStringInAnArray q100251MShortestUncommonStringInAnArray = new Q3076_M_ShortestUncommonStringInAnArray();
        String[] result;
        result = q100251MShortestUncommonStringInAnArray.shortestSubstrings(new String[]{"cab", "ad", "bad", "c"});
        result = q100251MShortestUncommonStringInAnArray.shortestSubstrings(new String[]{"abc", "bcd", "abcd"});
        result = q100251MShortestUncommonStringInAnArray.shortestSubstrings(new String[]{"gfnt", "xn", "mdz", "yfmr", "fi", "wwncn", "hkdy"}); // ["g","x","z","r","i","c","h"]
    }

    public String[] shortestSubstrings(String[] arr) {
        String[] data = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            data[i] = compute(str, i, arr);
        }
        return data;
    }

    private String compute(String str, int src, String[] arr) {
        List<String> data = new ArrayList<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                String sub = str.substring(i, j);

                boolean flag = true;
                for (int k = 0; k < arr.length; k++) {
                    if (k != src) {
                        if (arr[k].contains(sub)) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    if (minLength == Integer.MAX_VALUE || sub.length() == minLength) {
                        minLength = sub.length();
                        data.add(sub);
                    } else if (sub.length() < minLength) {
                        data.clear();
                        minLength = sub.length();
                        data.add(sub);
                    }
                }
            }
        }
        Collections.sort(data);
        return data.isEmpty() ? "" : data.get(0);
    }
}
