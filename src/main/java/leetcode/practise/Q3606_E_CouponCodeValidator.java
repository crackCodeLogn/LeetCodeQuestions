package leetcode.practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * @author Vivek
 * @since 2025-12-12
 */
public class Q3606_E_CouponCodeValidator {

  private static final Set<String> VALID_BUSINESS = new HashSet<>();
  private static final Pattern MATCHER = Pattern.compile("^[a-zA-Z0-9_]+$");

  public List<String> validateCoupons(
      String[] code, String[] businessLine, boolean[] isActive) { // 15ms, beats 49.55%
    if (VALID_BUSINESS.isEmpty()) {
      VALID_BUSINESS.add("electronics");
      VALID_BUSINESS.add("grocery");
      VALID_BUSINESS.add("pharmacy");
      VALID_BUSINESS.add("restaurant");
    }

    List<Coupon> coupons = new ArrayList<>();
    for (int i = 0; i < code.length; i++)
      if (VALID_BUSINESS.contains(businessLine[i])
          && isActive[i]
          && MATCHER.matcher(code[i]).find()) coupons.add(new Coupon(code[i], businessLine[i]));

    Collections.sort(coupons);
    return coupons.stream().map(Coupon::code).toList();
  }

  private record Coupon(String code, String business) implements Comparable<Coupon> {
    @Override
    public int compareTo(Coupon o) {
      if (business.equals(o.business)) return code.compareTo(o.code);
      return business.compareTo(o.business);
    }
  }
}
