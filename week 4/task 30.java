class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n=nums.length;
        Deque<Integer> max_dq=new ArrayDeque<>();
        Deque<Integer> min_dq=new ArrayDeque<>();
        int left=0;
        int ans=0;
        for(int right=0;right<n;right++){
            while(!max_dq.isEmpty() &&nums[max_dq.peekLast()]<=nums[right]){
                max_dq.pollLast();
            }
            max_dq.offerLast(right);
            while(!min_dq.isEmpty()&&nums[min_dq.peekLast()]>=nums[right]){
                min_dq.pollLast();
            }
            min_dq.offerLast(right);
            while(nums[max_dq.peekFirst()]-nums[min_dq.peekFirst()]>limit){
                left++;
                if(max_dq.peekFirst()<left){
                    max_dq.pollFirst();
                }
                if(min_dq.peekFirst()<left){
                    min_dq.pollFirst();
                }
            }
            ans=Math.max(ans,right-left+1);
        }

        return ans;
    }
}
