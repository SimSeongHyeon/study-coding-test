class Solution {
    public int[] solution(String s) {
        String[] spelling = s.split("");
        int[] answer = new int[s.length()];
        
        for (int i = 0; i < s.length(); i++) {
            int cnt = 0;
            
            for (int j = 0; j < i; j++) {
                if (spelling[i].equals(spelling[j])) cnt = i - j;
            }
            
            if (cnt == 0) cnt = -1;
            
            answer[i] = cnt;
        }
        
        return answer;
    }
}