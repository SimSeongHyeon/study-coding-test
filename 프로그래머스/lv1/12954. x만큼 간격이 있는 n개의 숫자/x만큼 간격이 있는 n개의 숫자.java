class Solution {
    public long[] solution(long x, int n) {
        long[] answer = new long[n];
        long temp = x;
        for (int i = 0; i < n; i++) {
            answer[i] = x;
            x += temp;
        }
        return answer;
    }
}