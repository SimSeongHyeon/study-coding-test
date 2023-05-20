import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[8];
        int is = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] + 1 == num[i + 1]) is = 1;
            else if (num[i] - 1 == num[i + 1]) is = -1;
            else
            {
                is = 0;
                break;
            }
        }

        if (is == 1) bw.write("ascending");
        else if (is == 0) bw.write("mixed");
        else if (is == -1) bw.write("descending");

        br.close();

        bw.flush();
        bw.close();
    }
}