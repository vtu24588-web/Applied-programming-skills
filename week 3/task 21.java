class StockSpanner {

public int top;
public int[] s;
public int[] ans;
    public StockSpanner() {
        int top=-1;
        s=new int[100000];
        ans=new int[100000];
    }
    
    public int next(int price) {
      int span=1; 
       while(top!=-1 && s[top]<=price){
            span=span+ans[top];
            top--;
        }
        top++;
        s[top]=price;
        ans[top]=span;
        return span;
    }
}
