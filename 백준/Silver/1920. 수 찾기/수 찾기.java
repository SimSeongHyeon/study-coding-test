import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] nNums = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nNums[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        int[] mNums = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            mNums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nNums);

        for (int i = 0; i < M; i++) {
            if (findNum(nNums, mNums[i]) == -1) sb.append("0\n");
            else sb.append("1\n");
        }

        System.out.println(sb);
    }

    public static int findNum(int[] nNums, int mNums) {
        int loIdx = 0;
        int hiIdx = nNums.length - 1;
        int midIdx = (loIdx + hiIdx) / 2;
        int cnt = 0;

        while (loIdx <= hiIdx) {
            if (mNums < nNums[midIdx]) {
                hiIdx = midIdx;
                midIdx = (loIdx + hiIdx) / 2;
//                hiIdx = midIdx - 1;
                cnt++;
            }

            else if (mNums > nNums[midIdx]) {
                loIdx = midIdx;
                if ((loIdx + hiIdx) % 2 == 0) midIdx = (loIdx + hiIdx) / 2;
                else midIdx = (loIdx + hiIdx + 1) / 2;
//                loIdx = midIdx + 1;
                cnt++;
            }

            else {
                return midIdx;
            }
            
            if (cnt > 17) return -1;
        }
        return -1;
    }
}