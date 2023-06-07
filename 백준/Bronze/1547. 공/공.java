import java.io.*;
import java.util.StringTokenizer;

public class Main {
     public static void main(String[] args) throws IOException {
         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         StringTokenizer st;

         int M = Integer.parseInt(br.readLine());
         int cup = 1;
         int X;
         int Y;

         for (int i = 0; i < M; i++) {
             st = new StringTokenizer(br.readLine());
             X = Integer.parseInt(st.nextToken());
             Y = Integer.parseInt(st.nextToken());

             if (cup == X) cup = Y;
             else if (cup == Y) cup = X;
         }

         bw.write(cup +"");



         br.close();

         bw.flush();
         bw.close();
     }
}
