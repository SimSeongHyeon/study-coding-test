import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        String S = bufferedReader.readLine();

        System.out.println(getPatternCount(S, N));
    }

    static int getPatternCount(String S, int N) {
        int count = 0;
        int patternLength = 0; // 현재 IOI 반복 횟수 저장

        for (int i = 1; i < S.length() - 1; i++) {
            // IOI 패턴 확인
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                patternLength++; // IOI 발견 시 길이 증가
                if (patternLength == N) {
                    count++; // PN 발견 시 카운트 증가
                    patternLength--; // 겹치는 패턴을 위해 길이 감소
                }
                i++; // IOI는 3칸씩 처리되므로 한 칸 추가 이동
            } else {
                patternLength = 0; // 패턴 깨지면 초기화
            }
        }

        return count;
    }
}