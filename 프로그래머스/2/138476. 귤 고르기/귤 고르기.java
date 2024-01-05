import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int sum = 0;
        int cnt = 0;
        
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        ArrayList<Integer> list = new ArrayList<>(map.values());
        
        Collections.sort(list, Collections.reverseOrder());
        
        for (int v : list) {
            if (sum + v >= k) {
                cnt++;
                break;
            } else {
                sum += v;
                cnt++;
            }
        }
        return cnt;
    }
}