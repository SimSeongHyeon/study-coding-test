import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] num = new int[3];


        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        while (num[0] != 0 && num[1] != 0 && num[2] != 0) {
            Arrays.sort(num);

            if (num[2] * num[2] == num[0] * num[0] + num[1] * num[1]) {
                bw.write("right\n");
            }
            else bw.write("wrong\n");

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < num.length; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}