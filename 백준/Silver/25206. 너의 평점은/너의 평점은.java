import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        double creditSum = 0;
        double gradeSum = 0;
        double gradePoint = 0;
        double avg = 0.;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());

            String sub = st.nextToken();
            double credit= Float.parseFloat(st.nextToken());
            String grade = st.nextToken();

            double scr = 0;

            if (grade.equals("A+")) gradePoint = 4.5;
            else if (grade.equals("A0")) gradePoint = 4.0;
            else if (grade.equals("B+")) gradePoint = 3.5;
            else if (grade.equals("B0")) gradePoint = 3.0;
            else if (grade.equals("C+")) gradePoint = 2.5;
            else if (grade.equals("C0")) gradePoint = 2.0;
            else if (grade.equals("D+")) gradePoint = 1.5;
            else if (grade.equals("D0")) gradePoint = 1.0;
            else if (grade.equals("F")) gradePoint = 0.0;

            if (!grade.equals("P")) {
                creditSum = creditSum + credit;
                scr = credit * gradePoint;
            }

            gradeSum = gradeSum + scr;
        }

        avg = gradeSum / creditSum;

        System.out.printf("%.6f", avg);

        br.close();

        bw.flush();
        bw.close();
    }
}