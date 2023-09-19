class Solution {
    public String solution(String s) {
        String answer = "";
        
        int idx = s.length() / 2;
        
        answer = s.length() % 2 == 0 ? s.substring(idx - 1, idx + 1) : s.substring(idx, idx + 1);
        
        return answer;
    }
}