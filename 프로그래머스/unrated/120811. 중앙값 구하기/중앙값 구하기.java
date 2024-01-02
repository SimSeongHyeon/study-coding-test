import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        int len = array.length / 2;
        
        Arrays.sort(array);
        
        answer = array[len];
        
        return answer;
    }
}