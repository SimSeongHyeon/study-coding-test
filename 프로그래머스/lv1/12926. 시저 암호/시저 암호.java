class Solution {
    public String solution(String s, int n) {
        String answer = "";
        
        for (char c : s.toCharArray()) {
            if (Character.isLowerCase(c)) {
                char shiftedChar = (char) (((c - 'a' + n) % 26) + 'a');
                answer += shiftedChar;
            }
            else if (Character.isUpperCase(c)) {
                char shiftedChar = (char) (((c - 'A' + n) % 26) + 'A');
                answer += shiftedChar;
            }
            
            else answer += " ";
        }
        return answer;
    }
}