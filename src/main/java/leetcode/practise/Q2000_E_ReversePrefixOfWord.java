package leetcode.practise;

/**
 * @author Vivek
 * @since 2024-05-01
 */
public class Q2000_E_ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) return word;
        return (new StringBuilder(word.substring(0, index + 1)).reverse()) + word.substring(index + 1);
    }

}
