import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] std = new int[30];
        int[] submit = new int[28];


        for (int i = 0; i < std.length; i++) {
            std[i] = i + 1;
        }

        for (int j = 0; j < 28; j++) {
            submit[j] = Integer.parseInt(br.readLine());
            }

        for (int k = 0; k < std.length; k++) {
            boolean tf = false;
            for (int l = 0; l < submit.length; l++) {
                if(std[k] == submit[l]) {
                    tf = true;
                    break;
                }
            }
            if(tf == false) {
                bw.write(std[k] + "");
                bw.newLine();
            }
        }

        br.close();

        bw.flush();
        bw.close();
    }
}