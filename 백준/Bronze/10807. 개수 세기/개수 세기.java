import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int searchNum = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int j = 0; j < N; j++) {
            if(arr[j] == searchNum) cnt++;
        }
        bw.write(cnt + "");

        br.close();

        bw.flush();
        bw.close();
    }
}

