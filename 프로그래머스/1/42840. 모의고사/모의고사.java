import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
        
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        for(int i = 0; i < answers.length; i++){
            if(supo1[i % supo1.length] == answers[i]) score1++;
            if(supo2[i % supo2.length] == answers[i]) score2++;
            if(supo3[i % supo3.length] == answers[i]) score3++;
        }
        
        int max = Math.max(score1, Math.max(score2, score3));
        
        ArrayList<Integer> arrls = new ArrayList<>();
        
        if(max == score1) arrls.add(1);
        if(max == score2) arrls.add(2);
        if(max == score3) arrls.add(3);
        
        int[] answer = new int[arrls.size()];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = arrls.get(i);
        }
        
        return answer;
    }
}