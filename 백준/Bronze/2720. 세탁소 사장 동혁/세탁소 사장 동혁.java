import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int C = Integer.parseInt(br.readLine());
            int[] coins = new int[4];

            coins[0] = C / 25;
            coins[1] = C % 25 / 10;
            coins[2] = C % 25 % 10 / 5;
            coins[3] = C % 25 % 10 % 5;

            for(int j = 0; j < coins.length; j++) {
                bw.write(coins[j] + " ");
            }
            bw.newLine();
        }

        br.close();

        bw.flush();
        bw.close();
    }
}