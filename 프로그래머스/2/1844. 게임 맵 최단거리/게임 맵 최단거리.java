import java.util.*;

class Solution {
    
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    static void bfs (int[][] maps, int[][] visited) {
        
        visited[0][0] = 1;
        
        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{0, 0});
        
        while (!queue.isEmpty()) {
            
            int[] current = queue.poll();
            
            int cx = current[0];
            int cy = current[1];
            
            for (int i = 0; i < 4; i++) {
                
                int nx = cx + dc[i];
                int ny = cy + dr[i];
                
                if (nx < 0 || ny < 0 || nx >= maps.length || ny >= maps[0].length) {
                    continue;
                }
                
                if (visited[nx][ny] == 0 && maps[nx][ny] == 1) {
                    
                    visited[nx][ny] = visited[cx][cy] + 1;
                    
                    queue.add(new int[] {nx, ny});
                }
            }
        }
    }
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        int[][] visited = new int[maps.length][maps[0].length];
        
        bfs(maps, visited);
        
        answer = visited[maps.length - 1][maps[0].length - 1];
        
        if (answer == 0) {
            answer = -1;
        }
        
        return answer;
    }
}