package graph;

import java.util.List;

/**
 * see graph.LC323
 * 洪水漫灌算法，基本是同一道题
 */
public class LC841_KeyAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];

        int connectedComponent = 0;
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i]) {
                dfs(i, rooms, visited);
                connectedComponent++;
            }

            if(connectedComponent>1) {
                return false;
            }
        }
        return true;
    }

    private void dfs(int i, List<List<Integer>> rooms, boolean[] visited) {
        visited[i] = true;
        for(int nextRoom : rooms.get(i)) {
            if (!visited[nextRoom]) {
                dfs(nextRoom, rooms, visited);
            }
        }
    }
}
