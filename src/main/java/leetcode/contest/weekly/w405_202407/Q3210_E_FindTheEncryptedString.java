package leetcode.contest.weekly.w405_202407;

/**
 * @author Vivek
 * @since 2024-07-06
 */
public class Q3210_E_FindTheEncryptedString {

    public static void main(String[] args) {
        Q3210_E_FindTheEncryptedString q3210EFindTheEncrpytedString = new Q3210_E_FindTheEncryptedString();
        System.out.println(q3210EFindTheEncrpytedString.getEncryptedString("dart", 3));
        System.out.println(q3210EFindTheEncrpytedString.getEncryptedString("aaa", 1));
    }

    public String getEncryptedString(String s, int k) {
        StringBuilder data = new StringBuilder();
        for (int i = 0; i < s.length(); i++) data.append(s.charAt((i + k) % s.length()));
        return data.toString();
    }
}
