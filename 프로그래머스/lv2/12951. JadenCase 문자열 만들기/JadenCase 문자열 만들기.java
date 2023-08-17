class Solution {
    public String solution(String s) {
        String answer = "";
        
        String[] words = s.split(" ");
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() == 0) answer += " ";

            else {
                answer += words[i].substring(0, 1).toUpperCase();
                answer += words[i].substring(1, words[i].length()).toLowerCase();
                answer += " ";
            }
        }
        
        if (s.charAt(s.length() - 1) == ' ') return answer;
        return answer.substring(0, answer.length() - 1);
    }
}