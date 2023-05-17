import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //배열의 길이
        int M = Integer.parseInt(st.nextToken()); //넣을 횟수

        int[] arr = new int[N];

        for (int a = 0; a < M; a++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int startBox = i;
            for (int b = 0; b < j - i + 1; b++) {
                arr[startBox-1] = k;
                startBox++;
            }
        }

        for(int c = 0; c < arr.length; c++) {
            bw.write(arr[c] + " ");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}