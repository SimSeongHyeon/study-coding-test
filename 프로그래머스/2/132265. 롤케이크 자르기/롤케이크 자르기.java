import java.util.HashMap;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        int[] left = new int[10001];
        int[] right = new int[10001];
        
        int leftCount = 0;
        int rightCount = 0;
        
        for (int i = 0; i < topping.length; i++) {
            right[topping[i]]++;
        }
        
        for (int i = 0; i < right.length; i++) {
            if (right[i] != 0) {
                rightCount++; // 4
            }
        }
        
        for (int i = 0; i < topping.length; i++) {
            int type = topping[i];
            
            left[type]++;
            
            right[type]--;
            
            if (right[type] == 0) {
                rightCount--;
            }
            
            if (left[type] == 1) {
                leftCount++;
            }
            
            if (leftCount == rightCount) {
                answer++;
            }
        }
        
        
        
        return answer;
    }
}