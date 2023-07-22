import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(st.nextToken());

        int hmdstc = 0;

        StringBuilder sb = new StringBuilder();

        String[] str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = br.readLine();
        }

        for (int i = 0; i < M; i++) {
            String atgc = "";
            for (int j = 0; j < N; j++) {
                atgc += str[j].charAt(i);
            }
            sb.append(DNA(atgc));
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (str[i].charAt(j) != sb.charAt(j)) hmdstc++;
            }
        }
        
        System.out.println(sb);
        System.out.println(hmdstc);
    }

    static Character DNA (String str) {
        int sumA = 0;
        int sumT = 0;
        int sumG = 0;
        int sumC = 0;

        for (int i = 0; i < str.length(); i++) {
            switch (str.charAt(i)) {
                case 'A':
                    sumA++;
                    break;
                case 'T':
                    sumT++;
                    break;
                case 'G':
                    sumG++;
                    break;
                case 'C':
                    sumC++;
                    break;
            }
        }

        int max = sumT;
        char dna = 'T';

        if (sumG >= max) {
            max = sumG;
            dna = 'G';
        }

        if (sumC >= max) {
            max = sumC;
            dna = 'C';
        }

        if (sumA >= max) {
            dna = 'A';
        }

        return dna;
    }
}