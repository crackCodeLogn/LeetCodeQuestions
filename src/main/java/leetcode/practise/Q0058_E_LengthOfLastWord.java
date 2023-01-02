package leetcode.practise;

/**
 * @author Vivek
 * @since 31/10/22
 */
public class Q0058_E_LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        String[] data = s.split("\\s+");
        return data[data.length - 1].trim().length();
    }
}