package greedy;

import java.util.Arrays;
import java.util.Collections;

/**
 * 和某道题很像
 * @see LC767_ReorganizeString
 *
 * 这道题核心是要知道：任意位置只要出现连续3个0就可以中上一朵花
 */
public class LC605_CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        int[] tmp = new int[len + 2];
        System.arraycopy(flowerbed,0,tmp, 1, len);

        for (int i = 1; i <= len; i++) {
            if (tmp[i] == 0 && tmp[i-1] ==0 && tmp[i +1] ==0) {
                tmp[i] = 1;
                n--;
            }
        }

        return n <= 0;
    }
}
