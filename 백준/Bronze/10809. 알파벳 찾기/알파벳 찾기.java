import javax.lang.model.element.NestingKind;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        String word = br.readLine();
        int[] comp = new int[alphabet.length()];

        for (int a = 0; a < alphabet.length(); a++) {
           comp[a] = -1;
        }

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < alphabet.length(); j++) {
                if (word.charAt(i) == alphabet.charAt(j)) {
                    if(comp[j] == -1) comp[j] = i;
                }
            }
        }
        for (int v : comp) {
            bw.write(v + " ");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
