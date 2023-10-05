import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        String[] temp = new String[strings.length];
        
        for (int i = 0; i < strings.length; i++) {
            temp[i] = strings[i].charAt(n) + strings[i];
        }
        
        Arrays.sort(temp);
        
        for(int i = 0; i < strings.length; i++) {
            answer[i] = temp[i].substring(1, temp[i].length());
        }
        
        return answer;
    }
}