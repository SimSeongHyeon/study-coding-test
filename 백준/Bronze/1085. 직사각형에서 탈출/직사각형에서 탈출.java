import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int shtX = 0;
        int shtY = 0;
        int sht = 0;

        if (x >= w - x) shtX = w - x;
        else if (x < w - x) shtX = x;

        if (y >= h - y) shtY = h - y;
        else if (y < h - y) shtY = y;

        if (shtX >= shtY) sht = shtY;
        else sht = shtX;

        bw.write(sht + "");

        br.close();

        bw.flush();
        bw.close();
    }
}