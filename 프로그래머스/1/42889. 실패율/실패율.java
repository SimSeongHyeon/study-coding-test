import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer, Double> map = new HashMap<>();
        
        for (int i = 1; i <= N; i++) {
            double notPass = 0;
            double total = 0;
            
            for (int j = 0; j < stages.length; j++) {
                if (i == stages[j]) notPass++;
                if (i <= stages[j]) total++;
            }
            
            if (notPass == 0) total = 1;
            
            map.put(i, notPass / total);
        }
        
        int[] answer = new int[N];
        
        for (int i = 0; i < N; i++) {
            double max = -1;
            int val = 0;
            
            for (int key : map.keySet()) {
                if (max < map.get(key)) {
                    max = map.get(key);
                    val = key;
                }
            }
            
            answer[i] = val;
            map.remove(val);
        }
        
        return answer;
    }
}