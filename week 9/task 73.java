class Solution {
    public String longestNiceSubstring(String s) {
        int n=s.length();
        String result="";
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=n;j++){
                String sub=s.substring(i,j);
                if(isNice(sub)&&sub.length()>result.length()){
                    result=sub;
                }
            }
        }
        return result;
    }
    private boolean isNice(String str){
        for(char c:str.toCharArray()){
            if (Character.isLowerCase(c) && 
                !str.contains(Character.toString(Character.toUpperCase(c))))
                return false;
            if (Character.isUpperCase(c) && 
                !str.contains(Character.toString(Character.toLowerCase(c))))
                return false;
        }
        return true;
    }
}
