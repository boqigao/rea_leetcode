package bfs;

import java.util.*;

/**
 * 【wordList 中的所有字符串 互不相同】
 *
 * 像巴普洛夫的狗一样！看到bfs就想到queue！
 * https://www.youtube.com/watch?v=hB_nYXFtwP0
 *
 * 这种做法如何保证是最短呢？
 * 其实是bfs的属性决定了它一定是最短的，因为对于每一个
 * 单词（节点），我们都找到了所有其后续节点，并且一找到结果我们就返回了
 */
public class LC127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();

        queue.offer(beginWord);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String cur = queue.poll();
                char[] wordUnit = cur.toCharArray();
                if(cur.equals(endWord)) {
                    return level + i;
                }
                for(int j = 0; j < cur.length(); j++) {
                    // 这个tmp只是暂时保存一下
                    char temp = wordUnit[j];
                    for(char c = 'a'; c <= 'z'; c++) {
                        wordUnit[j] = c;
                        String s = new String(wordUnit);
                        if(set.contains(s)){
                            queue.add(s);
                            // 这里的set.remove，其实就是干的visited的活儿
                            set.remove(s);
                        }
                    }
                    // 在便利了第j位的字母之后，再把原字母还回去
                    wordUnit[j] = temp;
                }
            }
            // 每跑一圈，就是增加了一层
            level++;
        }
        return 0;
    }
}
