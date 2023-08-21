class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int [2];
        
        int sum = brown + yellow;
        
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= sum; j++) {
                if (i * j == sum && (2 * j) + 2 * (i - 2) == brown) {
                    answer[0] = j;
                    answer[1] = i;
                    return answer;
                }
            }
        }
        return answer;
    }
}