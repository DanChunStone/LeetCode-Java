package Problem;

public class Pro007_ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new Pro007_ReverseInteger().reverse(1534236469));
    }

    public int reverse(int x) {
        long result = 0;
        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result > Integer.MAX_VALUE || result < Integer.MIN_VALUE ? 0 : (int) result;
    }
}
