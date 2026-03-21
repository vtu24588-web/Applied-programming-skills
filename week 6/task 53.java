import java.util.*;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();

        if (nums1.length == 0 || nums2.length == 0) return result;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> (a[0] + a[1]) - (b[0] + b[1])
        );

        // push first column pairs
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }

        while (k > 0 && !pq.isEmpty()) {
            int[] cur = pq.poll();

            int u = cur[0];
            int v = cur[1];
            int j = cur[2];

            result.add(Arrays.asList(u, v));

            // move to next in nums2
            if (j + 1 < nums2.length) {
                pq.add(new int[]{u, nums2[j + 1], j + 1});
            }

            k--;
        }

        return result;
    }
}
