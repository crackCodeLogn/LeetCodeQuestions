package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-12-22
 */
public class Q1160_E_FindWordsThatCanBeFormedByCharacters {

    public int countCharacters(String[] words, String chars) {
        int count = 0;
        int[] data;

        for (String word : words) {
            data = new int[130];
            for (int i = 0; i < chars.length(); i++) data[chars.charAt(i)]++;
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                if (data[word.charAt(i)] <= 0) {
                    flag = false;
                    break;
                } else {
                    data[word.charAt(i)]--;
                }
            }
            if (flag) count += word.length();
        }
        return count;
    }
}
