class Solution {
    public int uniquePaths(int m, int n) {
        // Use a 1D array to store the number of paths to each column
        int[] dp = new int[n];
        
        // Initialize the first row (all 1s)
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }

        // Iterate through each row starting from the second one
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // The new dp[j] is the sum of the cell to the left (dp[j-1])
                // and the cell above it (which is the old dp[j])
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
