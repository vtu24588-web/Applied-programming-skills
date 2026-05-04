
class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        // Tracks max money robbed 2 houses ago
        int prev2 = 0;
        // Tracks max money robbed 1 house ago
        int prev1 = 0;

        for (int money : nums) {
            // Current max is either (current house + 2 houses ago) or (1 house ago)
            int current = Math.max(prev1, money + prev2);
            
            // Move pointers forward
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
