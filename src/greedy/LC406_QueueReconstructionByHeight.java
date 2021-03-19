package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 俄罗斯套信封？
 */
public class LC406_QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0 || people[0].length == 0) {
            return new int[0][0];
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1]-o2[1]:o2[0]- o1[0];
            }
        });

        List<int[]> list = new ArrayList<>();

        // list.add(index, element)他其实给了index
        for (int[] i : people) {
            list.add(i[1], i);
        }
        return list.toArray(new int[list.size()][]);
    }
}
