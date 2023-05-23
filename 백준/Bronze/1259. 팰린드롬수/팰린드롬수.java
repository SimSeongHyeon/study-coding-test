import javax.management.StringValueExp;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int N = Integer.parseInt(br.readLine());
            String str = Integer.toString(N);

            if (str.equals("0")) break;

            if (isP(str)) bw.write("yes\n");
            else bw.write("no\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }

    static boolean isP (String str) {
        int[] asc = new int[str.length()];
        int[] des = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            asc[i] = str.charAt(i);
            des[i] = str.charAt(str.length() - i - 1);
        }

        for (int j = 0; j < str.length(); j++) {
            if (asc[j] != des[j]) return false;
        }
        return true;
    }
}