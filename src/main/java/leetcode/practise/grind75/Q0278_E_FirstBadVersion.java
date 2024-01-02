package leetcode.practise.grind75;

/**
 * @author Vivek
 * @since 2023-12-26
 */
public class Q0278_E_FirstBadVersion {

    /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

    public int firstBadVersion(int n) {
        return helper(1, n);
    }

    public int helper(int lb, int ub) {
        int mid = lb + (ub - lb) / 2;
        if (isBadVersion(mid)) {
            if (!isBadVersion(mid - 1))
                return mid;
            ub = mid - 2;
        } else {
            if (isBadVersion(mid + 1)) return mid + 1;
            lb = mid + 2;
        }
        return helper(lb, ub);
    }

    //custom placement, nothing to do with the actual submission
    boolean isBadVersion(int version) {
        return false;
    }
}
