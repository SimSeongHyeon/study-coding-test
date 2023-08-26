class Solution {
    public String solution(String phone_number) {
        String str = "";
        
        for (int i = 0; i < phone_number.length() - 4; i++) {
            str += "*";     
            }
        
        String answer = str + phone_number.substring(phone_number.length() - 4);
        return answer;
    }
}