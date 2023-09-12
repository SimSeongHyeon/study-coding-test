class Solution {
    public String solution(int[] food) {
        String answer = "";
        
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                answer += String.valueOf(i);
            }
        }
        
        StringBuffer sb = new StringBuffer(answer);
    
        answer += "0";

        answer += sb.reverse().toString();
        
        return answer;
    }
}