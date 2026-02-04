class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n=asteroids.length;
        int[] s=new int[n];
        int top=-1;
        for(int i=0;i<n;i++){
            int input=asteroids[i];
            boolean d=false;
            if(top==-1){
                s[++top]=input;
            }
            else if(s[top]>0 && input>0){
                s[++top]=input;
            }
            else{
                while(top>=0 && s[top]>0 && input<0){
                    if(s[top]==Math.abs(input)){
                        top--;
                        d=true;
                        break;
                    }
                    else if(s[top]>Math.abs(input)){
                        d=true;
                        break;
                    }
                    else{
                        top--;
                    }
                   
                    }
                     if(!d){
                        s[++top]=input;
                }
            }
            
        }
        int[] ans=new int[top+1];
        for(int i=0;i<=top;i++){
            ans[i]=s[i];
        }
        return ans;
    }
}
