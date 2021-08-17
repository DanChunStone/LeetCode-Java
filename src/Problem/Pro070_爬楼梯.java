package Problem;

public class Pro070_爬楼梯 {

    public static void main(String[] args) {
        System.out.println(new Pro070_爬楼梯().climbStairs(1));
        System.out.println(new Pro070_爬楼梯().climbStairs(2));
        System.out.println(new Pro070_爬楼梯().climbStairs(3));
        System.out.println(new Pro070_爬楼梯().climbStairs(4));
        System.out.println(new Pro070_爬楼梯().climbStairs(45));
    }

    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * 注意：给定 n 是一个正整数。
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prepreStep = 1;
        int preStep = 2;
        for (int i = 3; i <= n; i++) {
            int step = prepreStep + preStep;
            prepreStep = preStep;
            preStep = step;
        }
        return preStep;
    }

    // 递归
//    public int climbStairs(int n) {
//        if (n <= 2) {
//            return n;
//        }
//        return climbStairs(n - 1) + climbStairs(n - 2);
//    }
}
