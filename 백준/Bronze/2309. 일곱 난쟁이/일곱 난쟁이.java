import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> dwarf = new ArrayList<>();
        int sum = 0;
        boolean check = false;

        for (int i = 0; i < 9; i++) {
            dwarf.add(Integer.parseInt(br.readLine()));
            sum += dwarf.get(i);
        }

        for (int i = 0; i < dwarf.size() - 1; i++) {
            for (int j = i + 1; j < dwarf.size(); j++) {
                if (sum - dwarf.get(i) - dwarf.get(j) == 100) {
                    dwarf.remove(i);
                    dwarf.remove(j - 1);
                    Collections.sort(dwarf);
                    check = true;
                    break;
                }
            }
            if (check) break;
        }

        for (int val : dwarf) {
            bw.write(val + "\n");
        }

        br.close();

        bw.flush();
        bw.close();
    }
}