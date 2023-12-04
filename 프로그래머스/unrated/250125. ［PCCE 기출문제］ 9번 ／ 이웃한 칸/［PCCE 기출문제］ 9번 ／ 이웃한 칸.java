class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dh = {1, -1, 0, 0};
        int[] dw = {0, 0, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            
            if ((0 <= h_check && h_check < board.length) && (0 <= w_check && w_check < board[0].length)) {
                if (board[h][w].equals(board[h_check][w_check])) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}