package math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
* 970. 强整数
给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。

返回值小于或等于 bound 的所有强整数组成的列表。

你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。



示例 1：

输入：x = 2, y = 3, bound = 10
输出：[2,3,4,5,7,9,10]
解释：
2 = 2^0 + 3^0
3 = 2^1 + 3^0
4 = 2^0 + 3^1
5 = 2^1 + 3^1
7 = 2^2 + 3^1
9 = 2^3 + 3^0
10 = 2^0 + 3^2
* */

public class PowerfulIntegers {//测试通过
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        if (x == 1 && y == 1) {
            if (2 <= bound) set.add(2);
        } else if (x == 1) {
            int tmp2 = 1;
            for (int j = 0; 1 + tmp2 <= bound; j++) {
                if (j > 0) {
                    tmp2 *= y;
                }
                if (1 + tmp2 <= bound) set.add(1 + tmp2);
            }
        } else if (y == 1) {
            int tmp1 = 1;
            for (int j = 0; 1 + tmp1 <= bound; j++) {
                if (j > 0) {
                    tmp1 *= x;
                }
                if (tmp1 + 1 <= bound) set.add(tmp1 + 1);
            }
        } else {
            int tmp1 = 1;
            for (int i = 0; tmp1 <= bound; i++) {
                if (i > 0) {
                    tmp1 *= x;
                }
                int tmp2 = 1;
                for (int j = 0; tmp1 + tmp2 <= bound; j++) {
                    if (j > 0) {
                        tmp2 *= y;
                    }
                    if (tmp1 + tmp2 <= bound) set.add(tmp1 + tmp2);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
