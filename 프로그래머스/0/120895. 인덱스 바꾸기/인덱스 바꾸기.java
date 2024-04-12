class Solution {
    public String solution(String my_string, int num1, int num2) {
        StringBuilder answer = new StringBuilder();
        
        String s1 = String.valueOf(my_string.charAt(num1));
        String s2 = String.valueOf(my_string.charAt(num2));
        
        for (int i = 0; i < my_string.length(); i++) {
            if (i != num1 && i != num2) {
                answer.append(String.valueOf(my_string.charAt(i)));
            } else if (i == num1) {
                answer.append(s2);
            } else if (i == num2) {
                answer.append(s1);
            }
        }
        return String.valueOf(answer);
    }
}