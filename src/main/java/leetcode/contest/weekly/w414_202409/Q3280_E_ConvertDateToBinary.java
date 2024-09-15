package leetcode.contest.weekly.w414_202409;

/**
 * @author Vivek
 * @since 2024-09-15
 */
public class Q3280_E_ConvertDateToBinary {
  public static void main(String[] args) {
    Q3280_E_ConvertDateToBinary q3280EConvertDateToBinary = new Q3280_E_ConvertDateToBinary();
    System.out.println(q3280EConvertDateToBinary.convertDateToBinary("2080-02-29"));
    System.out.println(q3280EConvertDateToBinary.convertDateToBinary("1900-01-01"));
  }

  public String convertDateToBinary(String date) {
    return String.format(
        "%s-%s-%s",
        Integer.toBinaryString(Integer.parseInt(date.substring(0, 4))),
        Integer.toBinaryString(Integer.parseInt(date.substring(5, 7))),
        Integer.toBinaryString(Integer.parseInt(date.substring(8))));
  }
}
