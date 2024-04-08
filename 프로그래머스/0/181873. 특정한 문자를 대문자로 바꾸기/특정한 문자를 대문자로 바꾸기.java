class Solution {
    public String solution(String my_string, String alp) {
        StringBuilder answer = new StringBuilder();
        
        for (int i = 0; i < my_string.length(); i++) {
            if (String.valueOf(my_string.charAt(i)).equals(alp)) {
                answer.append(String.valueOf(my_string.charAt(i)).toUpperCase());
            } else {
                answer.append(String.valueOf(my_string.charAt(i)));
            }
        }
        return String.valueOf(answer);
    }
}