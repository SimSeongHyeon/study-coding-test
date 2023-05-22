import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < N; i++){
            String str = br.readLine();
            if (isGrpWd(str)) cnt++;
        }

        bw.write(cnt + "");

        br.close();

        bw.flush();
        bw.close();
    }
    
    static boolean isGrpWd (String str) {
        char[] word = str.toCharArray();
        List<Character> aphb = new ArrayList<Character>();

        for (int i = 0; i < word.length; i++) {
            if (i < word.length - 1) {
                if (word[i] != word[i + 1]) aphb.add(word[i]);
                else if (word[i] == word[i + 1]) {
                    for (int j = i + 1; j < word.length; j++) {
                        if (word[i] != word[j]) {
                            aphb.add(word[i]);
                            i = j - 1;
                            break;
                        }
                    }
                }
            }
            else aphb.add(word[i]);
        }

        for (int j = 0; j < aphb.size() - 1; j++) {
            for (int k = j + 1; k < aphb.size(); k++) {
                    if (aphb.get(j).equals(aphb.get(k))) return false;
            }
        }
        return true;
    }
}