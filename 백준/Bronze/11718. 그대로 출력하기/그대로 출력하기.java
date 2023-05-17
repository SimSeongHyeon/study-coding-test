import javax.lang.model.element.NestingKind;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";

        while ((str = br.readLine()) != null) {
            bw.write(str + "");
            bw.newLine();
        }

        br.close();

        bw.flush();
        bw.close();
    }
}
