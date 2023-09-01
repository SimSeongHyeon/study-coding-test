class Solution {
    public String solution(int n) {
        String answer = "";
        while (n > 0) {
            answer += "수";
            n--;
            
            if (n == 0) return answer;
            
            answer += "박";
            n--;
        }
        return answer;
    }
}