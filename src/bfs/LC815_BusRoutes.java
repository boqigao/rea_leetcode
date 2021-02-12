package bfs;

import javax.swing.text.StyledEditorKit;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * 我们将每一条公交路线（而不是每一个车站）看成图中的一个点，
 * 如果两条公交路线有交集，那么它们在图中对应的点之间就有一条边。
 */
public class LC815_BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source == target) {
            return 0;
        }
        if (routes == null || routes.length == 0) return -1;

        // 记录一个起始车站和到达车站所在的路线的集合位置
        List<Integer> startLines = new ArrayList<>();
        List<Integer> targetLines = new ArrayList<>();

        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[0].length; j++) {
                if(routes[i][j] == source&& !startLines.contains(i)){
                    startLines.add(i);
                }

                if(routes[i][j] == target && !targetLines.contains(i)) {
                    targetLines.add(i);
                }
            }
        }

        //  如果一开始就在同一个线路上有，直接返回1
        for(int targetLine: targetLines) {
            if(startLines.contains(targetLine)) {
                return 1;
            }
        }

        // 设置一个routeMap 记录路线上的车站 与其他路线相交过的所有编号。出现过交集的线路
        // 例 routes={{1, 2, 7},{3, 6, 7},{3, 8, 9}}；routeMap={0:[1], 1:[0, 2], 2:[1]}
        Map<Integer, List<Integer>> routeMap = new HashMap<>();
        // 标记某条线路是否访问过
        Boolean[] isVisited = new Boolean[routes.length];

        // 给所有的访问标为未访问
        // 给所有的routeMap加上新的节点
        for(int i =0; i < routes.length; i++) {
            isVisited[i] = false;
            routeMap.put(i, new ArrayList<>());
        }

        for(int i = 0; i < routes.length; i++){
            for(int j = i + 1; j < routes.length; j++) {
                if(haveSameStop(routes[i], routes[j])) {
                    routeMap.get(i).add(j);
                    routeMap.get(j).add(i);
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int startLine:startLines) {
            q.offer(startLine);
        }

        int res = 0;
        while (!q.isEmpty()){
            int size = q.size();
            res++;
            for(int i = 0; i < size; i++) {
                int curLine = q.poll();
                if(isVisited[curLine]) {
                    continue;
                }
                isVisited[curLine] = true;
                for(int nextLine : routeMap.get(curLine)) {
                    if(targetLines.contains(nextLine)) {
                    return res;
                    }
                    q.offer(nextLine);
                }
            }
        }
        return -1;
    }

    private boolean haveSameStop(int[] route1, int[] route2) {
        Set<Integer> set1 = new HashSet<>();
        for (int j : route1) {
            set1.add(j);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int j : route2) {
            set2.add(j);
        }

        //在s1中移除所有s2中不包含的元素
        set1.retainAll(set2);

        // 如果s1非空，说明s1中有s2的元素，则有交集
        return !set1.isEmpty();
    }
}
