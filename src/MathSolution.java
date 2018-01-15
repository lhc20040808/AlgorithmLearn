/**
 * Created by qgg on 2018/1/15.
 */
public class MathSolution {

    public static void main(String[] args) {
//        System.out.println(isUnlimitedDecimal(222, 407));
//        System.out.println(isUnlimitedDecimal(3, 17));
//        System.out.println(isUnlimitedDecimal(17, 20));
        System.out.println(isUnlimitedDecimal(17, 17));
    }

    /**
     * 辗转相除法/欧几里得算法求公约数
     */
    public static int gcd(int x, int y) {
        while (x % y != 0) {
            int tmp = x % y;
            x = y;
            y = tmp;
        }
        return y;
    }

    public static boolean isUnlimitedDecimal(int x, int y) {

        if (y == 0) {
            throw new IllegalArgumentException("");
        }

        int num = y / gcd(x, y);
        System.out.println("num:" + num);
        int i = 2;
        while (i <= num) {

            if (num % i == 0) {
                if (i != 2 && i != 5) {
                    return false;
                }
                num /= i;
                i = 2;
            } else {
                i++;
            }
        }
        return true;
    }

}
