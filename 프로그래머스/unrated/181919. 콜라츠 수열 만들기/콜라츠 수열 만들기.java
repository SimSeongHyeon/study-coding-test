import java.util.*;

class Solution {
    public List solution(int n) {
        List answer = new ArrayList<>();
        
        answer.add(n);
        
        while (n > 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = 3 * n + 1;
            }
            answer.add(n);    
        }
        return answer;
    }
}