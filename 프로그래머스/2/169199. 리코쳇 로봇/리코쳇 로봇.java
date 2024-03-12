import java.util.Queue;
import java.util.LinkedList;

class Solution {
    
    static int n, m;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    
    public int solution(String[] board) {
        int answer = 0;
        
        n = board.length;
        m = board[0].length();
        
        Travel robot = null;
        Travel goal = null;
        
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i].charAt(j) == 'R') {
                    robot = new Travel(i, j, 0);
                }
                
                if (board[i].charAt(j) == 'G') {
                    goal = new Travel(i, j, 0);
                }
            }
        }
        
        answer = bfs(board, robot, goal);
        
        return answer;
    }
    
    static int bfs(String[] board, Travel robot, Travel goal) {
        Queue<Travel> queue = new LinkedList<>();
        
        queue.add(robot);
        
        boolean[][] visited = new boolean[n][m];
        
        visited[robot.x][robot.y] = true;
        
        while(!queue.isEmpty()) {
            Travel current = queue.poll();
            
            if (current.x == goal.x && current.y == goal.y) {
                return current.count;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = current.x;
                int ny = current.y;
                
                while (isValidRange(nx, ny) && board[nx].charAt(ny) != 'D') {
                    nx += dr[i];
                    ny += dc[i];
                }
                
                nx -= dr[i];
                ny -= dc[i];
                
                if (visited[nx][ny]) {
                    continue;
                }
                
                if (current.x == nx && current.y == ny) {
                    continue;
                }
                
                visited[nx][ny] = true;
                
                queue.add(new Travel(nx, ny, current.count + 1));
            }
        }
        
        return -1;
    }
    
    static boolean isValidRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m; 
    }
    
    static class Travel {
        int x;
        int y;
        int count;
        
        public Travel(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}