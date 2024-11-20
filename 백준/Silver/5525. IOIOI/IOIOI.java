import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        String S = bufferedReader.readLine();

        String P = getP(N);

        int count = getCount(S, P);

        System.out.println(count);
    }

    static String getP(int N) {
        StringBuilder P = new StringBuilder();

        for (int i = 0; i < N; i++) {
            P.append("I").append("O");
        }

        P.append("I");

        return String.valueOf(P);
    }

    static int getCount(String string, String P) {
        int count = 0;

        for (int i = 0; i <= string.length() - P.length(); i++) {
            if (string.startsWith(P, i)) {
                count++;
            }
        }

        return count;
    }

}