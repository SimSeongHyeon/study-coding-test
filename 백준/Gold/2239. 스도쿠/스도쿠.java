import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] sudoku = readSudoku();
        solveSudoku(sudoku, 0, 0);
    }

    static int[][] readSudoku() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[][] sudoku = new int[9][9];

        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            String line = bufferedReader.readLine();
            for (int colIndex = 0; colIndex < 9; colIndex++) {
                sudoku[rowIndex][colIndex] = line.charAt(colIndex) - '0';
            }
        }

        return sudoku;
    }

    static boolean solveSudoku(int[][] sudoku, int rowIndex, int colIndex) {
        // 다음 행으로 이동
        if (colIndex == 9) {
            return solveSudoku(sudoku, rowIndex + 1, 0);
        }

        // 모든 행을 탐색 완료
        if (rowIndex == 9) {
            printSudoku(sudoku);
            return true; // 성공적으로 해결
        }

        // 빈 칸인 경우 1부터 9까지 시도
        if (sudoku[rowIndex][colIndex] == 0) {
            for (int num = 1; num <= 9; num++) {
                if (isValid(sudoku, rowIndex, colIndex, num)) {
                    sudoku[rowIndex][colIndex] = num;
                    if (solveSudoku(sudoku, rowIndex, colIndex + 1)) {
                        return true; // 해결 완료 시 반환
                    }
                    sudoku[rowIndex][colIndex] = 0; // 백트래킹
                }
            }
            return false; // 가능한 숫자가 없으면 실패
        }

        // 빈 칸이 아닌 경우 다음 칸으로 이동
        return solveSudoku(sudoku, rowIndex, colIndex + 1);
    }

    static boolean isValid(int[][] sudoku, int rowIndex, int colIndex, int num) {
        // 행 검사
        for (int i = 0; i < 9; i++) {
            if (sudoku[rowIndex][i] == num) {
                return false;
            }
        }

        // 열 검사
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][colIndex] == num) {
                return false;
            }
        }

        // 3x3 박스 검사
        int startRow = (rowIndex / 3) * 3;
        int startCol = (colIndex / 3) * 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (sudoku[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    static void printSudoku(int[][] sudoku) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for (int colIndex = 0; colIndex < 9; colIndex++) {
                stringBuilder.append(sudoku[rowIndex][colIndex]);
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }
}
