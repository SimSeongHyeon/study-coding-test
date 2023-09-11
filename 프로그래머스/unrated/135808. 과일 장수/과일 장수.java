import java.util.Arrays;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        int box = score.length;
        
        Arrays.sort(score);
        
        for (int i = score.length - 1; i >= 0; i -= m) {
            if (box < m) {
                break;
            }
            
            else {
                answer += score[i - m + 1] * m;
            }
            
            box -= m;
        }
        return answer;
    }
}