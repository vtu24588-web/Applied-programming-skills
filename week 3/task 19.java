class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n =nums2.length;
        int top=-1;
        int[] s=new int[n];
        int[] ng=new int[n];
        for(int i=n-1;i>=0;i--){
            if(top==-1){
                ng[i]=-1;
                s[++top]=nums2[i];
            }
            else if(nums2[i]<s[top]){
                ng[i]=s[top];
                s[++top]=nums2[i];
            }
            else{
                while(top!=-1 && nums2[i]>=s[top]){
                    top--;
                }
                if(top==-1){
                    ng[i]=-1;
                }else{
                    ng[i]=s[top];
                }
                s[++top]=nums2[i];
            }
        }
        int k=nums1.length;
        int[] ans=new int[k];
        for(int i=0;i<k;i++){
            for(int j=0;j<n;j++){
                if(nums1[i]==nums2[j]){
                    ans[i]=ng[j];
                    break;
                }
            }
        }
        return ans;
    }
}
