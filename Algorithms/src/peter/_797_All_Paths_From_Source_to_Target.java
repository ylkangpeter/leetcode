/**
 * <p>
 * project info: leetcode-peter
 */

package peter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * author: ylkang
 * date: 2021/8/27
 * version: v0.1
 */
public class _797_All_Paths_From_Source_to_Target {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> stack = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(graph, 0);
        return result;
    }

    private void dfs(int[][] graph, int index) {
        stack.add(index);
        if (index == graph.length - 1) {
            result.add(new ArrayList<>(stack));
        }  else {
            for (int v : graph[index]) {
                dfs(graph, v);
            }
        }stack.removeLast();
    }

    public static void main(String[] args) {
        _797_All_Paths_From_Source_to_Target solution = new _797_All_Paths_From_Source_to_Target();

        solution.allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {}, {4}, {}});
    }
}
