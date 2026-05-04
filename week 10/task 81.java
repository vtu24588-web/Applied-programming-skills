import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        // Create dp array and fill with a value larger than amount
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        
        // Base case: 0 coins needed for amount 0
        dp[0] = 0;

        // Iterate through every amount from 1 to target
        for (int i = 1; i <= amount; i++) {
            // Check every coin denomination
            for (int coin : coins) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If amount is not reachable, return -1
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
