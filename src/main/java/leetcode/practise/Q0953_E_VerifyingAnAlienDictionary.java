package leetcode.practise;

/**
 * @author Vivek
 * @since 2023-02-02
 */
public class Q0953_E_VerifyingAnAlienDictionary {

    public static void main(String[] args) {
        Q0953_E_VerifyingAnAlienDictionary q0953EVerifyingAnAlienDictionary = new Q0953_E_VerifyingAnAlienDictionary();
        /*System.out.println(q0953EVerifyingAnAlienDictionary.isAlienSorted(
                new String[]{"hello", "leetcode"},
                "hlabcdefgijkmnopqrstuvwxyz"
        ));
        System.out.println(q0953EVerifyingAnAlienDictionary.isAlienSorted(
                new String[]{"word", "world", "row"},
                "worldabcefghijkmnpqstuvxyz"
        ));
        System.out.println(q0953EVerifyingAnAlienDictionary.isAlienSorted(
                new String[]{"apple", "app"},
                "abcdefghijklmnopqrstuvwxyz"
        ));
        System.out.println(q0953EVerifyingAnAlienDictionary.isAlienSorted(
                new String[]{"fxasxpc", "dfbdrifhp", "nwzgs", "cmwqriv", "ebulyfyve", "miracx", "sxckdwzv", "dtijzluhts", "wwbmnge", "qmjwymmyox"},
                "zkgwaverfimqxbnctdplsjyohu"
        ));*/
        System.out.println(q0953EVerifyingAnAlienDictionary.isAlienSorted(
                new String[]{"kuvp", "q"},
                "ngxlkthsjuoqcpavbfdermiywz"
        ));
    }

    private boolean isCurrentCharacterGreaterThanPrevious(char current, char previous, String order) {
        return order.indexOf(current) > order.indexOf(previous);
    }

    public boolean isAlienSorted(String[] words, String order) {
        if (words.length == 1) return true;
        String previous = words[0];
        for (int i = 1; i < words.length; i++) {
            String current = words[i];
            boolean allSame = true;
            for (int j = 0; j < current.length(); j++) {
                if (j >= previous.length()) break;
                char currentCh = current.charAt(j), previousCh = previous.charAt(j);
                if (currentCh == previousCh) continue;
                allSame = false;
                if (!isCurrentCharacterGreaterThanPrevious(currentCh, previousCh, order)) return false;
                else break;
            }
            if (allSame && current.length() < previous.length()) return false;
            previous = current;
        }
        return true;
    }
}