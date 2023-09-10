class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String sub_t = t.substring(i, i + p.length());
            
            if (Long.parseLong(sub_t) <= Long.parseLong(p)) answer++;
        }
        return answer;
    }
}