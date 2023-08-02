import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        String[] X = str.split("\\.", -1);

        for (int i = 0; i < X.length; i++) {
            if (X[i].length() % 2 == 1) {
                System.out.println("-1");
                return;
            }

            else {
                int lengthX = X[i].length();

                while (lengthX >= 4) {
                    sb.append("AAAA");
                    lengthX -= 4;
                }

                while (lengthX >= 2) {
                    sb.append("BB");
                    lengthX -= 2;
                }
            }

            if (i < X.length - 1) {
                sb.append(".");
            }
        }

        System.out.println(sb);
    }
}