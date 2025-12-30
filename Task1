class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int[] result=new int[n];
        int left=0;
        int right=n-1;
        int position=n-1;
        while(left<=right){
            int leftsquare=nums[left]*nums[left];
            int rightsquare=nums[right]*nums[right];
            if(leftsquare>rightsquare){
                result[position]=leftsquare;
                left++;
            }
            else{
                result[position]=rightsquare;
                right--;
            }
            position--;
        }
        return result;
    }
}
