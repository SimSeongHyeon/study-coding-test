import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] scr = new int[5];
        int sum = 0;

        for (int i = 0; i < scr.length; i++) {
            scr[i] = Integer.parseInt(br.readLine());
            if (scr[i] < 40) scr[i] = 40;
            sum += scr[i];
        }

        bw.write(sum / 5 + "");


        br.close();

        bw.flush();
        bw.close();
    }
}