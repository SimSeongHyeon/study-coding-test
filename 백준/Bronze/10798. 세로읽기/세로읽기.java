import java.io.*;
import java.rmi.activation.ActivationGroup_Stub;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Character[][] characters = new Character[5][15];

        int max = 0;

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();

            max = Math.max(max, str.length());

            for (int j = 0; j < str.length(); j++) {
                characters[i][j] = str.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (characters[j][i] != null) sb.append(characters[j][i]);
            }
        }

        System.out.println(sb);
    }
}