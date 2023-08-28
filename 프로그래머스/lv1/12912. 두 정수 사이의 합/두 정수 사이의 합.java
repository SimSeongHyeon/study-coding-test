class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        
        int temp = a;
        
        a = Math.min(a, b);
        b = Math.max(temp, b);
        
        for (int i = a; i <= b; i++) {
            answer += i;
        }
        return answer;
    }
}