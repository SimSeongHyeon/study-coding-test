class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int currentNumber = storey % 10;
            storey /= 10;
        
            if (currentNumber < 5) {
                answer += currentNumber;
            } else if (currentNumber == 5) {
                if (storey % 10 > 4) {
                    answer += 10 - currentNumber;
                    storey++;
                } else {
                    answer += currentNumber;
                }
            } else {
                answer += 10 - currentNumber;
                storey++;
            }
        }        
        return answer;
    }
}