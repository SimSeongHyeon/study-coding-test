class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i <= number; i++) {
            int div = 0;
            
            for (int j = 1; j * j <= i; j++) {
                if (j * j == i) div++;
                else if (i % j == 0) div += 2;
            }
            
            if (div <= limit) answer += div;
            else answer += power;
        }
        return answer;
    }
}