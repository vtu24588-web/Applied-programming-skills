class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] s = new int[n];
        int[] ng = new int[n];
        int top = -1;

        for (int i = n - 1; i >= 0; i--) {

            while (top != -1 && s[top] > prices[i]) {
                top--;
            }

            if (top == -1) {
                ng[i] = 0;
            } else {
                ng[i] = s[top];
            }

            s[++top] = prices[i];
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = prices[i] - ng[i];
        }

        return ans;
    }
}
