
public class DivideAndConquer {

    public static void main(String[] args) {
        int[] array = {5, 7, 6, 3, 12, 9, 2, 10};
//        insertSort(array);
//        shellSort(array, 3);
//        shellSort(array, 1);
//        merger(array, 0, 4, array.length - 1);
//        mergeSort(array, 0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
//        int index = binarySort(array, 10, 0, array.length);
//        System.out.print("第" + index + "位");

//        cyclicGameTest();
    }

    /**
     * 二分查找
     */
    public static int binarySort(int[] array, int key, int start, int end) {
        int left = start;
        int right = end - 1;

        while (left <= right) {
            int mid = (left + right) >>> 1;
            int midVal = array[mid];
            if (midVal < key) {
                left = mid + 1;
            } else if (midVal > key) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    /**
     * 快速排序
     * PS:当数据存储结构为单链表时，不适用快速排序
     */
    public static void quickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end - 1;
        int tmp = array[start];
        boolean isMoveLeft = false;

        while (left < right) {

            if (!isMoveLeft) {

                while (array[right] > tmp && left < right) {
                    right--;
                }

                if (left < right) {
                    array[left++] = array[right];
                    isMoveLeft = true;
                }

            } else {

                while (array[left] < tmp && left < right) {
                    left++;
                }

                if (left < right) {
                    array[right--] = array[left];
                    isMoveLeft = false;
                }

            }
        }

        array[left] = tmp;
        quickSort(array, start, left);
        quickSort(array, left + 1, end);
    }

    /**
     * 归并排序
     */
    public static void mergeSort(int array[], int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int mid = (left + right) >>> 1;

        mergeSort(array, start, mid);
        mergeSort(array, mid + 1, end);
        merger(array, left, mid + 1, right);
    }

    public static void merger(int array[], int start, int mid, int end) {
        int leftSize = mid - start;
        int rightSize = end - mid + 1;
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for (int i = start; i < mid; i++) {
            leftArray[i - start] = array[i];
        }

        for (int i = mid; i <= end; i++) {
            rightArray[i - mid] = array[i];
        }

        int i = 0;
        int j = 0;
        int k = start;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] < rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i < leftSize) {
            array[k++] = leftArray[i++];
        }
        while (j < rightSize) {
            array[k++] = rightArray[j++];
        }
    }


    public static void cyclicGameTest() {

        int[][] result = cyclicGame(3);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param n 2^n个选手
     * @return 日程表
     */
    private static int[][] cyclicGame(int n) {
        int count = 1 << n;
        int[][] array = new int[count][count];
        //先填第一行
        for (int i = 0; i < count; i++) {
            array[0][i] = i + 1;
        }

        for (int round = 1; round < count; round = round * 2) {
            for (int i = 0; i < count; i = i + round * 2) {
                copy(array, 0, i, round, round + i, round);//左上到右下
                copy(array, 0, round + i, round, i, round);//右上到左下
            }
        }

        return array;
    }

    private static void copy(int[][] array, int fromX, int fromY, int toX, int toY, int round) {
        for (int i = 0; i < round; i++) {
            for (int j = 0; j < round; j++) {
                array[toX + i][toY + j] = array[fromX + i][fromY + j];
            }
        }
    }

    /**
     * 链式基数排序
     * 通常用于斗地主等牌类游戏
     */
    private static void linkedSort() {

    }

    /**
     * 直接插入排序
     */
    private static void insertSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int j = i;
            int target = array[i];
            while (j > 0 && target < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = target;
        }
    }

    /**
     * 希尔排序
     * 可以用于麻将游戏的排序
     * 适用于有序的情况又要插入新的数据重新排序
     */
    private static void shellSort(int[] array, int step) {
        for (int k = 0; k < step; k++) {
            for (int i = k + step; i < array.length; i += step) {
                int j = i;
                int target = array[i];
                while (j > step - 1 && target < array[j - step]) {
                    array[j] = array[j - step];
                    j -= step;
                }

                array[j] = target;
            }
        }
    }
}
