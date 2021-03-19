package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LC767_ReorganizeString {
    public String reorganizeString(String S) {
        String s = S;
        if (s.length() < 2){
            return s;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c-'a']);
        }

        if (maxCount > (length + 1) / 2) {
            return "";
        }

        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts[o2 - 'a'] - counts[o1 - 'a'];
            }
        });

        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] >0) {
                queue.offer(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a';
            int index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;

            if (counts[index1] > 0) {
                queue.offer(letter1);
            }

            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }

        return sb.toString();
    }
}
