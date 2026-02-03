import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        int n=s.length();
        int top=-1;
        char[] a =new char[n];
        for(int i=0;i<n;i++){
            char input=s.charAt(i);
            if(input=='('||input=='['||input=='{'){
                a[++top]=input;
            }
            else if(top==-1){
                return false;
            }
            else{
            char pop = a[top--];
            if ((input == ')' && pop != '(') ||
                    (input == ']' && pop != '[') ||
                    (input == '}' && pop != '{')) {
                    return false;
                    }}
            
        
    }
    return top==-1;

    }  
}
