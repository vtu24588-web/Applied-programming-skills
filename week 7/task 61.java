class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<Integer>[] g=new ArrayList[n];
        int[] indegree=new int[n];
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }
        for(int[] pre:prerequisites){
            int course=pre[0];
            int dependancy=pre[1];
            g[dependancy].add(course);
            indegree[course]++;
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                queue.offer(i);
            }
        }
        int count=0;
        while(!queue.isEmpty()){
            int curr=queue.poll();
            result[count++]=curr;
            for(int neighbour:g[curr]){
                indegree[neighbour]--;
                if(indegree[neighbour]==0){
                    queue.offer(neighbour);
                }
            }
        }
        return (count==n) ? result:new int[0];
    }
}
