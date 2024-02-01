import java.util.*;

class Solution {
    public List solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int leftDay = (100 - progresses[i]) / speeds[i];
            
            if ((100 - progresses[i]) % speeds[i] > 0) {
                leftDay++;
            }
            
            queue.add(leftDay);
        }
        
        while (!queue.isEmpty()) {
            int frontOfQueue = queue.poll();
            
            int count = 1;
            
            while(!queue.isEmpty() && queue.peek() <= frontOfQueue) {
                queue.poll();
                
                count++;
            }
            
            answer.add(count);
        }
        
        return answer;
    }
}