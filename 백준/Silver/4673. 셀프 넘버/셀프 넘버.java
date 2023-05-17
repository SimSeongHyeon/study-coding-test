import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
//
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

        boolean arr[] = new boolean[10001];
        for(int i = 0; i < 10000; i++) {
            if(notSelfnum(i) <= 10000) arr[notSelfnum(i)] = true;
        }

        for(int j = 0; j <= 10000; j++){
            if(!arr[j]) {
                bw.write(j + "");
                bw.newLine();
            }
            bw.flush();
        }
    }

    static int notSelfnum(int i) {
        int sum = i;
        while(i > 0){
            sum = sum + i % 10;
            i = i / 10;
        }
        return sum;
    }
}
