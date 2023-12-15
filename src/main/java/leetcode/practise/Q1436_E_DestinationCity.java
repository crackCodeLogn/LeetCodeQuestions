package leetcode.practise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vivek
 * @since 2023-12-15
 */
public class Q1436_E_DestinationCity {

    public String destCity(List<List<String>> paths) {
        Map<String, String> map = new HashMap<>();
        for (List<String> data : paths) {
            map.put(data.get(0), data.get(1));
        }
        String node = paths.get(0).get(0);
        while (map.containsKey(node)) {
            node = map.get(node);
        }
        return node;
    }
}
