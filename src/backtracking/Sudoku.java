package backtracking;

/**
 * Created by qgg on 2018/1/1.
 */
public class Sudoku {

    private final static int LENGTH = 9;
//    private int[][] array = new int[LENGTH][LENGTH];//找出所有解
    private int[][] array = {

            {0, 0, 8, 3, 0, 9, 1, 0, 0},
            {9, 0, 0, 0, 6, 0, 0, 0, 4},
            {0, 0, 7, 5, 0, 4, 8, 0, 0},
            {0, 3, 6, 0, 0, 0, 5, 4, 0},
            {0, 0, 1, 0, 0, 0, 6, 0, 0},
            {0, 4, 2, 0, 0, 0, 9, 7, 0},
            {0, 0, 5, 9, 0, 7, 3, 0, 0},
            {6, 0, 0, 0, 1, 0, 0, 0, 8},
            {0, 0, 4, 6, 0, 8, 2, 0, 0}
    };

    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku();
        sudoku.sudoku(0, 0);
    }

    private void sudoku(int row, int col) {

        if (row == LENGTH - 1 && col == LENGTH) {
            PrintUtils.printArray(array);
            return;
        }

        if (col == LENGTH) {
            row++;
            col = 0;
        }

        if (array[row][col] == 0) {
            for (int i = 1; i <= LENGTH; i++) {
                if (judge(row, col, i)) {
                    array[row][col] = i;
                    sudoku(row, col + 1);
                    array[row][col] = 0;
                }
            }
        } else {
            sudoku(row, col + 1);
        }
    }

    public boolean judge(int row, int col, int number) {

        for (int i = 0; i < LENGTH; i++) {
            if (number == array[row][i] || array[i][col] == number) {
                return false;
            }
        }

        int tmpRow = row / 3;
        int tmpColumn = col / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (number == array[tmpRow * 3 + i][tmpColumn * 3 + j]) {
                    return false;
                }
            }
        }

        return true;
    }
}
