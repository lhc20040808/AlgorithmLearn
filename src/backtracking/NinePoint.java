package backtracking;

/**
 * Created by qgg on 2018/1/1.
 */
public class NinePoint {

    public static void main(String[] args) {
        ninePoint(5);
    }

    /**
     * 九宫格
     */
    public static void ninePoint(int n) {
        if (n % 2 == 0) {
            throw new IllegalArgumentException("n必须是奇数");
        }

        int[][] array = new int[n][n];
        int i = 1;
        int row = 0;
        int col = n / 2;
        array[row][col] = i;

        while (i < n * n) {
            int lastRow = row;
            int lastCol = col;

            i++;

            row--;
            col++;

            if (row < 0) {
                row = n - 1;
            }

            if (col == n) {
                col = 0;
            }

            if (array[row][col] == 0) {
                array[row][col] = i;
            } else {
                row = lastRow + 1;
                col = lastCol;
                array[row][col] = i;
            }
        }

        PrintUtils.printArray(array);
    }
}
