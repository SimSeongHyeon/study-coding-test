class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for (int i = 1; i < land.length; i++) {
            land[i][0] += maxOfThree(land[i - 1][1], land[i - 1][2], land[i - 1][3]);
            land[i][1] += maxOfThree(land[i - 1][2], land[i - 1][3], land[i - 1][0]);
            land[i][2] += maxOfThree(land[i - 1][3], land[i - 1][0], land[i - 1][1]);
            land[i][3] += maxOfThree(land[i - 1][0], land[i - 1][1], land[i - 1][2]);
        }
        
        for (int i : land[land.length - 1]) {
            answer = Math.max(i, answer);
        }

        return answer;
    }
    
    public int maxOfThree (int i, int j, int k) {
        int max = 0;
        
        max = Math.max(Math.max(i, j), k);
        
        return max;
    }
}