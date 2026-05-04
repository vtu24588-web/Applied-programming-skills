import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int start) {
        // Add the current subset to the result
        result.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {
            // Include the element
            current.add(nums[i]);
            // Move to the next element
            backtrack(result, current, nums, i + 1);
            // Backtrack: exclude the element
            current.remove(current.size() - 1);
        }
    }
}
