import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] day = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int monthCnt = 1;
        int dateCnt = 0;
        int cnt = 0;

        while (x != monthCnt ||  y != dateCnt) {
            switch (monthCnt) {
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    dateCnt++;
                    cnt++;
                    if (dateCnt == 32) {
                        monthCnt++;
                        dateCnt = 1;
                    }
                    break;

                case 2:
                    dateCnt++;
                    cnt++;
                    if (dateCnt == 29) {
                        monthCnt++;
                        dateCnt = 1;
                    }
                    break;

                case 4: case 6: case 9: case 11:
                    dateCnt++;
                    cnt++;
                    if (dateCnt == 31) {
                        monthCnt++;
                        dateCnt = 1;
                    }
                    break;
            }
        }

        bw.write(day[cnt % 7]);

        br.close();

        bw.flush();
        bw.close();
    }
}