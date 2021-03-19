package greedy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class LC763_PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Set<Character> set = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        int start = 0;
        int end = -1;
        for (int i = 0; i < S.length(); i++) {

            char curChar = S.charAt(i);
            if (set.contains(curChar) && i!=end) {
                continue;
            }
            int j = S.lastIndexOf(curChar);
            end = Math.max(end, j);

            if (i == end || i == S.length()-1) {
                int curSeg = end - start + 1;
                res.add(curSeg);
                start = end + 1;
            }
            set.add(curChar);
        }
        return res;
    }

    public static void main(String[] args) {
        LC763_PartitionLabels solve =new LC763_PartitionLabels();
        System.out.println(solve.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
