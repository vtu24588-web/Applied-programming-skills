class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer> dq=new ArrayDeque<>();
        int index=0;
        int ans[]=new int[n-k+1];
        for(int i=0;i<=n-1;i++){
            if(!dq.isEmpty()&&dq.peekFirst()<=i-k){
                dq.pollFirst();
            }
        while(!dq.isEmpty()&&nums[i]>nums[dq.peekLast()]){
            dq.pollLast();
        }
        dq.offerLast(i);
        if(i>=k-1){
            ans[index++]=nums[dq.peekFirst()];
        }
        }
        return ans;
    }
}
