import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1) {
                switch (str.charAt(i)) {
                    case 'c':
                        if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') i++;
                        break;
                    case 'd':
                        if (i < str.length() - 2 && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') i += 2;
                        else if (str.charAt(i + 1) == '-') i++;
                        break;
                    case 'l': case 'n':
                        if (str.charAt(i + 1) == 'j') i++;
                        break;
                    case 's': case 'z':
                        if (str.charAt(i + 1) == '=') i++;
                        break;
                }
            }
            count++;
        }

        bw.write(count + "");

        br.close();

        bw.flush();
        bw.close();
    }
}