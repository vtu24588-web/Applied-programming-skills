class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int first = cost[0];
        int second = cost[1];
        
        // Start from index 2 since we already have costs for 0 and 1
        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(first, second);
            first = second;
            second = current;
        }
        
        // The top of the floor can be reached from either of the last two steps
        return Math.min(first, second);
    }
}
