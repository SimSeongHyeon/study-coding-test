import java.util.*;

class Solution {
    public int solution(long num) {
        if (num == 1) return 0;
        
        int answer = 0;
                
        while (answer <= 500) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = 3 * num + 1;
            }
        
            answer++;
            
            if (num == 1) return answer;
        }
        
        return -1;
    }
}