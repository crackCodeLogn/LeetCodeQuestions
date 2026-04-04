package leetcode.practise;

/**
 * @author Vivek
 * @since 2026-04-03
 */
public class Q2075_M_DecodeTheSlantedCiphertext {
  public static void main(String[] args) {
    Q2075_M_DecodeTheSlantedCiphertext q2075MDecodeTheSlantedCiphertext =
        new Q2075_M_DecodeTheSlantedCiphertext();
    System.out.println(q2075MDecodeTheSlantedCiphertext.decodeCiphertext("", 5));
    System.out.println(q2075MDecodeTheSlantedCiphertext.decodeCiphertext(" b  ac", 2));
    System.out.println(
        q2075MDecodeTheSlantedCiphertext.decodeCiphertext("iveo    eed   l te   olc", 4));
    System.out.println(q2075MDecodeTheSlantedCiphertext.decodeCiphertext("ch   ie   pr", 3));
    System.out.println(q2075MDecodeTheSlantedCiphertext.decodeCiphertext("coding", 1));
  }

  public String decodeCiphertext(String encodedText, int rows) { // 25ms, beats 63.31%
    if (encodedText.isEmpty()) return encodedText;
    int cols = encodedText.length() / rows;
    int i = 0, j = 0, starter = 0;
    StringBuilder data = new StringBuilder();
    do {
      int idx = i * cols + j;
      data.append(encodedText.charAt(idx));
      i++;
      j++;
      if (i == rows || j == cols) {
        j = ++starter;
        i = 0;
      }
    } while (starter < cols);
    int k;
    for (k = data.length() - 1; k >= 0 && data.charAt(k) == ' '; k--)
      ;
    return data.substring(0, k + 1);
  }
}
