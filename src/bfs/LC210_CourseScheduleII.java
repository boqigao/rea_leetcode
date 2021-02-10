package bfs;

import java.util.*;

/**
 * See dfs.LC207
 * 这次是自己写的，需要注意的是，入度在遍历prerequisites的时候已经可以获得
 */
public class LC210_CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();

        int[] inDegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            // 在此可以更新入度，入度为0的节点，就是bfs的根节点
            inDegree[prerequisites[i][0]]++;

            if(!graph.containsKey(prerequisites[i][1])) {
                graph.put(prerequisites[i][1], new ArrayList<>());
            }
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();

        // 如果入度为0， 就将其作为bfs的根节点
        for(int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        // 记录所有课程的遍历顺序
        int[] res = new int[numCourses];

        // 和那天那个isDone是一个is
        int index = 0;

        // bfs套路

        while (!q.isEmpty()){
            int size = q.size();

            for(int i = 0; i < size; i++) {
                int curCourse = q.poll();
                res[index++] = curCourse;
                List<Integer> nextCourses = graph.get(curCourse);

                // 先判定
                if(nextCourses == null) {
                    continue;
                }

                for(int nextCourse : nextCourses) {
                    inDegree[nextCourse]--;
                    if(inDegree[nextCourse] == 0) {
                        q.add(nextCourse);
                    }
                }
            }
        }

        return index == numCourses?res:new int[0];

    }
}
