package Problem;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author shilijun
 * @date 2020/12/5 11:37
 */
public class Pro621_TaskScheduler {
    public static void main(String[] args) {
        Pro621_TaskScheduler instance = new Pro621_TaskScheduler();
        
        char[] tasks = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(instance.leastInterval(tasks, 2));
    }

    /**
     * 给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。
     * 任务可以以任意顺序执行，并且每个任务都可以在 1 个单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。
     * <p>
     * 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。
     * 你需要计算完成所有任务所需要的 最短时间 。
     * <p>
     * 1、通过不断轮询执行当前时间可执行且剩余次数最多的任务
     */
    public int leastInterval(char[] tasks, int n) {
        if (tasks.length <= 0 || n == 0) {
            return tasks.length;
        }

        Map<Character, Integer> characters = new HashMap<>();
        for (char task : tasks) {
            Integer times = characters.get(task);
            characters.put(task, times == null ? 1 : times + 1);
        }
        // 代表每个任务最早可执行时间与剩余次数
        int[][] taskInfo = new int[characters.size()][2];
        int index = 0;
        for (char task : characters.keySet()) {
            taskInfo[index][0] = 1;
            taskInfo[index][1] = characters.get(task);
            index++;
        }

        int time = 1;
        while (true) {
            int minTime = Integer.MAX_VALUE;
            int run = -1;

            for (int i = 0; i < taskInfo.length; i++) {
                if (taskInfo[i][0] <= time && taskInfo[i][1] > 0 && (run < 0 || taskInfo[i][1] > taskInfo[run][1])) {
                    run = i;
                }
                if (taskInfo[i][1] > 0)
                    minTime = Math.min(minTime, taskInfo[i][0]);
            }

            if (run >= 0) {
                time++;
                taskInfo[run][0] = time + n;
                taskInfo[run][1]--;
            } else if (minTime < Integer.MAX_VALUE) {
                if (minTime > time) {
                    time = minTime;
                }
            } else {
                break;
            }
        }
        return time - 1;
    }
}
