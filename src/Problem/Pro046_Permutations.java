package Problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pro046_Permutations {

    public static void main(String[] args) {
        System.out.println(new Pro046_Permutations().permute(new int[]{1, 2, 3}));
        System.out.println(new Pro046_Permutations().permute(new int[]{0, 1}));
        System.out.println(new Pro046_Permutations().permute(new int[]{1}));
    }

    private final List<List<Integer>> result = new ArrayList<>();

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列。你可以 按任意顺序 返回答案。
     */
    public List<List<Integer>> permute(int[] nums) {
        result.clear();
        if (nums == null || nums.length == 0) {
            return result;
        }

        List<Integer> out = new ArrayList<>();
        for (int i : nums)
            out.add(i);
        generate(out, 0, nums.length);

        return result;
    }

    private void generate(List<Integer> out, int start, int n) {
        if (start == n) {
            result.add(new ArrayList<>(out));
            return;
        }

        for (int i = start; i < n; i++) {
            Collections.swap(out, start, i);
            generate(out, start + 1, n);
            Collections.swap(out, start, i);
        }
    }
}
