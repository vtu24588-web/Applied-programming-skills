class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;

        // Step 1: sort array
        java.util.Arrays.sort(nums);

        // Step 2: count frequencies
        int[] values = new int[n];
        int[] freq = new int[n];

        int index = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                values[index] = nums[i - 1];
                freq[index] = count;
                index++;
                count = 1;
            }
        }

        // last element
        values[index] = nums[n - 1];
        freq[index] = count;
        index++;

        // Step 3: sort by frequency (descending)
        for (int i = 0; i < index - 1; i++) {
            for (int j = i + 1; j < index; j++) {
                if (freq[j] > freq[i]) {
                    // swap freq
                    int temp = freq[i];
                    freq[i] = freq[j];
                    freq[j] = temp;

                    // swap values
                    temp = values[i];
                    values[i] = values[j];
                    values[j] = temp;
                }
            }
        }

        // Step 4: take top k
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = values[i];
        }

        return result;
    }
}
