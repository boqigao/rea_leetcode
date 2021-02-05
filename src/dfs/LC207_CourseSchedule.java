package dfs;

import java.util.*;

/**
 * 这道题核心是一个图的拓扑排序
 *
 * 图的每个顶点有入度和出度的概念
 * 比如对于顶点A，有2个顶点指向他，同时他指向3个顶点
 * 则顶点A的入度为2，出度为3
 *
 * 拓扑排序就是按照入度从小到大排序
 *
 * 另外这道题的输入是如下类型
 *
 * 想上的课     先驱课程
 * [[4,           0],
 * [4,            1],
 * [3,            1],
 * [3,            2],
 * [5,            4],
 * [5,            3]]
 *
 * 的形式，放到图里也就是后者指向前者，这个不要弄错了
 */
public class LC207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 生成一个数组来记录每个节点的入度
        int[] inDegree = new int[numCourses];

        // 用一张邻接表来存这张图
        Map<Integer, List<Integer>> graph= new HashMap<>();
        for(int i = 0; i < prerequisites.length; i++) {
            // 输入的每一行的第一位是被输入的节点，所以入度++
            inDegree[prerequisites[i][0]]++;

            // 接下来进行邻接表的输入
            // 邻接表记录某个节点指向的另一些节点
            // 所以输入的每一行的第二位是key
            if(graph.containsKey(prerequisites[i][1])){
                graph.get(prerequisites[i][1])
                        .add(prerequisites[i][0]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], l);
            }
        }

        // 接下来做真正的处理
        // 怎么样通过一个图做拓扑排序呢

        // 其实是一个bfs的模板 相当于从入度为0的节点，开始做bfs
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // remember：这个图中记录的是cur的所有后续课程
            List<Integer> toTake = graph.get(cur);

            // 对于每一个后续课程来说，这节课上完了以后，入度就减了1
            for(int i = 0; toTake!=null && i <toTake.size(); i++){
                inDegree[toTake.get(i)]--;

                // 一旦某节后续课程的入度变成0之后
                // 我们就可以将其入队列
                // 即：从其开始做bfs
                if(inDegree[toTake.get(i)]==0) {
                    queue.add(toTake.get(i));
                }
            }
        }

        // 当我们把所有的节点便利完成之后，如果还有节点的入度为不为0，那么说明产生了环？
        for (int i = 0; i <numCourses; i++) {
            if(inDegree[i]!=0) return false;
        }

        return true;
    }
}
