# bfs套路

想用bfs的时候，要考虑清楚根节点到底是什么。

举787为例子
```
做图；
建立队列q；
初始情况入队列q.offer(initState)；
while（队列不为空）：
    curSomething = q；
    if（判定终止条件）：
        return curSomething；
    if（！判定越界条件）：
        q.offer(nextState)

return -1 
```


以787为例子：
```java
/**
 * 这道题和127也好像
 */
public class LC787_CheapestFlightsWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {

        // 首先我们应该记录的是保存有权图的方法
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for(int[] flight : flights){
            if(!graph.containsKey(flight[0])) {
                graph.put(flight[0], new HashMap<>());
            }
            graph.get(flight[0]).put(flight[1], flight[2]);
        }

        // 用一个优先队列保证花费最低
        // pq里面存的东西分别是[到达当前站的最低费用, 当前站, 经过中转的站数]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt(a -> a[0])
        );
        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int feeToCurStop = tmp[0];
            int curStop = tmp[1];
            int k = tmp[2];

            if (curStop == dst) return feeToCurStop;

            // 如果中转的次数还在允许的范围内
            if(k <= K) {
                //map.getOrDefault()
                //     * Returns the value to which the specified key is mapped, or
                //     * {@code defaultValue} if this map contains no mapping for the key.
                // 如果有tar的话，就找到tar，否则nextHop就是空的
                // 防止下一站城市不在map中
                Map<Integer, Integer> nextHops = graph.getOrDefault(curStop, new HashMap<>());
                for(Map.Entry<Integer, Integer> entry : nextHops.entrySet()) {
                    pq.offer(new int[]{feeToCurStop + entry.getValue(), entry.getKey(), k + 1});
                }
            }
        }
        return -1;
    }
}
```

找路线类题目：
dijkstra: 不能处理负权重
Time(V^2)

bellman-ford: 可以处理负权重
Time: O(V * E)
最坏情况 : O(V^2 * E)
又因为E最坏=V^2
所以最坏情况：O(V^4)

Space: O(V)
