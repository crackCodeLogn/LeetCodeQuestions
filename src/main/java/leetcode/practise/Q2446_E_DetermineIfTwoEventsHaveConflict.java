package leetcode.practise;

/**
 * @author Vivek
 * @since 25/10/22
 */
public class Q2446_E_DetermineIfTwoEventsHaveConflict {

    public static void main(String[] args) {
        Q2446_E_DetermineIfTwoEventsHaveConflict obj = new Q2446_E_DetermineIfTwoEventsHaveConflict();
        System.out.println(obj.haveConflict(new String[]{"10:00", "11:00"}, new String[]{"14:00", "15:00"}));
    }

    public boolean haveConflict(String[] event1, String[] event2) {
        int s1 = getSeconds(event1[0]), s2 = getSeconds(event2[0]);
        int e1 = getSeconds(event1[1]), e2 = getSeconds(event2[1]);

        return !(e1 < s2 || e2 < s1);
    }

    private int getSeconds(String data) {
        //get seconds since mid night
        return Integer.parseInt(data.substring(0, data.indexOf(':'))) * 3600 + Integer.parseInt(data.substring(data.indexOf(':') + 1)) * 60;
    }
}
