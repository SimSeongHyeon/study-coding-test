import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] abt = s.toCharArray();
        
        Arrays.sort(abt);
        
        for (int i = abt.length - 1; i >= 0; i--) {
            answer += abt[i]; 
        }
        
        return answer;
    }
}