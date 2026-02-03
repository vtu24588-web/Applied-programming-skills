class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int top=-1;
        int[] s=new int[n];
        int[] ng=new int[n];
        for(int i=n-1;i>=0;i--){
            while(top!=-1 && temperatures[i]>=temperatures[s[top]]){
                top--;
            }
            if(top==-1){
                ng[i]=0;
                s[++top]=i;
            }
            else if(temperatures[i]<temperatures[s[top]]){
                ng[i]=s[top]-i;
                s[++top]=i;
            }
        }
        return ng;
    }
}
