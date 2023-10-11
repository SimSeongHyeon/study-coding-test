class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split("");
        
        int idx = 0;
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(" ")) idx = 0;
            
            else if (idx % 2 == 0) {
                words[i] = words[i].toUpperCase();
                idx++;
            }
            
            else if (idx % 2 != 0) {
                words[i] = words[i].toLowerCase();
                idx++;
            }
            
            answer += words[i];
        }
        
    return answer;
    }
}