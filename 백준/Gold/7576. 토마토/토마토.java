import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y, day;
        
        public Point(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int M = Integer.parseInt(st.nextToken()); // 가로 칸 수
        int N = Integer.parseInt(st.nextToken()); // 세로 칸 수
        
        int[][] box = new int[N][M];
        Queue<Point> queue = new LinkedList<>();
        int unripeCount = 0; // 익지 않은 토마토 개수
        
        // 상자 정보 입력 및 익은 토마토 위치 큐에 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(st.nextToken());
                if (box[i][j] == 1) {
                    queue.offer(new Point(i, j, 0)); // 익은 토마토는 0일째
                } else if (box[i][j] == 0) {
                    unripeCount++; // 익지 않은 토마토 개수 카운트
                }
            }
        }
        
        // 처음부터 모든 토마토가 익어있는 경우
        if (unripeCount == 0) {
            System.out.println(0);
            return;
        }
        
        // 상하좌우 방향 벡터
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int maxDay = 0;
        
        // BFS 실행
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            maxDay = Math.max(maxDay, current.day);
            
            // 상하좌우 4방향 확인
            for (int dir = 0; dir < 4; dir++) {
                int nx = current.x + dx[dir];
                int ny = current.y + dy[dir];
                
                // 범위를 벗어나거나 토마토가 없는 칸이거나 이미 익은 토마토인 경우 스킵
                if (nx < 0 || nx >= N || ny < 0 || ny >= M || box[nx][ny] != 0) {
                    continue;
                }
                
                // 익지 않은 토마토를 익게 만듦
                box[nx][ny] = 1;
                unripeCount--; // 익지 않은 토마토 개수 감소
                queue.offer(new Point(nx, ny, current.day + 1));
            }
        }
        
        // 모든 토마토가 익었는지 확인
        if (unripeCount == 0) {
            System.out.println(maxDay);
        } else {
            System.out.println(-1); // 익지 못한 토마토가 있는 경우
        }
    }
}