import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int isRight = 1;

        String word = br.readLine();

        int half = word.length() / 2 - 1;
        for (int i = 0; i <= half; i++) {
            if(word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                isRight = 0;
                break;
            }
        }

        bw.write(isRight + "");

        br.close();

        bw.flush();
        bw.close();
    }
}