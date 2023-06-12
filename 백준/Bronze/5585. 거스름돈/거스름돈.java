import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int price = Integer.parseInt(br.readLine());
        int change = 1000 - price;
        int cnt = 0;

        while (change != 0) {
            if (change >= 500) {
                change = change - 500;
                cnt++;
            }
            else if (change >= 100) {
                change = change - 100;
                cnt++;
            }
            else if (change >= 50) {
                change = change - 50;
                cnt++;
            }
            else if (change >= 10) {
                change = change - 10;
                cnt++;
            }
            else if (change >= 5) {
                change = change - 5;
                cnt++;
            }
            else  if (change >= 1) {
                change = change - 1;
                cnt++;
            }
        }

        bw.write(cnt + "");

        br.close();

        bw.flush();
        bw.close();
    }
}