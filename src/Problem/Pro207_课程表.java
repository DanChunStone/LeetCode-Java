package Problem;

import java.util.*;

public class Pro207_课程表 {

    public static void main(String[] args) {
        System.out.println(new Pro207_课程表().canFinish(2, new int[][]{{1, 0}}));
        System.out.println(new Pro207_课程表().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }

    /**
     * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
     * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
     * 其中 prerequisites[i] = [ai, bi]，表示如果要学习课程 ai 则 必须 先学习课程 bi 。
     * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
     * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] enter = new int[numCourses];
        Deque<Integer> node = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            enter[i] = 0;
            map.put(i, new ArrayList<>());
        }
        for (int[] requirement : prerequisites) {
            map.get(requirement[0]).add(requirement[1]);
            enter[requirement[1]]++;
        }
        for (int i = 0; i < numCourses; i++) {
            if (enter[i] == 0) {
                node.add(i);
            }
        }

        int size = 0;
        while (!node.isEmpty()) {
            int i = node.remove();
            size++;
            List<Integer> list = map.get(i);
            for (int j : list) {
                enter[j]--;
                if (enter[j] == 0) {
                    node.add(j);
                }
            }
        }
        return size == numCourses;
    }

    // 广度优先遍历
//    private final List<List<Integer>> edges = new ArrayList<>();
//    private int[] visit;
//    private boolean valid;
//
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
//            return true;
//        }
//        edges.clear();
//        visit = new int[numCourses];
//        valid = true;
//
//        for (int i = 0; i < numCourses; i++) {
//            edges.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < prerequisites.length; i++) {
//            int pre = prerequisites[i][0];
//            int after = prerequisites[i][1];
//            edges.get(after).add(pre);
//        }
//
//        for (int i = 0; i < numCourses; i++) {
//            if (visit[i] == 0) {
//                dfs(i);
//                if (!valid) {
//                    return false;
//                }
//            }
//        }
//        return valid;
//    }
//
//    public void dfs(int i) {
//        visit[i] = 1;
//
//        for (int j : edges.get(i)) {
//            if (visit[j] == 0) {
//                dfs(j);
//                if (!valid) {
//                    return;
//                }
//            } else if (visit[j] == 1) {
//                valid = false;
//                return;
//            }
//        }
//
//        visit[i] = 2;
//    }
}
