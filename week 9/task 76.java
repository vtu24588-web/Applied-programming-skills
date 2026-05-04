class Solution {
    public int climbStairs(int n) {
        // Base cases
        if (n <= 2) return n;
        
        int first = 1;  // Ways to reach 1 step back
        int second = 2; // Ways to reach 2 steps back
        
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        
        return second;
    }
}
