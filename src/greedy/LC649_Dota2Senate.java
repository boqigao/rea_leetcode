package greedy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class LC649_Dota2Senate {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();
        char c;
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'D') {
                dire.offer(i);
            } else {
                radiant.offer(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();

            if (r < d) {
                radiant.offer(r + n);
            } else {
                dire.offer(d + n);
            }
        }

        return radiant.isEmpty()? "Dire" : "Radiant";
    }
    public String predictPartyVictoryWrongAnswer(String senate) {
        Stack<Integer> stack = new Stack<>();
        // true: dire, false: radiant
        boolean flag = true;
        for (int i = 0; i < senate.length(); i++) {
            if (stack.isEmpty() && senate.charAt(i) == 'D') {
                flag = true;
                stack.push(1);
            }
            if (stack.isEmpty() && senate.charAt(i) == 'R') {
                flag = false;
                stack.push(0);
            }
            stack.pop();
        }
        if (flag) {
            return "Dire";
        } else {
            return "Radiant";
        }
    }
}
