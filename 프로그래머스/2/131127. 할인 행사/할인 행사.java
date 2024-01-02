import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        int sum = 10;
        
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - sum; i++) {
            Map<String, Integer> compMap = new HashMap<>();
            
            for (int j = i; j < i + sum; j++) {
                compMap.put(discount[j], compMap.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean flag = true;
            
            for (String str : map.keySet()) {
                if (!map.get(str).equals(compMap.get(str))) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                answer++;
            }
        }
        
        return answer;
    }
}