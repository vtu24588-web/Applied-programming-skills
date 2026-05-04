import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> currentList, int[] nums) {
        // Base case: If the current list is the same size as nums, we found a permutation
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // If the element is already present, skip it
            if (currentList.contains(nums[i])) continue;

            // Choose the element
            currentList.add(nums[i]);
            
            // Explore further
            backtrack(result, currentList, nums);
            
            // Backtrack: remove the element to try others
            currentList.remove(currentList.size() - 1);
        }
    }
}
