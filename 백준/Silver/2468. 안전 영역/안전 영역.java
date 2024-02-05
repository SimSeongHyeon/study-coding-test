import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//DFS
public class Main {

	static int N, result=1;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {1,-1,0,0};
	static int[] dc = {0,0,1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		int max = 0; //지형의 최고 높이
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>max) max = map[i][j];
			}
		}//input
		
		for (int h = 1; h <= max; h++) {
			init(); //visited배열 초기화

			int cnt = 0;		
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]>h && !visited[i][j]) {//안전지대 발견
						cnt++;
						dfs(i,j,h);
					}
				}
			}
			result = Math.max(cnt, result);
		}
		System.out.println(result);
	}//end of main
	
	private static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j]=false;
			}
		}
	}//end of init
	
	private static void dfs(int r, int c, int h) {
		visited[r][c]=true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
				
			// exception
			if(nr<0||nc<0||nr>=N||nc>=N||
					//물에 잠기거나 이미 확인한 곳이면 체크하지 않는다
					map[nr][nc]<=h||visited[nr][nc]) continue;

			dfs(nr,nc,h);
		}
	}
}