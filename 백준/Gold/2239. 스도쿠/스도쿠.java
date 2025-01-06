import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] sudoku = new int[9][9];

        sudoku = init();

        solve(sudoku, 0, 0);
    }

    static int[][] init() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int[][] sudoku = new int[9][9];

        for (int row = 0; row < 9; row++) {
            String line = bufferedReader.readLine();
            for (int column = 0; column < 9; column++) {
                sudoku[row][column] = line.charAt(column) - '0';
            }
        }

        return sudoku;
    }

    static void solve(int[][] sudoku, int row, int column) {
        if (column == 9) {
            solve(sudoku, row + 1, 0);
            return;
        }

        if (row == 9) {
            printSudoku(sudoku);
            System.exit(0);
        }

        if (sudoku[row][column] == 0) {
            for (int num = 1; num <= 9; num++) {
                if (isValid(sudoku, row, column, num)) {
                    sudoku[row][column] = num;
                    solve(sudoku, row, column + 1);
                }
            }

            sudoku[row][column] = 0;

            return;
        }

        solve(sudoku, row, column + 1);
    }

    static boolean isValid(int[][] sudoku, int row, int column, int num) {
        return isRowValid(sudoku, row, num) && isColumnValid(sudoku, column, num) && isBoxValid(sudoku, row, column, num);
    }

    static boolean isRowValid(int[][] sudoku, int row, int num) {
        for (int column = 0; column < 9; column++) {
            if (sudoku[row][column] == num) {
                return false;
            }
        }

        return true;
    }

    static boolean isColumnValid(int[][] sudoku, int column, int num) {
        for (int row = 0; row < 9; row++) {
            if (sudoku[row][column] == num) {
                return false;
            }
        }

        return true;
    }

    static boolean isBoxValid(int[][] sudoku, int row, int column, int num) {
        int startRow = row / 3 * 3;
        int startColumn = column / 3 * 3;

        for (int boxRow = startRow; boxRow < startRow + 3; boxRow++) {
            for (int boxColumn = startColumn; boxColumn < startColumn + 3; boxColumn++) {
                if (sudoku[boxRow][boxColumn] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    static void printSudoku(int[][] sudoku) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                stringBuilder.append(sudoku[row][column]);
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }

}