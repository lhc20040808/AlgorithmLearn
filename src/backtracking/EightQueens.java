package backtracking;

/**
 * Created by qgg on 2018/1/1.
 */
public class EightQueens {

    private int[] array = new int[8];


    public void egithQueens(int row) {
        if (row == 8) {
            PrintUtils.printArray(array);
            System.out.println();
            return;
        }

        for (int i = 0; i < 8; i++) {
            array[row] = i;
            if (judge(row)) {
                egithQueens(row + 1);
            }
        }
    }


    public boolean judge(int row) {

        for (int i = 0; i < row; i++) {
            if (array[i] == array[row] || Math.abs(i - row) == Math.abs(array[i] - array[row])) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        EightQueens eightQueens = new EightQueens();
        eightQueens.egithQueens(0);
    }
}
