import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int A = 0;
        int B = 0;
        int C = 0;

        StringBuilder sb = new StringBuilder();

        while (T > 0) {
            if (T >= 300) {
                T = T - 300;
                A++;
            }

            else if (T >= 60) {
                T = T - 60;
                B++;
            }

            else if (T >= 10){
                T = T - 10;
                C++;
            }

            else if (10 > T && T > 0) {
                System.out.println("-1");
                return;
            }
        }

        sb.append(A + " ").append(B + " ").append(C + " ");

        System.out.println(sb);
    }
}