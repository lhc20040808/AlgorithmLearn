/**
 * Created by qgg on 2018/1/15.
 */
public class RecursionSolution {
    public static void main(String[] args) {
//        System.out.println(printNum(-1));
//        System.out.println(printNum(1));
//        System.out.println(printNum(0));
//        System.out.println(printString(null));
        System.out.println(printString(""));
        System.out.println(printString("1"));
        System.out.println(printString("ab12"));

    }

    /**
     * 给定一个int型 n，输出1~n的字符串例如 n = 4 输出“1 2 3 4”
     */
    public static String printNum(int x) {
        if (x <= 0) {
            return "";
        } else {
            return printNum(x - 1) + " " + x;
        }
    }

    /**
     * 字符串反转
     */
    public static String printString(String str) {

        if (str == null) {
            throw new IllegalArgumentException("");
        }

        return printString(str, 0);
    }


    private static String printString(String str, int index) {
        if (index >= str.length()) {
            return "";
        } else {
            return printString(str, index + 1) + str.charAt(index);
        }
    }

}
