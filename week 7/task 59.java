class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] v=new boolean[rooms.size()];
        dfs(0,v,rooms);
        for(int i=0;i<rooms.size();i++){
            if(!v[i]){
                return false;
            }
        }
        return true;
    }
    void dfs(int s,boolean[] v,List<List<Integer>> rooms){
        v[s]=true;
        for(int neigh:rooms.get(s)){
            if(!v[neigh]){
                dfs(neigh,v,rooms);
            }
        }
    }
}
