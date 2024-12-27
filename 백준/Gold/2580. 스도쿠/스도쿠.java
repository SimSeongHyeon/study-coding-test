import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] sudoku;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer;

        sudoku = new int[9][9];

        for (int i = 0; i < 9; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        getSudoku(0, 0);
    }

    static void getSudoku(int row, int col) {
        if (col == 9) {
            getSudoku(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder stringBuilder = new StringBuilder();

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    stringBuilder.append(sudoku[i][j]).append(" ");
                }
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder.toString().trim());

            System.exit(0);
        }

        if (sudoku[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (isValid(i, row, col)) {
                    sudoku[row][col] = i;
                    getSudoku(row, col + 1);
                }
            }
            sudoku[row][col] = 0;

            return;
        }
        getSudoku(row, col + 1);
    }

    static boolean isValid(int num, int x, int y) {
        return isValidInSquare(num, x, y) && isValidInRow(num, y) && isValidInCol(num, x);
    }

    static boolean isValidInSquare(int num, int x, int y) {
        int row = x / 3 * 3;
        int col = y / 3 * 3;

        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (sudoku[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean isValidInRow(int num, int y) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][y] == num) {
                return false;
            }
        }

        return true;
    }

    static boolean isValidInCol(int num, int x) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[x][i] == num) {
                return false;
            }
        }

        return true;
    }

}