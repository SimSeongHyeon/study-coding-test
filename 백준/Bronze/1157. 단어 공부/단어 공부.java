import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] alphabetCnt = new int[26];
        char same = '?';
        int max = 0;
        String word = br.readLine();

        for(int i = 0; i < word.length(); i++){
            if ('a' <= word.charAt(i) && word.charAt(i) <= 'z') {
                alphabetCnt[word.charAt(i) - 97]++;
            } else {
                alphabetCnt[word.charAt(i) - 65]++;
            }
        }

        for (int j = 0; j < alphabetCnt.length; j++) {
            if (alphabetCnt[j] > max) {
                max = alphabetCnt[j];
                same = (char) (j + 65);
            }
            else if (alphabetCnt[j] == max){
                same = '?';
            }
        }

        bw.write(same + "");

        br.close();

        bw.flush();
        bw.close();
    }
}
