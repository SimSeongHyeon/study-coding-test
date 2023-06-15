import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] weight = new int[N];
        int[] height = new int[N];

        int grade = 1;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (weight[i] < weight[j] && height[i] < height[j]) {
                    grade++;
                }
            }
            bw.write(grade + " ");
            grade = 1;
        }
        br.close();

        bw.flush();
        bw.close();
    }
}
