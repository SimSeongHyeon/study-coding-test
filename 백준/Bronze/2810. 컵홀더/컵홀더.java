import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String seats = br.readLine();

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            if (seats.charAt(i) == 'S') cnt++;
            else if (seats.charAt(i) == 'L') {
                cnt++;
                i++;
            }
        }
        System.out.println(Math.min(N, cnt + 1));
    }
}