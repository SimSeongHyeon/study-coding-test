import java.io.*;
import java.util.ArrayList;

public class Main {
     public static void main(String[] args) throws IOException {
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         int M = Integer.parseInt(br.readLine());
         int N = Integer.parseInt(br.readLine());
         ArrayList<Integer> ls = new ArrayList<>();

         for (int i = M; i <= N; i++) {
             for (int j = 1; j <= i; j++) {
                 if (j * j == i) {
                     ls.add(i);
                     break;
                 }
             }
         }

         int sum = 0;

         if (ls.isEmpty()) bw.write("-1");
         else {
             for (int i = 0; i < ls.size(); i++) {
                 sum += ls.get(i);
             }
             bw.write(sum + "\n");
             bw.write(ls.get(0) + "");
         }

         br.close();

         bw.flush();
         bw.close();
     }
}