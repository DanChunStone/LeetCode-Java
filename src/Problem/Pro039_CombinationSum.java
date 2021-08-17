package Problem;

import java.util.ArrayList;
import java.util.List;

public class Pro039_CombinationSum {

    public static void main(String[] args) {
        System.out.println(new Pro039_CombinationSum().combinationSum(new int[]{2, 3, 6, 7}, 7));
        System.out.println(new Pro039_CombinationSum().combinationSum(new int[]{2, 3, 5}, 8));
        System.out.println(new Pro039_CombinationSum().combinationSum(new int[]{2}, 1));
        System.out.println(new Pro039_CombinationSum().combinationSum(new int[]{1}, 1));
        System.out.println(new Pro039_CombinationSum().combinationSum(new int[]{1}, 2));
    }

    /**
     * 给定一个无重复元素的正整数数组 candidates 和一个正整数 target，找出candidates中所有可以使数字和为目标数target的唯一组合。
     * candidates中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
     * 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return combinationSum(candidates, target, 0);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target, int min) {
        if (candidates == null || candidates.length == 0)
            return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();
        for (int i : candidates) {
            if (i >= min) {
                if (target == i) {
                    List<Integer> list = new ArrayList<>();
                    list.add(target);
                    result.add(list);
                } else if (target - i >= min) {
                    List<List<Integer>> subResult = combinationSum(candidates, target - i, i);
                    for (List<Integer> sub : subResult) {
                        sub.add(0, i);
                        result.add(sub);
                    }
                }
            }
        }
        return result;
    }
}
