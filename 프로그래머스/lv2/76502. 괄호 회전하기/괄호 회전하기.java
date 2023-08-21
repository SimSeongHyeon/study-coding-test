import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            s = lotLeft(s);
            if (isRight(s)) answer++;
        }
        return answer;
    }
    
    public static String lotLeft(String str) {
        String left = str.substring(0, 1);
        String right = str.substring(1);
        return right + left;
    }
    
    public static boolean isRight (String str) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            }
            
            else {
                if (stack.empty()) return false;
                else if (stack.peek() == '(' && str.charAt(i) == ')') stack.pop();
                else if (stack.peek() == '{' && str.charAt(i) == '}') stack.pop();
                else if (stack.peek() == '[' && str.charAt(i) == ']') stack.pop();
            }
        }
        
        if (!stack.empty()) return false;
        else return true;
    }
}