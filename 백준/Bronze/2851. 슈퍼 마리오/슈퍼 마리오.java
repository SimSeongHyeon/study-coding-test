import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] scr = new int[10];
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < scr.length; i++) {
            scr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < scr.length; i++) {
            sum1 += scr[i];
            if (sum1 > 100) {

                for (int j =0; j < i; j++) {
                    sum2 += scr[j];
                }

                if (sum1 - 100 > 100 - sum2) bw.write(sum2 + "");
                else if (sum1 - 100 <= 100 - sum2) bw.write(sum1 + "");
                break;
            }

            else if (sum1 == 100){
                bw.write(sum1 + "");
                break;
            }
        }

        if (sum1 < 100) bw.write(sum1 + "");

        br.close();

        bw.flush();
        bw.close();
    }
}