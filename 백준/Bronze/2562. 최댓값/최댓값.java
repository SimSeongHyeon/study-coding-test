import java.io.*;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int[] arrSort = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            arrSort[i] = arr[i];
        }

        Arrays.sort(arrSort);

        for (int i = 0; i < 9; i++) {
            if(arrSort[8] == arr[i]) {
                bw.write(arr[i] + "");
                bw.newLine();
                bw.write(i + 1 + "");
            }
        }
        br.close();

        bw.flush();
        bw.close();
    }
}