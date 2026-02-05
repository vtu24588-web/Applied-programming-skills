class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int top=-1;
        int n=pushed.length;
        int j=0;
        int[] s=new int[n];
        for(int i=0;i<n;i++){
            s[++top]=pushed[i];
            while(top>=0 && s[top]==popped[j]){
                top--;
                j++;
            }
        }
        return top==-1;
    }
}
