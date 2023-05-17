import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] box = new int[N];
        int temp;

        for (int a = 0; a < N; a++){
            box[a] = a + 1;
        }

        for (int b = 0; b < M; b++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            for (int a = 0; a < box.length; a++) {
                if (i - 1 + a < j - 1 - a) {
                    temp = box[i - 1 + a];
                    box[i - 1 + a] = box[j - 1 - a];
                    box[j - 1 - a] = temp;
                }
            }
        }

        for (int d = 0; d < N; d++) {
            bw.write(box[d] + " ");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}