package graph;

import java.util.ArrayList;
import java.util.List;

public class LC990_EquationPossibility {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        List<int[]> list = new ArrayList<>();
        for (String s : equations) {
            char x = s.charAt(0);
            char y = s.charAt(3);
            if (s.charAt(1) == '=') {
                unionFind.union(x - 'a', y - 'a');
            } else {
                list.add(new int[] {x - 'a', y - 'a'});
            }
        }

        for (int[] arr : list) {
            if (unionFind.find(arr[0]) == unionFind.find(arr[1])) {
                return false;
            }
        }

        return true;
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int len) {
            parent = new int[len];
            for (int i = 0; i < len; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            } else {
                parent[x] = find(parent[x]);
                return parent[x];
            }
        }

        public void union(int x, int y) {
            parent[find(x)] = find(y);
        }
    }
}
