class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] addNums = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        for (int i = 0; i < a - 1; i++) {
            b += addNums[i];
        }        
        
        if (b % 7 - 1 < 0) answer = days[6]; 
        else answer = days[b % 7 - 1]; 
                
        return answer;    
    }
}