import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        Stack cards1_stack = new Stack <String>();
        Stack cards2_stack = new Stack <String>();
        Stack goal_stack = new Stack <String>();
        
        for (int i = cards1.length - 1; i >= 0; i--) {
            cards1_stack.push(cards1[i]);
        }
        
        for (int i = cards2.length - 1; i >= 0; i--) {
            cards2_stack.push(cards2[i]);
        }
        
        for (int i = goal.length - 1; i >= 0; i--) {
            goal_stack.push(goal[i]);
        }
        
        for (int i = 0; i < goal.length; i++) {
            if (!cards1_stack.empty() && goal_stack.peek().equals(cards1_stack.peek())) {
                goal_stack.pop();
                cards1_stack.pop();
            }
            
            else if (!cards2_stack.empty() && goal_stack.peek().equals(cards2_stack.peek())) {
                goal_stack.pop();
                cards2_stack.pop();
            }
            
            else {
                answer = "No";
                break;
            }
        }
        
        if (goal_stack.empty()) answer = "Yes";
        
        return answer;
    }
}