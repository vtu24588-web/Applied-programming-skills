import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int start, int n, int k) {
        // Base case: combination is done
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Iterate through the numbers. 
        // Optimization: i <= n - (k - current.size()) + 1
        for (int i = start; i <= n; i++) {
            // Choose the number
            current.add(i);
            
            // Explore further with the next number
            backtrack(result, current, i + 1, n, k);
            
            // Backtrack: remove the number to try the next one
            current.remove(current.size() - 1);
        }
    }
}
