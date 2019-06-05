package Algorithm.LeetCode.T347;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 出现频率最多的 k 个数
 *
 * @author: wangfei
 * @date: 2019/4/10 23:15
 */
public class Solution {

    /**
     * 设置若干个桶，每个桶存储出现频率相同的数，并且桶的下标代表桶中数出现的频率，
     * 即第 i 个桶中存储的数出现的频率为 i。
     * 把数都放到桶之后，从后向前遍历桶，最先得到的 k 个数就是出现频率最多的的 k 个数。
     *
     * @param nums
     * @param k
     * @return
     */
    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int key : map.keySet()) {
            int frequency = map.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        List<Integer> topK = new ArrayList<>();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] == null) {
                continue;
            }
            if (buckets[i].size() <= (k - topK.size())) {
                topK.addAll(buckets[i]);
            } else {
                topK.addAll(buckets[i].subList(0, k - topK.size()));
            }
        }
        return topK;
    }

    /**
     * 主函数
     *
     * @param args
     */
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4};
        int k = 2;
        System.out.print(topKFrequent(nums, k));
        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - start) + "ms");
    }
}
