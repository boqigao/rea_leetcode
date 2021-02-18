package graph;

import java.security.KeyStore;
import java.util.*;

public class LC997_FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        /*
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] pair: trust) {
            if(!map.containsKey(pair[0])) {
                map.put(pair[0], new ArrayList<>());
            }

            map.get(pair[0]).add(pair[1]);
        }*/

        Set<Integer> people = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            people.add(i);
        }

        for (int i = 0; i <= trust.length; i++) {
            people.remove(trust[i][0]);
        }

        // people中唯一留下的一个人就是小镇的法官
        if(people.size()!=1) {
            return -1;
        } else {
            int person = 0;
            for(int layer:people){
                person = layer;
            }

            Map<Integer, Boolean> map1 = new HashMap<>();
            for(int i = 1; i <= N; i++) {
                map1.put(i, false);
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 0; j < trust.length; j++) {
                    if(trust[j][1] == person && trust[j][0]==i) {
                        map1.put(i, true);
                    }
                }
            }

            for(int i = 1; i <= N; i++) {
                boolean tmpRes = map1.get(i);
                if (!tmpRes&&i!=person) {
                    return -1;
                }
            }

            return person;
        }
    }
}

class LC997 {
    public int findJudge(int N, int[][] trust) {
        // 计算每个人的入度和出度
        // people[i][0] 是第i-1个人的出度
        // people[i][1] 是第i-1个人的入度
        int[][] people = new int[N][2];

        for(int[] person : trust) {
            // 获得当前信任别人的人和被信任的人
            int out = person[0];
            int in = person[1];

            // 分别增加信任别人的人和被信任的人的入度和出度
            people[out-1][0]++;
            people[in-1][1]++;
        }

        // 法官不信任人，因此法官出度0
        // 法官被所有人信任，因此法官入度N-1
        // 找到这个人就行，如果不存在这个人，直接返回-1
        for (int i = 0; i < N; i++){
            if (people[i][0] == 0 && people[i][i] == N-1){
                return i+1;
            }
        }
        return -1;




    }
}
