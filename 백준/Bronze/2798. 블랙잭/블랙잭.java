import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] cardNum = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cardNum[i] = Integer.parseInt(st.nextToken());
        }

        int answer = searchBJ(cardNum, N, M);

        bw.write(answer + "");

        br.close();

        bw.flush();
        bw.close();
    }

    static int searchBJ (int[] cardNum, int N, int M) {
        int sum = 0;
        int temp = 0;
        for(int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    sum = cardNum[i] + cardNum[j] + cardNum[k];

                    if (sum == M) return sum;

                    else if (sum < M && temp < sum) {
                        temp = sum;
                    }
                }
            }
        }
        return temp;
    }
}