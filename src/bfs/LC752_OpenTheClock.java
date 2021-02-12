package bfs;

import java.util.*;

/**
 * 以后判定是否contains的话，一定要记得用Set
 */
public class LC752_OpenTheClock {
    public int openLock(String[] deadends, String target) {

        /**
         * 这里不用set的话，会超时！！
         */
        Set<String> deadEnds = new HashSet<>();
        Collections.addAll(deadEnds, deadends);

        if(deadEnds.contains("0000")) {
            return -1;
        }

        String start = "0000";

        Queue<String> q = new LinkedList<>();

        q.offer(start);

        int tryTimes = 0;

        while (!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String curString = q.poll();
                if(curString.equals(target)) {
                    return tryTimes;
                }

                for(int j = 0; j < 4; j++) {
                    char[] charUnit = curString.toCharArray();
                    String nextString1 = upShift(charUnit, j);
                    charUnit = curString.toCharArray();
                    String nextString2 = downShift(charUnit, j);

                    if(!deadEnds.contains(nextString1)) {
                        q.offer(nextString1);
                        deadEnds.add(nextString1);
                    }

                    if(!deadEnds.contains(nextString2)) {
                        q.offer(nextString2);
                        deadEnds.add(nextString2);
                    }
                }
            }
            tryTimes++;
        }

        return -1;
    }

    private String upShift (char[] charUnit, int j) {
        if (charUnit[j]>='0' && charUnit[j] <='8') {
            charUnit[j]++;
        } else {
            charUnit[j] = '0';
        }
        return new String(charUnit);
    }

    private String downShift (char[] charUnit, int j) {
        if (charUnit[j]>='1' && charUnit[j] <='9') {
            charUnit[j]--;
        } else {
            charUnit[j] = '9';
        }
        return new String(charUnit);
    }

}
